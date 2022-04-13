package com.tribu.qaselenium.tests.mazaprendo;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiFunction;

import org.openqa.selenium.WebElement;
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
public class MAPerformDigitalCourseTests extends TestBase {
	
	public static String dataProviderFilePath = "src/test/resources/providerFiles/digitalLessons.csv";

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "csvReaderMethodFile", dataProviderClass = CsvDataProviders.class, groups = { "smoke",
			"deleteContent" })
	public void performCourse(Method method, ITestContext context, Map<String, String> provider) {
		// page variables
				MALandingP maLandingP;
				MAHomeP maHomeP;
				MAPerfomCourseP maPerformCourseP;

				String leccion = null;
				Boolean courseFinal = false;
				SoftAssert softAssert = new SoftAssert();
				String courseTitle = jsonFileReader(context,"apiCreateDigitalCourse","MACreateDigitalCourseTests","courseName");
				String lessonTitle = jsonFileReader(context,"apiCreateDigitalCourse","MACreateDigitalLessonTests",provider.get("order"));


		/* load content file */
		String pathName1 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "MACreateCourseTests" + File.separator
				+ "dataproviders" + File.separator + "MACreateCourseTests.csv";

		/* login */
		maLandingP = openUrl(MALandingP::new, 3000).get();
		maHomeP = maLandingP.login(readCredentials("admin"),softAssert);
		
				log.info("Leccion : " + lessonTitle);
				log.info("Leccion : " + courseTitle);
				maPerformCourseP = maHomeP.getCardList(e->e.getText().contains(courseTitle))
						.getCardButton(e->e.getText().contains("Ver Mas")).click(MAPerfomCourseP::new).get();
				maPerformCourseP.getStartCourseButton().click()
								.getModalMessage().ifFoundOrElse(maPerformCourseP::closeModal,null);

//		for (int i = 0; i < 3; i++) {
//			sleep(8000);
//			leccion = maPerformCourseP.swichToMain().getLeccionTitle().getText().substring(0, 14);
//			log.info("Leccion : " + leccion);
//
//			switch (leccion) {
//			case "Test-leccion-1":
//				log.info("Leccion 1");
//				log.info("course progress" + maPerformCourseP.getCourseProgress().getText());
//				softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().contains("0%"),
//						"it doesn't found 0%");
//				maPerformCourseP.getIFrame().waitForVisivility().swichToFrame() // get into iframe
//						.getFrame().swichToFrame() // get into sub frame
//						.getVideo().waitForVisivility(); // wait for ensure visivility of video element
//
//				// get duration and pass it as an argument to set currentTime to the final of
//				// the video
//				maPerformCourseP.getVideo().videoCurrentTime(maPerformCourseP.getVideo().videoDuration())
//				.getAceptarQuizButton().click(3000).getQuizAnswerA().click(2000).getNextQuizQuestion().click()
//				.getQuizAnswerC().click(2000).getNextQuizQuestion().click().getQuizAnswerB().click(2000)
//				.getNextQuizQuestion().click();
//				break;
//
//			case "Test-leccion-2":
//				log.info("Leccion 2");
//				log.info("course progress" + maPerformCourseP.getCourseProgress().getText());
//				softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().contains("33%"),
//						"it doesn't found 30%");
//				maPerformCourseP.getIFrame().waitForVisivility().swichToFrame().getFrame().swichToFrame().getVideo()
//						.waitForVisivility();
//				maPerformCourseP.getVideo().videoCurrentTime(maPerformCourseP.getVideo().videoDuration())
//						.getAceptarQuizButton().click(3000).getQuizAnswerB().click(2000).getNextQuizQuestion().click()
//						.getQuizAnswerC().click(2000).getNextQuizQuestion().click().getQuizAnswerB().click(2000)
//						.getNextQuizQuestion().click();
//
//				break;
//
//			case "Test-leccion-3":
//				log.info("Leccion 3");
//				log.info("course progress: " + maPerformCourseP.getCourseProgress().getText());
//				softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().contains("66%"),
//						"it doesn't found 60%");
//				maPerformCourseP.getIFrame().waitForVisivility().swichToFrame().getFrame().swichToFrame().getVideo()
//						.waitForVisivility();
//				maPerformCourseP.getVideo().videoCurrentTime(maPerformCourseP.getVideo().videoDuration())
//						.getAceptarQuizButton().click(3000).getQuizAnswerB().click(2000).getNextQuizQuestion().click()
//						.getQuizAnswerC().click(2000).getNextQuizQuestion().click().getQuizAnswerB().click(2000)
//						.getNextQuizQuestion().click();
//				break;
//			}
//		}	
//		sleep(3000);
//		log.info("course progress: " + maPerformCourseP.swichToMain().getCourseProgress().getText());
//		/*softAssert.assertTrue(maPerformCourseP.getCourseProgress().getText().contains("100%"),
//				"it doesn't found 100%");*/
//		maHomeP = maPerformCourseP.swichToMain().getNps10().click().getNpsComents()
//				.type("Comentario-Test-NPS" + getTodaysDate() + getSystemTime()).getSendQuizButton().click(MAHomeP::new).get();
//		
//		softAssert.assertTrue(maHomeP.getNumCursosText().waitForVisivility().getText().contains("Tienes 0 cursos asignados en total"));
//		
		softAssert.assertAll();
	}
}
