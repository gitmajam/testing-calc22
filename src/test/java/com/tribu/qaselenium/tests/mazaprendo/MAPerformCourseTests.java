package com.tribu.qaselenium.tests.mazaprendo;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiFunction;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.pages.mazaprendo.MAPerfomCourseP;
import com.tribu.qaselenium.pages.sso.SSOLandingP;
import com.tribu.qaselenium.pages.sso.SSOLoginP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class MAPerformCourseTests extends TestBase {

	// page variables
	MALandingP maLandingP;
	MAHomeP maHomeP;
	MAPerfomCourseP maPerformCourseP;

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
		ssoLoginP = ssoLandingP.getSharpIdButton().click(SSOLoginP::new).get();
		maHomeP = ssoLoginP.getSharpIdField().type(s).getPasswordField().type(p).getLoginButton().click(MAHomeP::new)
				.get();
		return maHomeP;
	};

	@Test(dataProvider = "csvReaderCredentials", dataProviderClass = CsvDataProviders.class, groups = { "smoke",
			"deleteContent" })
	public void performCourse(Method method, Map<String, String> dataList) {
		log.info("performCourse");
		SoftAssert softAssert = new SoftAssert();
		sharpId2 = dataList.get("sharpId2");
		password2 = dataList.get("password2");
		expectedMessage2 = "Eliminado";
		String leccion = null;
		Boolean courseFinal = false;

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

		maPerformCourseP = maHomeP.getXpathPart1(courseTitle + getTodaysDate()).click(MAPerfomCourseP::new).get();
		maPerformCourseP.getStartCourseButton().click();

		for (int i = 0; i < 3; i++) {
			sleep(8000);
			leccion = maPerformCourseP.swichToMain().getLeccionTitle().getText().substring(0, 14);
			log.info("Leccion : " + leccion);

			switch (leccion) {
			case "Test-leccion-1":
				log.info("Leccion 1");
				log.info("course progress" + maPerformCourseP.getCourseProgress().getText());
				softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().contains("0%"),
						"it doesn't found 0%");
				maPerformCourseP.getIFrame().waitForVisivility().swichToFrame() // get into iframe
						.getFrame().swichToFrame() // get into sub frame
						.getVideo().waitForVisivility(); // wait for ensure visivility of video element

				// get duration and pass it as an argument to set currentTime to the final of
				// the video
				maPerformCourseP.getVideo().videoCurrentTime(maPerformCourseP.getVideo().videoDuration())
						.getAceptarQuizButton().click(3000).getQuizAnswerA().click(2000).getNextQuizQuestion().click()
						.getQuizAnswerC().click(2000).getNextQuizQuestion().click().getQuizAnswerB().click(2000)
						.getNextQuizQuestion().click();

				break;

			case "Test-leccion-2":
				log.info("Leccion 2");
				log.info("course progress" + maPerformCourseP.getCourseProgress().getText());
				softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().contains("33%"),
						"it doesn't found 30%");
				maPerformCourseP.getIFrame().waitForVisivility().swichToFrame().getFrame().swichToFrame().getVideo()
						.waitForVisivility();
				maPerformCourseP.getVideo().videoCurrentTime(maPerformCourseP.getVideo().videoDuration())
						.getAceptarQuizButton().click(3000).getQuizAnswerB().click(2000).getNextQuizQuestion().click()
						.getQuizAnswerC().click(2000).getNextQuizQuestion().click().getQuizAnswerB().click(2000)
						.getNextQuizQuestion().click();

				break;

			case "Test-leccion-3":
				log.info("Leccion 3");
				log.info("course progress: " + maPerformCourseP.getCourseProgress().getText());
				softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().contains("66%"),
						"it doesn't found 60%");
				maPerformCourseP.getIFrame().waitForVisivility().swichToFrame().getFrame().swichToFrame().getVideo()
						.waitForVisivility();
				maPerformCourseP.getVideo().videoCurrentTime(maPerformCourseP.getVideo().videoDuration())
						.getAceptarQuizButton().click(3000).getQuizAnswerB().click(2000).getNextQuizQuestion().click()
						.getQuizAnswerC().click(2000).getNextQuizQuestion().click().getQuizAnswerB().click(2000)
						.getNextQuizQuestion().click();

				break;
			}
		}
		sleep(3000);
		softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().contains("100%"),
				"it doesn't found 100%");
		maPerformCourseP.swichToMain().getNps10().click().getNpsComents()
				.type("Comentario-Test-NPS" + getTodaysDate() + getSystemTime()).getSendQuizButton().click();

		softAssert.assertAll();
	}
}
