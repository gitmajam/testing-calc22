package com.tribu.qaselenium.tests.mazaprendo;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.BiFunction;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MAContentListP;
import com.tribu.qaselenium.pages.mazaprendo.MAPerfomCourseP;
import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
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
		log.info("deleteMethod");
		SoftAssert softAssert = new SoftAssert();
		sharpId2 = dataList.get("sharpId2");
		password2 = dataList.get("password2");
		expectedMessage2 = "Eliminado";
		String leccion = null;
		Boolean courseFinal = false;

		/* login */
		maHomeP = maLogin.apply(sharpId2, password2);

		softAssert.assertTrue(maHomeP.getAppLogo().isDisplayed(), "[Falla Assert - no encuentra logo");

		maPerformCourseP = maHomeP.getXpathPart1(getTodaysDate()).click(MAPerfomCourseP::new).get();
		maPerformCourseP.getStartCourseButton().click();

		



		for (int i = 0; i < 3; i++) {
			maPerformCourseP.swichToMain().swichToActiveElement().getContinuarPopupButton().click(5000);
			leccion = maPerformCourseP.getLeccionTitle().waitForVisivility().getText().substring(0, 14);
			log.info("Leccion : " + leccion);

			switch (leccion) {
			case "Test-leccion-1":
				log.info("Leccion 1");
				softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().equals("0%"), "it doesn't found 0%");
				maPerformCourseP.getIFrame().swichToFrame() // get into iframe
				.getFrame().swichToFrame() // get into sub frame
				.getVideo().waitForVisivility(); // wait for ensure visivility of video element
				// get duration and pass it as an argument to set currentTime to the final of
				// the video
				maPerformCourseP.getVideo().videoCurrentTime(maPerformCourseP.getVideo().videoDuration())
						.getAceptarQuizButton().click(2000).getQuizAnswerA().click(2000).getNextQuizQuestion().click()
						.getQuizAnswerC().click(2000).getNextQuizQuestion().click().getQuizAnswerB().click(2000)
						.getNextQuizQuestion().click();

				break;

			case "Test-leccion-2":
				log.info("Leccion 2");
				softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().equals("30%"), "it doesn't found 30%");
				maPerformCourseP.getIFrame().swichToFrame() 
				.getFrame().swichToFrame() 
				.getVideo().waitForVisivility();
				maPerformCourseP.getVideo().videoCurrentTime(maPerformCourseP.getVideo().videoDuration())
						.getAceptarQuizButton().click(2000).getQuizAnswerB().click(2000).getNextQuizQuestion().click()
						.getQuizAnswerC().click(2000).getNextQuizQuestion().click().getQuizAnswerB().click(2000)
						.getNextQuizQuestion().click();

				break;

			case "Test-leccion-3":
				log.info("Leccion 3");
				softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().equals("60%"), "it doesn't found 60%");
				maPerformCourseP.getIFrame().swichToFrame()
				.getFrame().swichToFrame()
				.getVideo().waitForVisivility();
				maPerformCourseP.getVideo().videoCurrentTime(maPerformCourseP.getVideo().videoDuration())
						.getAceptarQuizButton().click(2000).getQuizAnswerB().click(2000).getNextQuizQuestion().click()
						.getQuizAnswerC().click(2000).getNextQuizQuestion().click().getQuizAnswerB().click(2000)
						.getNextQuizQuestion().click();

				break;
			}
		}
		maPerformCourseP.swichToMain().getNps10().click().getNpsComents()
				.type("Comentario-Test-NPS" + getTodaysDate() + getSystemTime())
				.getSendQuizButton().click();

		softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().equals("100%"), "it doesn't found 100%");

		softAssert.assertAll();
	}
}
