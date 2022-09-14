package com.tribu.qaselenium.tests.app;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tribu.qaselenium.pages.app.DashboardsP;
import com.tribu.qaselenium.pages.app.HomeP;
import com.tribu.qaselenium.pages.app.LandingP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;
import com.tribu.qaselenium.testframework.utilities.DataProviders;

@Listeners(TestsListenerManager.class)
public class LoadInitiativesTests extends TestBase {
	
	public static String dataProviderFilePath = "src/test/resources/providerFiles/loadInitiatives.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReader", dataProviderClass = DataProviders.class, groups = { "smoke", "deleteContent" })
	public void loadInitiatives(Method method, Map<String,String> provider) {
		// page variables
		LandingP b22LandingP;
		HomeP b22HomeP;
		DashboardsP b22DashboardsP;
		
		String pathName = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "uploadFiles"	+ File.separator + provider.get("file");
		
		/* login */
		b22LandingP = openUrl(LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin"));
		b22DashboardsP = b22HomeP.getDashboards().click(DashboardsP::new).get();
		b22DashboardsP.getUpdateDashboardButton().click()
					.getInputLoadFile().type(pathName)
					.getPeriodSelect().type(provider.get("period"))
					.getSaveUploadButton().click(2000)
					.getSuccesUploadMessage().assertString(WebElement::getText,provider.get("message"),"success message upload does is not displayed")
					.getModalRespUpload()
					.getCloseButton().click().waitForNotVisibility()
					.getModalUpload()
					.getCloseButton().click()
					.verifyLoadFinish().refresh()
					.getAppBusy().waitForNotPresence()
					.assertAll();
	}
}
