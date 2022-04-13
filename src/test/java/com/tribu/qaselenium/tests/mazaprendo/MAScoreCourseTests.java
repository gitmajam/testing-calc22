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
		maLandingP = openUrl(MALandingP::new).get();
		maHomeP = maLandingP.login(readCredentials("teacher"),softAssert);

		log.info("Leccion : " + courseTitle);
		maMyCoursesP = maHomeP.getAppLogo().click()
							.getMyCoursesButton().click(MAMyCoursesP::new).get();
		maMyCoursesP//.getCoursesList(e->e.getText().contains(courseTitle)).click()
					.getTabList(e->e.getText().contains("Evaluar")).click()
					.getItemsList(e->e.getText().contains("100000003")).click()
					.getScore().type("100")
					.getSaveButton().click()
					.getContinueButton().click().waitForNotVisibility()
					.getItemsList(e->e.getText().contains("100000003"),e->e.getAttribute("style").contains("rgb(206, 235, 207)"))
					.assess(softAssert::assertFalse, "button has not saved color")
					.getItemsList(e->e.getText().contains("100000004")).click()
					.getScore().type("100")
					.getSaveButton().click()
					.getContinueButton().click().waitForNotVisibility()
					.getItemsList(e->e.getText().contains("100000004"),e->e.getAttribute("style").contains("rgb(206, 235, 207)"))
					.assess(softAssert::assertFalse, "button has not saved color")
					.getCloseCourse(e->e.getText().contains("finalizar Curso")).click()
					.getContinueButton().click().waitForNotVisibility()
					.getCloseCourse(e->e.getText().contains("finalizar Curso")).waitForNotVisibility()
					.assess(softAssert::assertFalse, "close course button is still displayed")
					.exec(softAssert::assertAll);
	}
}
