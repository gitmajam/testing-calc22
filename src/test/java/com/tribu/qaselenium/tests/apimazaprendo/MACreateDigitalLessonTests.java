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
public class MACreateDigitalLessonTests extends TestBase {
	
	public static String dataProviderFilePath = "src/test/resources/providerFiles/digitalLessons.csv";
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReaderMethodFile", dataProviderClass = CsvDataProviders.class, groups = { "smoke" })
	public void createDigitalLesson(Method method, ITestContext context, Map<String, String> provider) {
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MACreateContentP maCreateContentP;
		SoftAssert softAssert = new SoftAssert();
		String lessonTitle = provider.get("title") + getTodaysDate() + getSystemTime();
		editTestJSON(method,context,provider.get("order"),lessonTitle);
		String courseTitle = jsonFileReader(context,"apiCreateDigitalCourse", "MACreateDigitalCourseTests", "courseName" );

		/* login */
		maLandingP = openUrl(MALandingP::new, 3000).get();
		maHomeP = maLandingP.login(readCredentials("admin")).getAppLogo().assertExist(softAssert::assertTrue);

		maCreateContentP = maHomeP.getMenuContentButton().click(MACreateContentP::new).get();
		maCreateContentP.getAddContentButton().click()
					.getAddLeccionButton().click()
					.getTitle().type(lessonTitle)
					.getFrame().waitForVisibility().swichToFrame()
					.getBody().type(provider.get("title"))
					.swichToMain()
					.getCursoPadre().type(courseTitle)
					.getOrderInsideCourse().type(provider.get("order"))
					.loadContentType(provider)
					.getTopic().type(provider.get("topic"))
					.getDuracion().clear().type(provider.get("duracion"))
					.getAttempts().clear().type(provider.get("attempts"))
					.getMinScore().clear().type(provider.get("minScore"))
					.getSaveButton().click()
					.getMessageLeccionCreation(e->e.getText().contains(lessonTitle)).assertExist(softAssert::assertTrue)
					.exec(softAssert::assertAll);

	}
}
