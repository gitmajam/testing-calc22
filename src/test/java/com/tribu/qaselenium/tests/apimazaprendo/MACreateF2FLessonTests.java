package com.tribu.qaselenium.tests.apimazaprendo;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MACreateContentP;
import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class MACreateF2FLessonTests extends TestBase {
	
	public static String dataProviderFilePath = "src/test/resources/providerFiles/faceToFaceLessons.csv";
	
	@Test(dataProvider = "csvReaderMethodFile", dataProviderClass = CsvDataProviders.class, groups = { "smoke" })
	public void createF2FLesson(Method method, ITestContext context, Map<String, String> provider) {
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MACreateContentP maCreateContentP;
		SoftAssert softAssert = new SoftAssert();
		String lessonTitle = provider.get("title") + getTodaysDate() + getSystemTime();
		editTestJSON(method,context,provider.get("order"),lessonTitle);
		String courseTitle = jsonFileReader(context,"apiCreateF2FCourse", "MACreateF2FCourseTests", "courseName" );

		// read csv credentials file depends on environment
		Map<String, String> credentialMap = readCredentials();

		/* login */
		maLandingP = openUrl(MALandingP::new, 2000).get();
		maHomeP = maLandingP.login(credentialMap.get("sharpId1"), credentialMap.get("password1"));

		softAssert.assertTrue(maHomeP.getMenuContentButton().isDisplayed(),
				"Falla Assert login - no encuentra boton de contenido");

		maCreateContentP = maHomeP.getMenuContentButton().click(MACreateContentP::new).get();
		maCreateContentP.getAddContentButton().click()
					.getAddLeccionF2FButton().click()
					.getTitle().type(lessonTitle)
					.getFrame().waitForVisivility().swichToFrame()
					.getBody().type(provider.get("title"))
					.swichToMain()
					.getCursoPadre().type(courseTitle)
					.getOrderInsideCourse().type(provider.get("order"))
					.getTopic().type(provider.get("topic"))
					.getDuracionF2FLesson().clear().type(provider.get("duracion"))
					.getSaveButton().click();

		softAssert.assertTrue(lessonTitle.contains(maCreateContentP.getTitleSumary().getText()),
				"doesn't contain the expected message: " + lessonTitle);

		softAssert.assertAll();
	}
}
