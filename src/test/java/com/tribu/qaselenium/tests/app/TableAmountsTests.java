package com.tribu.qaselenium.tests.app;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tribu.qaselenium.pages.app.DashboardsP;
import com.tribu.qaselenium.pages.app.HomeP;
import com.tribu.qaselenium.pages.app.LandingP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;
import com.tribu.qaselenium.testframework.utilities.DataProviders;
import com.tribu.qaselenium.testframework.utilities.DataReaders;

@Listeners(TestsListenerManager.class)
public class TableAmountsTests extends TestBase {
	
	public static String dataProviderFilePath = resourcesPath + "providerFiles" +  File.separator + "amounts.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReaderMatrix", dataProviderClass = DataProviders.class,groups = { "smoke", "deleteContent" })
	public void verifyMainTable(ITestContext testContext, List<Map<String, String>> provider) {
		// page variables
		LandingP b22LandingP;
		HomeP b22HomeP;
		DashboardsP b22DashboardsP;

		String amount = testContext.getCurrentXmlTest().getParameter("amount");
		String initiatives = amount.contentEquals("amount1") ? "2288":"2293";
		
		/* login */
		b22LandingP = openUrl(LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin"));
		b22DashboardsP = b22HomeP.getDashboards().click(DashboardsP::new).get();
		b22DashboardsP.getAppBusy().waitForNotPresence()
					.verifyAmounts(provider, b22DashboardsP.getSummaryTable().readTable(), amount)
					.getTotalInitiatives().assess(e -> e.getText().contentEquals(initiatives),"total initiatives doesn't match")
					.assertAll();
	}
}
