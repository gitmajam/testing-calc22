package com.tribu.qaselenium.tests.mazaprendo;

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
public class MAScoreCourseTests extends TestBase {
	
	@SuppressWarnings("unchecked")
	@Test( groups = { "smoke", "aceptance" })
	public void scoreCourse(Method method, ITestContext context) {
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MAMyCoursesP maMyCoursesP;

		SoftAssert softAssert = new SoftAssert();
		String courseTitle = jsonFileReader(context,"apiCreateF2FCourse","MACreateF2FCourseTests","courseName");
		
		/* login */
		maLandingP = openUrl(MALandingP::new, 3000).get();
		maHomeP = maLandingP.login(readCredentials("teacher")).getAppLogo().assertExist(softAssert::assertTrue);

		log.info("Leccion : " + courseTitle);
		maMyCoursesP = maHomeP.getAppLogo().click().getMyCoursesButton().click(MAMyCoursesP::new).get();
		maMyCoursesP.getCoursesList(e->e.getText().contains(courseTitle)).click()
					.getTabList(e->e.getText().contains("Retroalimentación")).click()
					.getItemsList(e->e.getText().contains("100000004")).click()
					.stayBaseElement()
					.getFeedback(e->e.getText().contains("Muy participativo")).click()
					.getSaveButton().click()
					.quitBaseElement()
					.getContinueButton().click()
					.getTabList(e->e.getText().contains("Evaluar")).click()
					.getItemsList(e->e.getText().contains("100000003")).click()
					.stayBaseElement()
					.getScore().type("100")
					.getSaveButton().click()
					.quitBaseElement()
					.getContinueButton().click()
					.getCloseCourse(e->e.getText().contains("finalizar Curso")).click()
					.getContinueButton().click()
					.exec(softAssert::assertAll);
	}
}
