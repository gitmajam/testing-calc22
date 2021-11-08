package com.tribu.qaselenium.tests.planetaberrway;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.apiba.APICreateContentP;
import com.tribu.qaselenium.pages.apiba.APIEditContentP;
import com.tribu.qaselenium.pages.apiba.APIHomeP;
import com.tribu.qaselenium.pages.apiba.APILandingP;
import com.tribu.qaselenium.pages.apiba.APILoginP;
import com.tribu.qaselenium.pages.beerpassion.BPHomeP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class PBSessionTests extends TestBase {

	APILandingP apiLandingP;
	APILoginP apiLoginP;
	APIHomeP apiHomeP;
	APICreateContentP apiCreateContentP;
	APIEditContentP apiEditContentP;
	BPHomeP bpHomeP;
	String actualSuccessMessage;
	/*
	 * this method runs according the dataprovider parameter set, either in parallel
	 * or sequentially
	 */

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class, groups = { "smoke", "regression" })
	public void logInTest(Map<String, String> testData) {

		/*
		 * this kind of assert does not stop the execution but lets execute the whole
		 * assertions
		 */
		SoftAssert softAssert = new SoftAssert();
		log.info("[" + driverFactory.getDriver().hashCode() + "] starting loginTest");

		// Data from dataprovider
		String no = testData.get("no");
		String sharpID = testData.get("sharpID");
		String password = testData.get("password");
		String expectedSuccessMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		// procedure
		apiLandingP = openUrl(APILandingP::new).get();
		apiLoginP = apiLandingP.getLoginButton().click(APILoginP::new).get();
		//apiLoginP.typeCredentials(sharpID, password);

		// Assertions
		String errorMessage = "Expected message: " + expectedSuccessMessage + " vs actual message: "
				+ actualSuccessMessage + "\n";

		// URL
		softAssert.assertEquals(apiHomeP.getCurrentUrl(), apiHomeP.getPageUrl());
		// Message
		//softAssert.assertEquals(apiHomeP.getSharpIdText(), expectedSuccessMessage, errorMessage);
		// Button
		softAssert.assertTrue(apiHomeP.getProfileMenuButton().isDisplayed());

		softAssert.assertAll();
	}

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class, groups = { "regression",
			"acceptance" })
	public void loadLinkList(Method method,Map<String, String> testData) {

		/*
		 * this kind of assert does not stop the execution but lets execute the whole
		 * assertions
		 */
		
		log.info("[" + driverFactory.getDriver().hashCode() + "] starting loginTest");

		// Data from dataprovider
		String no = testData.get("no");
		String sharpID = testData.get("sharpID");
		String password = testData.get("password");
		String expectedSuccessMessage1 = testData.get("expected-message1");
		String expectedSuccessMessage2 = testData.get("expected-message2");
		String titulo = testData.get("titulo");
		String description = testData.get("description");
		String imageContent = testData.get("image-content");
		String link = testData.get("link");
		String section = testData.get("section");
		String column = testData.get("column");
		String country = testData.get("country");
		String caseDescription = testData.get("case-description");
		
		//create path for upload files
		String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator
				+ "images" + File.separator + method.getDeclaringClass().getSimpleName() + File.separator
				+ method.getName() + File.separator + imageContent;
		
		SoftAssert softAssert = new SoftAssert();
		
		//creates error messages for asserts
		String errorMessage1 = "Expected message: " + expectedSuccessMessage1 + " vs actual message: "
				+ actualSuccessMessage + "\n";
		String errorMessage2 = "Expected message: " + expectedSuccessMessage2 + " vs actual message: "
				+ actualSuccessMessage + "\n";

		// procedure
		apiLandingP = openUrl(APILandingP::new).get();
		apiLoginP = apiLandingP.getLoginButton().click(APILoginP::new).get();
		apiHomeP = apiLoginP.getSharpIdField()
				.type(sharpID)
				.getPasswordField()
				.type(password)
				.getLoginButton()
				.click(APIHomeP::new).get();
		
		apiCreateContentP = apiHomeP.getMenuContentButton()
		        .hoverElement()
		        .getAddContentButton()
		        .click(APICreateContentP::new).get();
		
		apiCreateContentP.getTitle().type(titulo)
				.getFrame().swichToFrame()
				.getBody().type(description)
				.swichToMain()
				.getMainImage().type(dir)
				.getLink().type(link)
				.getSection().type(section)
				.getColumn().click()
				.getColumnItem().click()
				.getCountry().type(country)
				.getMainImageIcon().waitForImage();

		
		// Assertions
		// Message1
		//softAssert.assertEquals(apiEditContentP.getMesage1().getText(), expectedSuccessMessage1, errorMessage1);
		// Message2
		//softAssert.assertEquals(apiEditContentP.getMesage2().getText(), expectedSuccessMessage2, errorMessage1);

		//softAssert.assertAll();

	}
}
