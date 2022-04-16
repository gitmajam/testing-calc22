package com.tribu.qaselenium.tests.apimazaprendo;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Supplier;
import com.tribu.qaselenium.pages.mazaprendo.MACreateContentP;
import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class MACreateF2FCourseTests extends TestBase {
	
	public static String dataProviderFilePath = "src/test/resources/providerFiles/f2FCourses.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReaderMethodFile", dataProviderClass = CsvDataProviders.class, groups = { "smoke" })
	public void createF2FCourse(Method method,ITestContext context, Map<String, String> provider) {
		SoftAssert softAssert = new SoftAssert();
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MACreateContentP maCreateContentP;
	
		String courseTitle = provider.get("title") + getTodaysDate() + getSystemTime();
		editTestJSON(method,context,"courseName" ,courseTitle);
		editTestJSON(method,context,"recordCheck",provider.get("recordCheck"));

		/* path for mainImage */
		String dirMainImg = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "media" + File.separator + "image" + File.separator + provider.get("coverImage");

		/* login */
		maLandingP = openUrl(MALandingP::new, 3000).get();
		maHomeP = maLandingP.login(readCredentials("admin"),softAssert);

		maCreateContentP = maHomeP.getMenuContentButton().click(MACreateContentP::new).get();
		maCreateContentP.getAddContentButton().click()
					.getAddCursoButton().click()
					.getTitle().type(courseTitle)
					.getFrame(e->e.isDisplayed()).swichToFrame()
					.getBody(e->e.isDisplayed()).type(provider.get("description"))
					.swichToMain()
					.getCursoType().type(provider.get("courseType"))
					.getDuracion().clear().type(provider.get("duracion"))
					.getTopic().type(provider.get("topic"))
					.getCoverImg().type(dirMainImg)
					.getPreviewCoverImage()
					.getAltCoverText().type(provider.get("altCoverText"))
					.getMinScore().clear().type(provider.get("minScore"))
					.getAttempts().clear().type(provider.get("attempts"))
					.getSaveButton().click()
					.getMessageCursoCreation(e->e.getText().contains(courseTitle)).assess(softAssert::assertTrue)
					.exec(softAssert::assertAll);
	}
}
