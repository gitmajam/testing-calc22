package com.tribu.qaselenium.tests.apimazaprendo;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MAAssingCourseP;
import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class MAAssignDigitalCourseTests extends TestBase {

	@Test(groups = { "smoke" })
	public void assingDigitalCourse(Method method, ITestContext context) {
		SoftAssert softAssert = new SoftAssert();
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MAAssingCourseP maAssingCourseP;
		
		//asking 
		String sonCourseTitle = "Test-curso-hijo" + getTodaysDate() + getSystemTime();
		String courseTitle = jsonFileReader(context,"apiCreateDigitalCourse","MACreateDigitalCourseTests", "courseName");
		
		String pathName2 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "uploadFiles"	+ File.separator + "upload.xlsx";

		// read csv credentials file depends on environment
		Map<String, String> credentialMap = readCredentials();
	
		/* login */
		maLandingP = openUrl(MALandingP::new, 2000).get();
		maHomeP = maLandingP.login(credentialMap.get("sharpId1"), credentialMap.get("password1"));

		softAssert.assertTrue(maHomeP.getMenuContentButton().isDisplayed(),
				"Falla Assert login - no encuentra boton de contenido");

//		maAssingCourseP = maHomeP.getAppLogo().click()
//								.getAssingCoursesButton().click(MAAssingCourseP::new).get();
		maAssingCourseP = openUrl(MAAssingCourseP::new).get();
		maAssingCourseP.getCreateCourse().click()
					.getSelectCourse().type(courseTitle)
					.getTitleSonCourse().type(sonCourseTitle)
					.getSaveCourseButton().click()
					.getSaveCourseButton().waitForNotVisivility()
					.getAssingCourse().click()
					.getXpathPart2("'" + sonCourseTitle + "')]").click()
					.getUploadAssingFile().type(pathName2)
					.getRegValidationText().waitForVisivility()
					.getAssignCourseButton().click()
					.getAssignCourseButton().waitForNotVisivility();
		
		softAssert.assertAll();
	}
}
