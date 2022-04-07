package com.tribu.qaselenium.tests.apimazaprendo;

import java.io.File;
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
public class MACreateDigitalCourseTests extends TestBase {
	
	public static String dataProviderFilePath = "src/test/resources/providerFiles/digitalCourses.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReaderMethodFile", dataProviderClass = CsvDataProviders.class, groups = { "smoke" })
	public void createDigitalCourse(Method method,ITestContext context, Map<String, String> provider) {
		SoftAssert softAssert = new SoftAssert();
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MACreateContentP maCreateContentP;
		
		/*storing created course  status in order to be used by other test*/
		String cursoTitle = provider.get("title") + getTodaysDate() + getSystemTime();
		editTestJSON(method,context,"courseName" ,cursoTitle);
		editTestJSON(method,context,"recordCheck",provider.get("recordCheck"));

		/* path for mainImage */
		String dirMainImg = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "media" + File.separator + "image" + File.separator + provider.get("coverImage");

		/* login */
		maLandingP = openUrl(MALandingP::new, 3000).get();
		maHomeP = maLandingP.login(readCredentials("admin")).getAppLogo().assertExist(softAssert::assertTrue);

		maCreateContentP = maHomeP.getMenuContentButton().click(MACreateContentP::new).get();
		maCreateContentP.getAddContentButton().click()
					.getAddCursoButton().click()
					.getTitle().type(cursoTitle)
					.getFrame().swichToFrame()
					.getBody().type(provider.get("description"))
					.swichToMain()
					.getCursoType().type(provider.get("courseType"))
					.getDuracion().clear().type(provider.get("duracion"))
					.getTopic().type(provider.get("topic"))
					.getCoverImg().type(dirMainImg)
					.getPreviewCoverImage().waitForImage()
					.getAltCoverText().type(provider.get("altCoverText"))
					.getMinScore().clear().type(provider.get("minScore"))
					.getAttempts().clear().type(provider.get("attempts"))
					.getSaveButton().click()
					.getMessageCursoCreation(e->e.getText().contains(cursoTitle)).assertExist(softAssert::assertTrue)
					.exec(softAssert::assertAll);

	}
}
