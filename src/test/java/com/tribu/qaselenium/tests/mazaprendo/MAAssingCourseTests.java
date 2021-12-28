package com.tribu.qaselenium.tests.mazaprendo;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiFunction;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MAAssingCourseP;
import com.tribu.qaselenium.pages.mazaprendo.MAContentListP;
import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.pages.sso.SSOLandingP;
import com.tribu.qaselenium.pages.sso.SSOLoginP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class MAAssingCourseTests extends TestBase {

	// page variables
	MALandingP maLandingP;
	MAHomeP maHomeP;
	MAContentListP maContentListP;
	MAAssingCourseP maAssingCourseP;

	SSOLandingP ssoLandingP;
	SSOLoginP ssoLoginP;

	// assert variables
	String actualSuccessMessage;

	BiFunction<String, String, MAHomeP> maLogin = (s, p) -> {
		//open an url with a delay
		maLandingP = openUrl(MALandingP::new, 2000).get();
		ssoLandingP = maLandingP.getLoginButton().click(SSOLandingP::new).get();
		ssoLoginP = ssoLandingP.getSharpIdButton().click(SSOLoginP::new).get();
		maHomeP = ssoLoginP.getSharpIdField().type(s)
				.getPasswordField().type(p)
				.getLoginButton().click(MAHomeP::new).get();
		return maHomeP;
	};

	@Test(dataProvider = "csvReaderCredentials", dataProviderClass = CsvDataProviders.class, groups = { "smoke",
			"deleteContent" })
	public void assingCourse(Method method, Map<String, String> dataList) {
		log.info("assingCourse");
		SoftAssert softAssert = new SoftAssert();
		String sharpId1 = dataList.get("sharpId1");
		String password1 = dataList.get("password1");
		String sonCourseTitle = "Test-curso-hijo" + getTodaysDate() + getSystemTime();

		/* load content file */
		String pathName1 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "MACreateCourseTests" + File.separator
				+ "dataproviders" + File.separator + "MACreateCourseTests.csv";
		
		String pathName2 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + method.getDeclaringClass().getSimpleName() + File.separator
				+ "Upload.xlsx";

		/* login */
		maHomeP = maLogin.apply(sharpId1, password1);

		softAssert.assertTrue(maHomeP.getMenuContentButton().isDisplayed(),
				"[Falla Assert - no encuentra boton de contenido");

		maAssingCourseP = maHomeP.getAppLogo().click()
				.getAssingCoursesButton().click(MAAssingCourseP::new).get();
		//maAssingCourseP = openUrl(MAAssingCourseP::new).get();

		// read csv data file
		Iterator<Map<String, String>> dataSet;
		dataSet = csvReader(pathName1);

		while (dataSet.hasNext()) {
	
			Map<String, String> dataMap = dataSet.next();
			
			if (dataMap.get("contentType").equals("curso")) {
				String title = dataMap.get("title");
				log.info("titulo" + title + getTodaysDate());
				maAssingCourseP.getCreateCourse().click()
				.getSelectCourse().click()
				.getXpathPart1("'" + title + getTodaysDate() + "')]").click()
				.getTitleSonCourse().type(sonCourseTitle);
				maAssingCourseP.getSaveCourseButton().click()
				.getSaveCourseButton().waitForNotVisivility()
				.getAssingCourse().click()
				.getXpathPart2("'" + sonCourseTitle + "')]").click()
				.getUploadAssingFile().type(pathName2);
				maAssingCourseP.getRegValidationText().waitForVisivility()
				.getAssignCourseButton().click();
			}
		}
		softAssert.assertAll();
	}
}
