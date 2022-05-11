package com.tribu.qaselenium.tests.b22;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.b22.B22DashboardsP;
import com.tribu.qaselenium.pages.b22.B22HomeP;
import com.tribu.qaselenium.pages.b22.B22LandingP;
import com.tribu.qaselenium.pages.b22.B22TargetsP;
import com.tribu.qaselenium.pages.b22.B22UnmappedP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class B22UnmappedTests extends TestBase {

	public static String dataProviderFilePath = "src/test/resources/providerFiles/filtersDashboard.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReaderMatrix", dataProviderClass = CsvDataProviders.class, groups = { "smoke",
			"deleteContent" })
	public void unmapped(Method method, List<Map<String, String>> provider) {
		// page variables
		B22LandingP b22LandingP;
		B22HomeP b22HomeP;
		B22TargetsP b22TargetsP;
		B22UnmappedP b22UnmappedP;

		/* login */
		b22LandingP = openUrl(B22LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin")).getLogo().assertExist("main logo is not displayed");
		b22UnmappedP = b22HomeP.getAppBusy().waitForNotPresence()
								.getUnmapped().click(B22UnmappedP::new).get();
		
		b22UnmappedP.getAppBusy().waitForNotPresence()
					.getSaveButton(e -> e.isEnabled()).assertNotExist("save button is enabled")
					.getUnmappedTable()
					.fillUnmapped()
					.getSaveButton(e -> e.isEnabled()).assertExist("save button is not enabled").click()
					.getAppBusy().waitForNotPresence()
					.getModal().assertExist("modal is not displayed")
					.getButton(e -> e.getText().contains("Accept")).click()
					.assertAll();
		
	}
}
