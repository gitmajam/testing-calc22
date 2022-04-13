package com.tribu.qaselenium.tests.mazaprendo;

import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.pages.mazaprendo.MAPerfomCourseP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class MACheckNpsF2FCoursesTests extends TestBase {
	
	@SuppressWarnings("unchecked")
	@Test( groups = { "smoke",
			"deleteContent" })
	public void uploadEvidence(Method method, ITestContext context) {
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MAPerfomCourseP maPerformCourseP;

		SoftAssert softAssert = new SoftAssert();
		String courseTitle = jsonFileReader(context,"apiCreateF2FCourse","MACreateF2FCourseTests","courseName");
		
		/* login */
		maLandingP = openUrl(MALandingP::new, 3000).get();
		maHomeP = maLandingP.login(readCredentials("admin"),softAssert);

		log.info("Leccion : " + courseTitle);
		maPerformCourseP = maHomeP.getCardList(e->e.getText().contains(courseTitle))
				.getCardButton(e->e.getText().contains("Ver Mas")).click(MAPerfomCourseP::new).get();
		maPerformCourseP.getModalMessage().ifFoundOrElse(maPerformCourseP::closeModal,null)
						.uploadEvidence()
						.getEvidencesList(e->e.getText().contains("certs.pdf")).assess(softAssert::assertTrue)
						.getEvidencesList(e->e.getText().contains("Test-miniImage1.jpeg")).assess(softAssert::assertTrue)
						.getEvidencesList(e->e.getText().contains("upload.xlsx")).assess(softAssert::assertTrue)
						.exec(softAssert::assertAll);
	}
}
