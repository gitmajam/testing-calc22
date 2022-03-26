package com.tribu.qaselenium.tests.mazaprendo;

import java.lang.reflect.Method;
import java.util.Map;

import org.junit.runners.Parameterized.Parameters;
import org.testng.ITestContext;
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
public class MALessonAttemptTests extends TestBase {
	
	public static String dataProviderFilePath = "src/test/resources/providerFiles/digitalLessons.csv";

	@Test(dataProvider = "csvReaderMethodFile", dataProviderClass = CsvDataProviders.class, groups = { "smoke",
			"deleteContent" })
	public void lessonAtempts(Method method, ITestContext context, Map<String, String> provider) {
		log.info("performCourse");
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MAPerfomCourseP maPerformCourseP;

		String leccion = null;
		Boolean courseFinal = false;
		SoftAssert softAssert = new SoftAssert();
		String courseTitle = jsonFileReader(context,"apiCreateDigitalCourse","MACreateDigitalCourseTests","digital");
		String lessonTitle = jsonFileReader(context,"apiCreateDigitalCourse","MACreateDigitalLessonTests",provider.get("order"));
		int lessonAttempts = Integer.parseInt(provider.get("attempts"));

		// read csv credentials file depends on environment
		Map<String, String> credentialMap = readCredentials();

		/* login */
		maLandingP = openUrl(MALandingP::new, 2000).get();
		maHomeP = maLandingP.login(credentialMap.get("sharpId2"), credentialMap.get("password2"));

		softAssert.assertTrue(maHomeP.getAppLogo().isDisplayed(),
				"Falla Assert login - no encuentra boton de contenido");
		log.info("Leccion : " + lessonTitle);
		maPerformCourseP = maHomeP.getXpathPart1(courseTitle).click(MAPerfomCourseP::new).get();
		maPerformCourseP.getStartCourseButton().click()
						.getModalMessage().existElement(maPerformCourseP::closeModal)
						.getLessonsButton().click()
						.getLessonsList().click(lessonTitle);	
//	
//		
//		 //get the name of current running lesson
//		sleep(8000);
//		leccion = maPerformCourseP.getLeccionTitle().getText().substring(0, 38);
//		log.info("Leccion : " + leccion);
//		softAssert.assertEquals(leccion, lessonTitle);
//		
//		// try lessons attempts
//		for (int lessonAttempt = 0; lessonAttempt < 1; lessonAttempt++) {
//			log.info("course progress : " + maPerformCourseP.getCourseProgress().getText());
//			log.info("lesson attempt : " + lessonAttempt);
//			softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().contains("0%"), "it doesn't found 0%");
//			// get into iframe
//			maPerformCourseP.getIFrame().waitForVisivility().swichToFrame()
//							// get into sub frame
//							.getFrame().swichToFrame().getVideo().waitForVisivility();
//
//			// get duration and pass it as an argument to set currentTime to the final of the video
//			maPerformCourseP.getVideo().videoCurrentTime(maPerformCourseP.getVideo().videoDuration());
//
//			// try scorm attempts
//			for (int scormAttempt = 0; scormAttempt < 3; scormAttempt++) {
//				log.info("scorm attempt : " + scormAttempt);
//				maPerformCourseP.getAceptarQuizButton().click(3000)
//							.getQuizAnswerA().click(2000)
//							.getNextQuizQuestion().click()
//							.getQuizAnswerA().click(2000)
//							.getNextQuizQuestion().click()
//							.getQuizAnswerA().click(2000)
//							.getNextQuizQuestion().click()
//							.getTestButton().click();
//			}
//		}
		softAssert.assertAll();
	}
}