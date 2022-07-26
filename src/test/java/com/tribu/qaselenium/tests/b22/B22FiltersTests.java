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
import com.tribu.qaselenium.pages.b22.B22TargetsP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;
import com.tribu.qaselenium.testframework.utilities.DataProviders;
import com.tribu.qaselenium.testframework.utilities.DataReaders;

@Listeners(TestsListenerManager.class)
public class B22FiltersTests extends TestBase {

	public static String dataProviderFilePath = "src/test/resources/providerFiles/filterLevel1.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReader", dataProviderClass = DataProviders.class, groups = { "smoke",
			"deleteContent" })
	public void filters(Method method, Map<String, String> provider) {
		// page variables
		B22LandingP b22LandingP;
		B22HomeP b22HomeP;
		B22TargetsP b22TargetsP;
		B22DashboardsP b22DashboardsP;
		
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "providerFiles"	+ File.separator + "filterLevel2.csv";
		
		/* login */
		b22LandingP = openUrl(B22LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin")).getLogo().assertExist("main logo is not displayed");
		b22DashboardsP = b22HomeP.getAppBusy().waitForNotPresence()
								.getDashboards().click(B22DashboardsP::new).get();
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
