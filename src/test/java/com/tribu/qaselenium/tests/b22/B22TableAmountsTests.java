package com.tribu.qaselenium.tests.b22;

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
public class B22TableAmountsTests extends TestBase {
	
	public static String dataProviderFilePath = "src/test/resources/providerFiles/amounts.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReaderMatrix", dataProviderClass = DataProviders.class,groups = { "smoke", "deleteContent" })
	public void verifyMainTable(Method method,List<Map<String, String>> provider) {
		// page variables
		B22LandingP b22LandingP;
		B22HomeP b22HomeP;
		B22DashboardsP b22DashboardsP;
		
		/* login */
		b22LandingP = openUrl(B22LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin"));
		b22DashboardsP = b22HomeP.getDashboards().click(B22DashboardsP::new).get();
		b22DashboardsP.getAppBusy().waitForNotPresence()
					.verifyAmounts(provider, b22DashboardsP.getSummaryTable().readTable())
					.getTotalInitiatives(e -> e.getText().contentEquals("2288")).assertExist("total initiatives doesn't match")
					.assertAll();
	}
}
