package com.tribu.qaselenium.tests.mazaprendo;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiFunction;

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
public class MAPerformF2FCourseTests extends TestBase {
	
	public static String dataProviderFilePath = "src/test/resources/providerFiles/faceToFaceLessons.csv";

	@Test(dataProvider = "csvReaderMethodFile", dataProviderClass = CsvDataProviders.class, groups = { "smoke",
			"deleteContent" })
	public void performF2FCourseTests(Method method, ITestContext context, Map<String, String> provider) {
		log.info("performCourse");
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MAPerfomCourseP maPerformCourseP;

		String leccion = null;
		Boolean courseFinal = false;
		SoftAssert softAssert = new SoftAssert();
		String courseTitle = jsonFileReader(context,"apiCreateF2FCourse","MACreateF2FCourseTests","courseName");
		String lessonTitle = jsonFileReader(context,"apiCreateF2FCourse","MACreateF2FLessonTests",provider.get("order"));

		// read csv credentials file depends on environment
		Map<String, String> credentialMap = readCredentials();

		/* login */
		maLandingP = openUrl(MALandingP::new, 3000).get();
		maHomeP = maLandingP.login(credentialMap.get("sharpId2"), credentialMap.get("password2"));

		softAssert.assertTrue(maHomeP.getAppLogo().isDisplayed(),
				"Falla Assert login - no encuentra boton de contenido");
		log.info("Leccion : " + lessonTitle);
		log.info("Leccion : " + courseTitle);
		maPerformCourseP = maHomeP.getXpathPart1(courseTitle).click(MAPerfomCourseP::new).get();
		maPerformCourseP.getModalMessage().existElement(maPerformCourseP::closeModal);
	

//		sleep(8000);
//		leccion = maPerformCourseP.swichToMain().getLeccionTitle().getText().substring(0, 14);
//		log.info("Leccion : " + leccion);
//
//		log.info("course progress" + maPerformCourseP.getCourseProgress().getText());
//		softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().contains("0%"), "it doesn't found 0%");
//		maPerformCourseP.getIFrame().waitForVisivility().swichToFrame() // get into iframe
//				.getFrame().swichToFrame() // get into sub frame
//				.getVideo().waitForVisivility(); // wait for ensure visivility of video element
//
//		// get duration and pass it as an argument to set currentTime to the final of
//		// the video
//		maPerformCourseP.getVideo().videoCurrentTime(maPerformCourseP.getVideo().videoDuration()).getAceptarQuizButton()
//				.click(3000).getQuizAnswerA().click(2000).getNextQuizQuestion().click().getQuizAnswerC().click(2000)
//				.getNextQuizQuestion().click().getQuizAnswerB().click(2000).getNextQuizQuestion().click();
//
//		sleep(3000);
//		log.info("course progress: " + maPerformCourseP.swichToMain().getCourseProgress().getText());
//		/*
//		 * softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().contains
//		 * ("100%"), "it doesn't found 100%");
//		 */
//		maHomeP = maPerformCourseP.swichToMain().getNps10().click().getNpsComents()
//				.type("Comentario-Test-NPS" + getTodaysDate() + getSystemTime()).getSendQuizButton().click(MAHomeP::new)
//				.get();
//
//		softAssert.assertTrue(maHomeP.getNumCursosText().waitForVisivility().getText()
//				.contains("Tienes 0 cursos asignados en total"));

		softAssert.assertAll();
	}
}
