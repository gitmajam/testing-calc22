package com.tribu.qaselenium.tests.app;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tribu.qaselenium.pages.app.HomeP;
import com.tribu.qaselenium.pages.app.LandingP;
import com.tribu.qaselenium.pages.app.OthersP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;
import com.tribu.qaselenium.testframework.utilities.DataProviders;

@Listeners(TestsListenerManager.class)
public class OthersTests extends TestBase {

	public static String dataProviderFilePath = resourcesPath + "providerFiles" +  File.separator + "others.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReader", dataProviderClass = DataProviders.class, groups = { "smoke",
			"deleteContent" })
	public void createOthers(Method method, Map<String, String> provider) {
		// page variables
		LandingP b22LandingP;
		HomeP b22HomeP;
		OthersP b22OthersP;
		
		/* login */
		b22LandingP = openUrl(LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin"))	
								.getLogo().assess(WebElement::isDisplayed,"main logo is not displayed");
		b22OthersP = b22HomeP.getAppBusy().waitForNotPresence()
								.getOthers().click(OthersP::new).get();
		b22OthersP.getAppBusy().waitForNotPresence()
		.getNewInitiative().click()
		.getCode().type(provider.get("code"))
		.getTitle().type(provider.get("title"))
		.getOwnerName().type(provider.get("ownerName"))
		.getDescription().type(provider.get("initiativeDescription"))
		.getBu().type(provider.get("bu"))
		.getCountry().type(provider.get("country"))
		.getStatus().type(provider.get("status"))
		.getRisk().type(provider.get("riskProfile"))
		.getStartDate().type(provider.get("startDate"))
		.getDuration().type(provider.get("duration"))
		.getInitiativeType().type(provider.get("InitiativeType"))
		.getAnualized().type(provider.get("anualized"))
		.getCalendarized().type(provider.get("calendarized"))
		.getJan().type(provider.get("jan"))
		.getFeb().type(provider.get("feb"))
		.getMar().type(provider.get("mar"))
		.getApr().type(provider.get("apr"))
		.getMay().type(provider.get("may"))
		.getJun().type(provider.get("jun"))
		.getJul().type(provider.get("jul"))
		.getAug().type(provider.get("aug"))
		.getSep().type(provider.get("sep"))
		.getOct().type(provider.get("oct"))
		.getNov().type(provider.get("nov"))
		.getDec().type(provider.get("dec"))	
		.getSaveButton().click()
		.getModalAcceptMessage().assertString(e -> e.getText(),provider.get("message"))
		.getModalAcceptButton().click()
		.assertAll();
	}
}
