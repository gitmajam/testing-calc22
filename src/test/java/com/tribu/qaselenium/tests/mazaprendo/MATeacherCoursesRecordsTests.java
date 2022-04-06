package com.tribu.qaselenium.tests.mazaprendo;

import java.lang.reflect.Method;
import java.util.Map;

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
public class MATeacherCoursesRecordsTests extends TestBase {
	
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
		maHomeP = maLandingP.login(readCredentials("student"));

		softAssert.assertTrue(maHomeP.getAppLogo().isDisplayed(),
				"Falla Assert login - no encuentra boton de contenido");
		log.info("Leccion : " + courseTitle);
		maPerformCourseP = maHomeP.getXpathPart1(courseTitle).click(MAPerfomCourseP::new).get();
		maPerformCourseP.getModalMessage().check(e->e.isDisplayed()).andThen(maPerformCourseP::closeModal)
						.uploadEvidence();
		
		softAssert.assertAll();
	}
}
