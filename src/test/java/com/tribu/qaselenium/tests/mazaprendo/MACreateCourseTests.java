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

	BiFunction<String, String, MAHomeP> maLogin = (s, p) -> {
		//open an url with a delay
		maLandingP = openUrl(MALandingP::new, 2000).get();
		ssoLandingP = maLandingP.getLoginButton().click(SSOLandingP::new).get();
		ssoLoginP = ssoLandingP.getSharpIdButton().click(SSOLoginP::new).get();
		maHomeP = ssoLoginP.getSharpIdField().type(s)
				.getPasswordField().type(p)
				.getLoginButton().click(MAHomeP::new).get();
		return maHomeP;
	};

	Consumer<MAHomeP> cleanAPICache = (maHomeP) -> {
		log.info("Cleaning API cache");
		maConfigurationP = maHomeP.getMenuConfigurationButton().click(MAConfigurationP::new).get();
		maConfigurationP.getPerformance().click().getClearCache().click();
	};

	@Test(dataProvider = "csvReaderCredentials", dataProviderClass = CsvDataProviders.class, groups = { "smoke",
			"loadContent" })
	public void createCourse(Method method, Map<String, String> dataList) {
		log.info("loadMethod");
		SoftAssert softAssert = new SoftAssert();
		String sharpId1 = dataList.get("sharpId1");
		String password1 = dataList.get("password1");
		String cursoTitle = null;
		
		// list for store multiple content type leccion
		List<String> leccionList = new ArrayList<String>();
		Iterator<String> leccionListIterator = null;
		String leccionTitle;

		/* load content file */
		String pathName1 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "MACreateCourseTests" + File.separator
				+ "dataproviders" + File.separator + "loadContent.csv";
		
		/* login */
		maHomeP = maLogin.apply(sharpId1, password1);
		// cleanAPICache.accept(maHomeP);

		softAssert.assertTrue(maHomeP.getMenuContentButton().isDisplayed(),
				"[Falla Assert - no encuentra boton de contenido");

		//read csv data file
		Iterator<Map<String, String>> dataSet;
		dataSet = csvReader(pathName1);
		
		while (dataSet.hasNext()) {

			Map<String, String> dataMap = dataSet.next();

			// content variables
			String contentType = dataMap.get("contentType");
			String title = dataMap.get("title");
			String frame = dataMap.get("frame");
			String description = dataMap.get("description");
			String duracion = dataMap.get("duracion");
			String bu = dataMap.get("bu");
			String country = dataMap.get("country");
			String viceprecidency = dataMap.get("viceprecidency");
			String coverImage = dataMap.get("coverImage");
			String cursoPadre = dataMap.get("cursoPadre");
			String ordenCurso = dataMap.get("ordenCurso");
			String tipoLeccion = dataMap.get("tipoLeccion");
			String topic = dataMap.get("topic");
			String infografia = dataMap.get("infografia");
			String scorm = dataMap.get("scorm");
			String altCoverText = dataMap.get("altCoverText");
			String expectedMessage1  = dataMap.get("expectedMessage1");

			maCreateContentP = maHomeP.getMenuContentButton().click(MACreateContentP::new).get();
			maCreateContentP.getAddContentButton().click();

							
			/* path for mainImage */
			String dirMainImg = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "images" + File.separator + "Test-cover-image.jpeg";
			
			/* path for scorm */
			String dirScorm = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "scorms" + File.separator + scorm;

			switch (dataMap.get("contentType")) {
			
			case "curso":
				//store curso title
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

			case "leccion":
				//store leccion title
				leccionTitle = title + getTodaysDate() + getSystemTime();
				leccionList.add(leccionTitle);

				maCreateContentP.getAddLeccionButton().click()
								.getTitle().type(leccionTitle)
								.getFrame().swichToFrame()
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
	
			}
		}
		softAssert.assertAll();
	}
}
