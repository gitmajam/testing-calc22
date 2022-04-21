package com.tribu.qaselenium.tests.b22;

import java.io.File;
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
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class B22DiscardInitiativesTests extends TestBase {
	
	public static String dataProviderFilePath = "src/test/resources/providerFiles/amounts.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReaderMatrix", dataProviderClass = CsvDataProviders.class,groups = { "smoke", "deleteContent" })
	public void initialLoadInitiatives(Method method,List<Map<String, String>> provider) {
		SoftAssert softAssert = new SoftAssert();
		// page variables
		B22LandingP b22LandingP;
		B22HomeP b22HomeP;
		B22TargetsP b22TargetsP;
		B22DashboardsP b22DashboardsP;
		
		String pathName = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "uploadFiles"	+ File.separator + "discardTemplate.xlsx";

		/* login */
		b22LandingP = openUrl(B22LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin"), softAssert).getLogo().assess(softAssert::assertTrue,
				"main logo is not displayed");
		b22DashboardsP = b22HomeP.getDashboards().click(B22DashboardsP::new).get();
		b22DashboardsP.getUpdateDashboardButton().click()
					.getInputLoadFile().type(pathName)
					.getPeriodSelect().type("0+12")
					.getSaveUploadButton().click()
					.getSuccesUploadMessage(e -> e.getText().contains("se envió correctamente"))
					.assess(softAssert::assertTrue, "success message upload does is not displayed")
					.getButton(e -> e.getText().contains("Accept")).click().waitForNotVisibility()
					.getCloseButton().click()
					.verifyLoadFinish(softAssert)
					.exec(softAssert::assertAll);
	}
}
