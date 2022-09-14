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
import com.tribu.qaselenium.pages.app.ReportsFunctionP;
import com.tribu.qaselenium.pages.app.TargetsP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;
import com.tribu.qaselenium.testframework.utilities.DataProviders;
import com.tribu.qaselenium.testframework.utilities.DataReaders;

@Listeners(TestsListenerManager.class)
public class ReportsFunctionTests extends TestBase {

	public static String dataProviderFilePath = "src/test/resources/providerFiles/filterReportsFunction.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReaderMatrix", dataProviderClass = DataProviders.class, groups = { "smoke",
			"deleteContent" })
	public void reportFunctions(Method method, List<Map<String, String>> provider) {
		// page variables
		LandingP b22LandingP;
		HomeP b22HomeP;
		ReportsFunctionP b22ReportsFunctionP;
		
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "providerFiles"	+ File.separator + "filterReportsFunction.csv";
		
		/* login */
		b22LandingP = openUrl(LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin")).getLogo().assess(WebElement::isDisplayed,"main logo is not displayed");
		b22ReportsFunctionP = b22HomeP.getReports().click(ReportsFunctionP::new).get();
		b22ReportsFunctionP.verifyTargetPercentages(provider)
							.assertAll();
	}
}
