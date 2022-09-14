package com.tribu.qaselenium.tests.app;

import java.io.File;
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
import com.tribu.qaselenium.testframework.utilities.DataReaders;

@Listeners(TestsListenerManager.class)
public class FiltersTests extends TestBase {

	public static String dataProviderFilePath = "src/test/resources/providerFiles/filterLevel1.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReader", dataProviderClass = DataProviders.class, groups = { "smoke",
			"deleteContent" })
	public void filters(Method method, Map<String, String> provider) {
		// page variables
		LandingP b22LandingP;
		HomeP b22HomeP;
		TargetsP b22TargetsP;
		DashboardsP b22DashboardsP;
		
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "providerFiles"	+ File.separator + "filterLevel2.csv";
		
		/* login */
		b22LandingP = openUrl(LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin")).getLogo().assertExist("main logo is not displayed");
		b22DashboardsP = b22HomeP.getAppBusy().waitForNotPresence()
								.getDashboards().click(DashboardsP::new).get();
		b22DashboardsP.getAppBusy().waitForNotPresence()
						.getGraphics().centerElement(1000)
						.getButton(e -> e.getText().contentEquals("Clear filters")).click()
						.getAppBusy().waitForNotPresence()
						.getFilter(e -> e.getText().contains(provider.get("filter"))).getSelect().click()
						.getItem(e -> e.getText().contentEquals(provider.get("item"))).click()
						.getSearchButton().click()
						.getAppBusy().waitForNotPresence()
						.getTotalInitiatives(e -> e.getText().contentEquals(provider.get("initiatives")))
						.assertExist("total initiatives period : " + provider.get("item") + " doesn't match")
						.verifyFilters(provider.get("item"), DataReaders.csvReaderList(path))
						.getAppBusy().waitForNotPresence()
//						.verifyCombinedFilters(provider)
						.assertAll();
	}
}
