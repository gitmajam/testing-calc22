package com.tribu.qaselenium.tests.b22;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tribu.qaselenium.pages.b22.B22DashboardsP;
import com.tribu.qaselenium.pages.b22.B22HomeP;
import com.tribu.qaselenium.pages.b22.B22LandingP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;
import com.tribu.qaselenium.testframework.utilities.DataProviders;
import com.tribu.qaselenium.testframework.utilities.DataReaders;

@Listeners(TestsListenerManager.class)
public class B22TableAmountsTests extends TestBase {
	
	public static String dataProviderFilePath = resourcesPath + "providerFiles" +  File.separator + "amounts.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReaderMatrix", dataProviderClass = DataProviders.class,groups = { "smoke", "deleteContent" })
	public void verifyMainTable(ITestContext testContext, List<Map<String, String>> provider) {
		// page variables
		B22LandingP b22LandingP;
		B22HomeP b22HomeP;
		B22DashboardsP b22DashboardsP;

		String amount = testContext.getCurrentXmlTest().getParameter("amount");
		String initiatives = amount.contentEquals("amount1") ? "2288":"2293";
		
		/* login */
		b22LandingP = openUrl(B22LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin"));
		b22DashboardsP = b22HomeP.getDashboards().click(B22DashboardsP::new).get();
		b22DashboardsP.getAppBusy().waitForNotPresence()
					.verifyAmounts(provider, b22DashboardsP.getSummaryTable().readTable(), amount)
					.getTotalInitiatives().assess(e -> e.getText().contentEquals(initiatives),"total initiatives doesn't match")
					.assertAll();
	}
}
