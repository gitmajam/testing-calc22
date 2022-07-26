package com.tribu.qaselenium.tests.b22;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tribu.qaselenium.pages.b22.B22DashboardsP;
import com.tribu.qaselenium.pages.b22.B22HomeP;
import com.tribu.qaselenium.pages.b22.B22LandingP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;
import com.tribu.qaselenium.testframework.utilities.DataProviders;

@Listeners(TestsListenerManager.class)
public class B22LoadInitiativesTests extends TestBase {
	
	public static String dataProviderFilePath = "src/test/resources/providerFiles/loadInitiatives.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReader", dataProviderClass = DataProviders.class, groups = { "smoke", "deleteContent" })
	public void loadInitiatives(Method method, Map<String,String> provider) {
		// page variables
		B22LandingP b22LandingP;
		B22HomeP b22HomeP;
		B22DashboardsP b22DashboardsP;
		
		String pathName = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "uploadFiles"	+ File.separator + provider.get("file");

		/* login */
		b22LandingP = openUrl(B22LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin"));
		b22DashboardsP = b22HomeP.getDashboards().click(B22DashboardsP::new).get();
		b22DashboardsP.getUpdateDashboardButton().click()
					.getInputLoadFile().type(pathName)
					.getPeriodSelect().type(provider.get("period"))
					.getSaveUploadButton().click()
					.getSuccesUploadMessage(e -> e.getText().contains("se envió correctamente"))
					.assertExist("success message upload does is not displayed")
					.getModalRespUpload()
					.getCloseButton().click().waitForNotVisibility()
					.getModalUpload()
					.getCloseButton().click()
					.verifyLoadFinish().refresh()
					.getAppBusy().waitForNotPresence()
					.assertAll();
	}
}
