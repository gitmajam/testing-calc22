package com.tribu.qaselenium.tests.app;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tribu.qaselenium.pages.app.DashboardsP;
import com.tribu.qaselenium.pages.app.HomeP;
import com.tribu.qaselenium.pages.app.LandingP;
import com.tribu.qaselenium.pages.app.TargetsP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;
import com.tribu.qaselenium.testframework.utilities.DataProviders;

@Listeners(TestsListenerManager.class)
public class TargetsTests extends TestBase {

	public static String dataProviderFilePath = "src/test/resources/providerFiles/targets.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReaderMatrix", dataProviderClass = DataProviders.class, groups = { "smoke",
			"deleteContent" })
	public void loadTargets(Method method, List<Map<String, String>> provider) {
		// page variables
		LandingP b22LandingP;
		HomeP b22HomeP;
		TargetsP b22TargetsP;
		DashboardsP b22DashboardsP;

		/* login */
		b22LandingP = openUrl(LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin")).getLogo().assertExist("main logo is not displayed");
		b22TargetsP = b22HomeP.getTargets().click(TargetsP::new).get();
		b22DashboardsP = b22TargetsP.getYear(e -> e.getText().contains("2022")).click()
					.setTargets(provider)
					.getDashboards().click(DashboardsP::new).get();
		
		b22DashboardsP.getAppBusy().waitForNotPresence()
					.verifyTargets(provider, b22DashboardsP.getSummaryTable().readTable())
					.assertAll();
	}
}
