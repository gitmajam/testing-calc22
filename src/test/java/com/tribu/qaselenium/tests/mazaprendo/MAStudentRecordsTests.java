package com.tribu.qaselenium.tests.mazaprendo;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiFunction;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MACertificatesP;
import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.pages.mazaprendo.MAPerfomCourseP;
import com.tribu.qaselenium.pages.sso.SSOLandingP;
import com.tribu.qaselenium.pages.sso.SSOLoginP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class MAStudentRecordsTests extends TestBase {

	// page variables
	MALandingP maLandingP;
	MAHomeP maHomeP;
	MACertificatesP maCertificatesP;

	SSOLandingP ssoLandingP;
	SSOLoginP ssoLoginP;

	// assert variables
	String actualSuccessMessage;

	// content variables

	String sharpId2;
	String password2;
	String expectedMessage1;
	String expectedMessage2;
	String testDescription;
	String userId;
	String email;

	BiFunction<String, String, MAHomeP> maLogin = (s, p) -> {
		// open an url with a delay
		maLandingP = openUrl(MALandingP::new, 2000).get();
		ssoLandingP = maLandingP.getLoginButton().click(SSOLandingP::new).get();
		ssoLoginP = ssoLandingP.getVideoCloseButton().click()
				.getSharpIdButton().click(SSOLoginP::new).get();
		maHomeP = ssoLoginP.getSharpIdField().type(s).getPasswordField().type(p).getLoginButton().click(MAHomeP::new)
				.get();
		return maHomeP;
	};

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReaderCredentials", dataProviderClass = CsvDataProviders.class, groups = { "smoke" })
	public void checkCertificate(Method method, Map<String, String> dataList) {
		log.info("performCourse");
		SoftAssert softAssert = new SoftAssert();
		sharpId2 = dataList.get("sharpId2");
		password2 = dataList.get("password2");
		expectedMessage2 = "Eliminado";

		/* load content file */
		String pathName1 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "MACreateCourseTests" + File.separator
				+ "dataproviders" + File.separator + "MACreateCourseTests.csv";

		// read csv credentials file depends on environment
		Iterator<Map<String, String>> dataSet;
		dataSet = csvReader(pathName1);
		Map<String, String> dataMap = null;
		String courseTitle = null;
		while (dataSet.hasNext()) {
			dataMap = dataSet.next();
			if (dataMap.get("todo").equals("TRUE")) {
				if (dataMap.get("contentType").equals("curso")) {
					courseTitle = dataMap.get("title");
				}
			}
		}

		/* login */
		maHomeP = maLogin.apply(sharpId2, password2);

		softAssert.assertTrue(maHomeP.getAppLogo().isDisplayed(), "[Falla Assert - no encuentra logo");

		maCertificatesP = maHomeP.getProfileButton().click().getShowCertificatesButton().click(MACertificatesP::new).get();
		
		softAssert.assertEquals(maCertificatesP.getPageTitle().getText(), "Mis certificados");
		log.info("Nombre del certificado : " + maCertificatesP.getCertificadoName().getText());
		softAssert.assertTrue(maCertificatesP.getCertificadoName().getText().contains("Test-curso-padre" + getTodaysDate()), "wrong course name");
		
		maCertificatesP.getShowCertificate().click();
		
		softAssert.assertEquals(maCertificatesP.getCertificateText1().waitForVisibility().getText(), "Este certificado acredita que:");
		softAssert.assertEquals(maCertificatesP.getCertificateText2().waitForVisibility().getText(), "USER QA");
		softAssert.assertEquals(maCertificatesP.getCertificateText3().waitForVisibility().getText(), "ha completado con éxito el curso:");				
		
		maCertificatesP.getExitCertButton().click();
		softAssert.assertTrue(maCertificatesP.getPageTitle().isDisplayed());
		
		softAssert.assertAll();
	}
}
