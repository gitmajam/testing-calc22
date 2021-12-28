package com.tribu.qaselenium.tests.mazaprendo;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MAConfigurationP;
import com.tribu.qaselenium.pages.mazaprendo.MAContentListP;
import com.tribu.qaselenium.pages.mazaprendo.MACreateContentP;
import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.pages.sso.SSOLandingP;
import com.tribu.qaselenium.pages.sso.SSOLoginP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class MACreateCourseTests extends TestBase {

	// page variables
	MAConfigurationP maConfigurationP;
	MALandingP maLandingP;
	MAHomeP maHomeP;
	MACreateContentP maCreateContentP;
	MAContentListP maContentListP;

	SSOLandingP ssoLandingP;
	SSOLoginP ssoLoginP;
	
	String cursoTitle;

	BiFunction<String, String, MAHomeP> maLogin = (s, p) -> {
		// open an url with a delay
		maLandingP = openUrl(MALandingP::new, 2000).get();
		ssoLandingP = maLandingP.getLoginButton().click(SSOLandingP::new).get();
		ssoLoginP = ssoLandingP.getSharpIdButton().click(SSOLoginP::new).get();
		maHomeP = ssoLoginP.getSharpIdField().type(s).getPasswordField().type(p).getLoginButton().click(MAHomeP::new)
				.get();
		return maHomeP;
	};

	Consumer<MAHomeP> cleanAPICache = (maHomeP) -> {
		maConfigurationP = maHomeP.getMenuConfigurationButton().click(MAConfigurationP::new).get();
		maConfigurationP.getPerformance().click().getClearCache().click();
	};

	@Test(dataProvider = "csvReaderMethodFile", dataProviderClass = CsvDataProviders.class, groups = { "smoke",
			"loadContent" })
	public void createCourse(Method method, Map<String, String> dataList) {
		log.info("createCourse");
		SoftAssert softAssert = new SoftAssert();

		// content variables
		String contentType = dataList.get("contentType");
		String title = dataList.get("title");
		String frame = dataList.get("frame");
		String description = dataList.get("description");
		String duracion = dataList.get("duracion");
		String bu = dataList.get("bu");
		String country = dataList.get("country");
		String viceprecidency = dataList.get("viceprecidency");
		String coverImage = dataList.get("coverImage");
		String cursoPadre = dataList.get("cursoPadre");
		String ordenCurso = dataList.get("ordenCurso");
		String tipoLeccion = dataList.get("tipoLeccion");
		String topic = dataList.get("topic");
		String infografia = dataList.get("infografia");
		String scorm = dataList.get("scorm");
		String altCoverText = dataList.get("altCoverText");
		String expectedMessage1 = dataList.get("expectedMessage1");

		//String cursoTitle = null;
		String leccionTitle;

		/* load content file */
		String pathName1 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "Credentials" + File.separator + "credentials.csv";

		// read csv credentials file depends on environment
		Iterator<Map<String, String>> dataSet;
		dataSet = csvReader(pathName1);
		Map<String, String> dataMap = null;
		String sharpId1 = null;
		String password1 = null;
		while (dataSet.hasNext()) {
			dataMap = dataSet.next();	
			if (dataMap.get("todo").equals("TRUE")) {
				if (dataMap.get("environment").equals(PropertiesFile.getProperties("env"))) {
					sharpId1 = dataMap.get("sharpId1");
					password1 = dataMap.get("password1");
				}
			}
		}

		/* login */
		maHomeP = maLogin.apply(sharpId1, password1);

		softAssert.assertTrue(maHomeP.getMenuContentButton().isDisplayed(),
				"[Falla Assert - no encuentra boton de contenido");

		maCreateContentP = maHomeP.getMenuContentButton().click(MACreateContentP::new).get();
		maCreateContentP.getAddContentButton().click();

		/* path for mainImage */
		String dirMainImg = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "images" + File.separator + "Test-cover-image.jpeg";

		/* path for scorm */
		String dirScorm = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "scorms" + File.separator + scorm;

		switch (contentType) {

		case "curso":
			// store curso title
			cursoTitle = title + getTodaysDate() + getSystemTime();

			maCreateContentP.getAddCursoButton().click()
					.getTitle().type(cursoTitle)
					.getFrame().swichToFrame()
					.getBody().type(frame)
					.swichToMain()
					.getCursoType().click()
					.getCursoTypeItem().click()
					.getDuracion().clear().type(duracion)
					.getTopic().type(topic)
					.getCoverImg().type(dirMainImg)
					.getPreviewCoverImage().waitForImage()
					.getAltCoverText().type(altCoverText)
					.getSaveButton().click();

			softAssert.assertTrue(maCreateContentP.getMessageCursoCreation().contains(cursoTitle),
					"doesn't contain the expected message: \"" + cursoTitle + "\"");
			break;

		default:
			break;
		}

		softAssert.assertAll();
	}

	@Test(dataProvider = "csvReaderMethodFile", dataProviderClass = CsvDataProviders.class, dependsOnMethods = {
			"createCourse" }, groups = { "smoke", "loadContent" })
	public void createLeccion(Method method, Map<String, String> dataList) {
		log.info("createLeccion");
		SoftAssert softAssert = new SoftAssert();

		// content variables
		String contentType = dataList.get("contentType");
		String title = dataList.get("title");
		String frame = dataList.get("frame");
		String description = dataList.get("description");
		String duracion = dataList.get("duracion");
		String bu = dataList.get("bu");
		String country = dataList.get("country");
		String viceprecidency = dataList.get("viceprecidency");
		String coverImage = dataList.get("coverImage");
		String cursoPadre = dataList.get("cursoPadre");
		String ordenCurso = dataList.get("ordenCurso");
		String tipoLeccion = dataList.get("tipoLeccion");
		String topic = dataList.get("topic");
		String infografia = dataList.get("infografia");
		String scorm = dataList.get("scorm");
		String altCoverText = dataList.get("altCoverText");
		String expectedMessage1 = dataList.get("expectedMessage1");

		//String cursoTitle = cursoPadre + getTodaysDate();
		String leccionTitle = null;

		/* load content file */
		String pathName1 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "Credentials" + File.separator + "credentials.csv";

		/* read csv credentials file depends on environment */
		Iterator<Map<String, String>> dataSet;
		dataSet = csvReader(pathName1);
		Map<String, String> dataMap = null;
		String sharpId1 = null;
		String password1 = null;
		while (dataSet.hasNext()) {
			dataMap = dataSet.next();	
			if (dataMap.get("todo").equals("TRUE")) {
				if (dataMap.get("environment").equals(PropertiesFile.getProperties("env"))) {
					sharpId1 = dataMap.get("sharpId1");
					password1 = dataMap.get("password1");
				}
			}
		}

		/* login */
		maHomeP = maLogin.apply(sharpId1, password1);

		softAssert.assertTrue(maHomeP.getMenuContentButton().isDisplayed(),
				"[Falla Assert - no encuentra boton de contenido");

		maCreateContentP = maHomeP.getMenuContentButton().click(MACreateContentP::new).get();
		maCreateContentP.getAddContentButton().click();

		/* path for mainImage */
		String dirMainImg = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "images" + File.separator + "Test-cover-image.jpeg";

		/* path for scorm */
		String dirScorm = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "scorms" + File.separator + scorm;

		switch (contentType) {

		case "leccion":
			// store leccion title
			leccionTitle = title + getTodaysDate() + getSystemTime();

			maCreateContentP.getAddLeccionButton().click()
					.getTitle().type(leccionTitle)
					.getFrame().waitForVisivility().swichToFrame()
					.getBody().type(frame)
					.swichToMain()
					.getCursoPadre().type(cursoTitle)
					.getOrderInsideCourse().type(ordenCurso)
					.getLeccionType().click()
					.getLeccionScormItem().click()
					.getTopic().type(topic)
					.getScorm().type(dirScorm)
					.getUploadedHref().waitForVisivility()
					.getDuracion().clear().type(duracion)
					.getSaveButton().click();

			softAssert.assertTrue(maCreateContentP.getMessageLeccionCreation().contains(leccionTitle),
					"doesn't contain the expected message: \"" + leccionTitle + "\"");
			break;

		default:
			break;
		}
		softAssert.assertAll();
	}
}
