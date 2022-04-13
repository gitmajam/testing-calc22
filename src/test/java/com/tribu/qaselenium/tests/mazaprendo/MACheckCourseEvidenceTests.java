package com.tribu.qaselenium.tests.mazaprendo;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.By;

import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import org.openqa.selenium.WebElement;

import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.pages.mazaprendo.MAMyCoursesP;
import com.tribu.qaselenium.pages.mazaprendo.MAPerfomCourseP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class MACheckCourseEvidenceTests extends TestBase {
	
	@SuppressWarnings("unchecked")
	@Test( groups = { "smoke", "aceptance" })
	public void CheckCourseEvidence(Method method, ITestContext context) {
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MAMyCoursesP maMyCoursesP;
		
		String downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
		log.info(downloadPath);
		
		SoftAssert softAssert = new SoftAssert();
		String courseTitle = jsonFileReader(context,"apiCreateF2FCourse","MACreateF2FCourseTests","courseName");
		
		/* login */
		maLandingP = openUrl(MALandingP::new).get();
		maHomeP = maLandingP.login(readCredentials("teacher"),softAssert);

		log.info("Leccion : " + courseTitle);
		maMyCoursesP = maHomeP.getAppLogo().click()
							.getMyCoursesButton().click(MAMyCoursesP::new).get();
		maMyCoursesP.getCoursesList(e->e.getText().contains(courseTitle)).click()
					.getTabList(e->e.getText().contains("Evidencia")).click()
					.getItemsList(e->e.getText().contains("100000003")).click()
					.getEvidenceLink(e->e.getText().contains("certs.pdf"))
					.assess(softAssert::assertTrue,"certs.pdf")
					.getEvidenceLink(e->e.getText().contains("upload.xlsx"))
					.assess(softAssert::assertTrue,"upload.xlsx")
					.getEvidenceLink(e->e.getText().contains("certs.pdf")).click()
					.exec(()-> softAssert.assertTrue(maMyCoursesP.isFileDownloaded(downloadPath, "certs.pdf"), "file not downloaded"))
					.exec(softAssert::assertAll);
	}
}
