package com.tribu.qaselenium.tests.negative;

import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.apiba.APIHomeP;
import com.tribu.qaselenium.pages.apiba.APILandingP;
import com.tribu.qaselenium.pages.apiba.APILoginP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class NegativeTests extends TestBase {

	APILandingP apiLandingP;
	APILoginP apiLoginP;
	APIHomeP apiHomeP;

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLoginTest(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();

		// Data
		String no = testData.get("no");
		String sharpID = testData.get("sharpID");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		log.info("Starting negativeLoginTest #" + no + "for" + description);

		String variable1 = testData.get("variable1");
		String variable2 = testData.get("variable2");
		String variable3 = testData.get("variable3");
		
		Integer result1 = Integer.parseInt(variable1) + Integer.parseInt(variable2) + Integer.parseInt(variable3);
		log.info("result-1 = " + result1);
		
		apiLandingP = openUrl(APILandingP::new).get();
		apiLoginP = apiLandingP.getLoginButton().click(APILoginP::new).get();
		apiHomeP = apiLoginP.getSharpIdField().type(sharpID).getPasswordField().type(password).getLoginButton()
				.click(APIHomeP::new).get();
		
		Integer result2 = Integer.parseInt(variable1) + Integer.parseInt(variable2) - Integer.parseInt(variable3);
		log.info("result-2 = " + result2);
		
		Integer totResult = result1+ result2;
		log.info("Tot-result = " + totResult);
	}
}
