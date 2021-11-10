package com.tribu.qaselenium.tests.apiba;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.apiba.APIConfigurationP;
import com.tribu.qaselenium.pages.apiba.APIContentListP;
import com.tribu.qaselenium.pages.apiba.APICreateContentP;
import com.tribu.qaselenium.pages.apiba.APIEditContentP;
import com.tribu.qaselenium.pages.apiba.APIHomeP;
import com.tribu.qaselenium.pages.apiba.APILandingP;
import com.tribu.qaselenium.pages.apiba.APILoginP;
import com.tribu.qaselenium.pages.beerpassion.BPHomeP;
import com.tribu.qaselenium.pages.beerpassion.BPLandingP;
import com.tribu.qaselenium.pages.sso.SSOLandingP;
import com.tribu.qaselenium.pages.sso.SSOLoginP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class APILoadContentTests extends TestBase {

	// page variables
	APIConfigurationP apiConfigurationP;
	APILandingP apiLandingP;
	APILoginP apiLoginP;
	APIHomeP apiHomeP;
	APICreateContentP apiCreateContentP;
	APIEditContentP apiEditContentP;
	APIContentListP apiContentListP;

	SSOLandingP ssoLandingP;
	SSOLoginP ssoLoginP;
	BPLandingP bpLandingP;
	BPHomeP bpHomeP;

	// assert variables
	String actualSuccessMessage;

	// content variables
	String imgName;
	String title;
	String video;
	String frame;
	String multimediaContent;
	String country;
	String miniImage;
	String mainImage;
	String brand;
	String refAtributeTitle;
	String refAtributeValue;
	String refAtributeTitleDescription;
	String refAtributeIcon;
	String refAtributeDescription;
	String socialIcon;
	String socialUrl;
	String socialUrlText;
	String column;
	String columnItem;
	String description;
	String link;
	String section;
	String hubCategoryItem;
	String highLImage;
	String articleType;
	String articleTypeItem;
	String autor;
	String wellnessPillar;
	String direccion;
	String date;
	String information;
	String textLink;
	String phone;
	String subtitle;
	String contentTitle;
	String published;
	String guardar;
	String focoName;
	String focoRelations;
	String focoRelationsItem;
	String focoRelationsWeight;
	String focoUrlAlias;
	String sharpId1;
	String password1;
	String sharpId2;
	String password2;
	String expectedMessage1;
	String expectedMessage2;
	String testDescription;
	String extLink;
	String textExtLink;
	String diversityFocus;
	String titleHLImg;
	String alterTextHLImg;

	BiFunction<String, String, APIHomeP> apiLogin = (s, p) -> {
		log.info("Login to API Beer Ambassador");
		apiLandingP = openUrl(APILandingP::new).get();
		apiLoginP = apiLandingP.getLoginButton().click(APILoginP::new).get();
		return apiLoginP.getSharpIdField().type(s)
				.getPasswordField().type(p)
				.getLoginButton().click(APIHomeP::new).get();
	};

	BiFunction<String, String, BPHomeP> bpLogin = (s, p) -> {
		bpLandingP = openUrl(BPLandingP::new).get();
		log.info("Login to Beer Passion");
		ssoLandingP = bpLandingP.getLoginButton().click(SSOLandingP::new).get();
		ssoLoginP = ssoLandingP.getSharpIdButton().click(SSOLoginP::new).get();
		return ssoLoginP.getSharpIdField().type(s)
				.getPasswordField().type(p)
				.getLoginButton().click(BPHomeP::new).get();
	};

	Consumer<APIHomeP> cleanAPICache = (apiHomeP) -> {
		log.info("Cleaning API cache");
		apiConfigurationP = apiHomeP.getConfigurationButton().click(APIConfigurationP::new).get();
		apiConfigurationP.getPerformance().click()
		.getClearCache().click();
	};

	@Test(dataProvider = "csvReaderMapList", dataProviderClass = CsvDataProviders.class, groups = { "smoke",
			"loadContent" })
	public void loadContent(Method method, List<Map<String, String>> dataList) {
		log.info("loadMethod");
		SoftAssert softAssert = new SoftAssert();

		String lastSharpId1 = "";
		String lastPassword1 = "";
		String infographicTitle = null;

		for (Map<String, String> testData : dataList) {

			// content variables
			title = testData.get("title");
			video = testData.get("addVideo");
			frame = testData.get("frame");
			multimediaContent = testData.get("multimediaContent");
			country = testData.get("country");
			miniImage = testData.get("miniImage");
			mainImage = testData.get("mainImage");
			brand = testData.get("brand");
			refAtributeTitle = testData.get("refAtributeTitle");
			refAtributeValue = testData.get("refAtributeValue");
			refAtributeTitleDescription = testData.get("refAtributeTitleDescription");
			refAtributeIcon = testData.get("refAtributeIcon");
			refAtributeDescription = testData.get("refAtributeDescription");
			socialIcon = testData.get("socialIcon");
			socialUrl = testData.get("socialUrl");
			socialUrlText = testData.get("socialUrlText");
			column = testData.get("column");
			columnItem = testData.get("columnItem");
			link = testData.get("link");
			section = testData.get("section");
			hubCategoryItem = testData.get("hubCategoryItem");
			highLImage = testData.get("highLImage");
			articleType = testData.get("articleType");
			articleTypeItem = testData.get("articleTypeItem");
			autor = testData.get("autor");
			wellnessPillar = testData.get("wellnessPillar");
			direccion = testData.get("direccion");
			date = testData.get("date");
			information = testData.get("information");
			textLink = testData.get("textLink");
			phone = testData.get("phone");
			subtitle = testData.get("subtitle");
			contentTitle = testData.get("contentTitle");
			published = testData.get("published");
			guardar = testData.get("guardar");
			focoName = testData.get("focoName");
			focoRelations = testData.get("focoRelations");
			focoRelationsItem = testData.get("focoRelationsItem");
			focoRelationsWeight = testData.get("focoRelationsWeight");
			focoUrlAlias = testData.get("focoUrlAlias");
			sharpId1 = testData.get("sharpId1");
			password1 = testData.get("password1");
			expectedMessage1 = testData.get("expectedMessage1");
			expectedMessage2 = testData.get("expectedMessage2");
			testDescription = testData.get("testDescription");
			extLink = testData.get("extLink");
			textExtLink = testData.get("textExtLink");
			diversityFocus = testData.get("diversityFocus");
			titleHLImg = testData.get("titleHLImg");
			alterTextHLImg = testData.get("alterTextHLImg");

			/* path for mainImage */
			String dirMainImg = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "images" + File.separator
					+ method.getDeclaringClass().getSimpleName() + File.separator + mainImage;

			/* path for highLightImg */
			String dirHLImg = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "images" + File.separator
					+ method.getDeclaringClass().getSimpleName() + File.separator + highLImage;

			if (!sharpId1.equals(lastSharpId1) || !password1.equals(lastPassword1)) {

				/* login */
				apiHomeP = apiLogin.apply(sharpId1, password1);
				lastSharpId1 = sharpId1;
				lastPassword1 = password1;
				// cleanAPICache.accept(apiHomeP);
				softAssert.assertTrue(apiHomeP.getMenuContentButton().isDisplayed(),
						"[Falla Assert - no encuentra boton de contenido");
			}

			log.info("Creating content = * " + testData.get("contentType") + " *");

			apiCreateContentP = apiHomeP.getMenuContentButton().hoverElement().getAddContentButton()
					.click(APICreateContentP::new).get();

			switch (testData.get("contentType")) {

			case "banner":
				apiCreateContentP.getAddBannerButton().click()
								.getTitle().type(title + getTodaysDate() + getSystemTime())
								.getFrame().swichToFrame()
								.getBody().type(frame)
								.swichToMain()
								.getMainImage().type(dirMainImg)
								.getPreviewMainImage().waitForImage()
								.getLink().type(link)
								.getSection().type(section)
								.getCountry().clear()
								.getCountry().type(country)
								.getSaveButton().click();

				softAssert.assertTrue(apiCreateContentP.getMessageCreation().contains(expectedMessage1),
						"doesn't contain the expected message: \"" + expectedMessage1 + "\"");

				break;

			case "bienestarEventos":

				apiCreateContentP.getAddWellnessEventButton().click().getTitle()
								.type(title + getTodaysDate() + getSystemTime())
								.getFrame().swichToFrame()
								.getBody().type(frame)
								.swichToMain()
								.getHighLImage().type(dirHLImg)
								.getPreviewHighLImage().waitForImage()
								.getWellnessPillar().type(wellnessPillar)
								.getMainImage().type(dirMainImg)
								.getPreviewMainImage().waitForImage()
								.getInformation().type(information)
								.getAutor().type(autor)
								.getDireccion().type(direccion)
								.getDate().type(date)
								.getPhone().type(phone)
								.getCountry().type(country)
								.getExtLink().type(extLink)
								.getTextExtLink().type(textExtLink)
								.getSaveButton().click();

				softAssert.assertTrue(apiCreateContentP.getMessageCreation().contains(expectedMessage1),
						"doesn't contain the expected message: \"" + expectedMessage1 + "\"");

				break;

			case "bienestarPilares":

				apiCreateContentP.getAddWellnessPillarButton().click()
								.getTitle().type(title + getTodaysDate() + getSystemTime()).getHighLImage().type(dirMainImg)
								.getPreviewHighLImage().waitForImage()
								.getContentTitle().type(contentTitle)
								.getSubtitle().type(subtitle)
								.getMainImage().type(dirMainImg)
								.getPreviewMainImage().waitForImage()
								.getFrame()
								.swichToFrame()
								.getBody().type(frame)
								.swichToMain()
								.getMultimediaContent().type(infographicTitle)
								.getCountry().type(country)
								.getLink().type(link)
								.getTextLink()
								.type(textLink)
								.getSaveButton().click();

				softAssert.assertTrue(apiCreateContentP.getMessageCreation().contains(expectedMessage1),
						"doesn't contain the expected message: \"" + expectedMessage1 + "\"");

				break;
			case "bienestarProgramas":
				apiCreateContentP.getAddWellnessProgramsButton().click()
								.getTitle().type(title + getTodaysDate() + getSystemTime())
								.getFrame().swichToFrame()
								.getBody().type(frame)
								.swichToMain()
								.getHighLImage().type(dirMainImg)
								.getPreviewHighLImage().waitForImage()
								.getWellnessPillar().type(wellnessPillar)
								.getMainImage().type(dirMainImg)
								.getPreviewMainImage().waitForImage()
								.getInformation().type(information)
								.getAutor().type(autor).getDireccion().type(direccion)
								.getDate().type(date)
								.getPhone().type(phone).getLink().type(extLink)
								.getMultimediaContent().type(infographicTitle)
								.getCountry().type(country)
								.getExtLink().type(extLink)
								.getTextExtLink().type(textExtLink)
								.getSaveButton().click();

				softAssert.assertTrue(apiCreateContentP.getMessageCreation().contains(expectedMessage1),
						"doesn't contain the expected message: \"" + expectedMessage1 + "\"");

				break;
			case "diversidadArticulos":
				apiCreateContentP.getAddDiversityArticleButton().click()
								.getTitle().type(title + getTodaysDate() + getSystemTime()).getArticleType().click()
								.getArticleTypeItem().click()
								.getDiversityFocus().type(diversityFocus)
								.getHighLImage().type(dirHLImg)
								.getPreviewHighLImage().waitForImage()
								.getMainImage().type(dirMainImg)
								.getPreviewMainImage().waitForImage()
								.getFrame().swichToFrame()
								.getBody().type(frame)
								.swichToMain()
								.getMultimediaContent().type(infographicTitle)
								.getCountry().type(country)
								.getSaveButton().click();

				softAssert.assertTrue(apiCreateContentP.getMessageCreation().contains(expectedMessage1),
						"doesn't contain the expected message: \"" + expectedMessage1 + "\"");

				break;
			case "hubAplicaciones":
				apiCreateContentP.getAddHubAppButton().click()
								.getTitle().type(title + getTodaysDate() + getSystemTime())
								.getHighLImage().type(dirHLImg)
								.getPreviewHighLImage().waitForImage()
								.getAlterTextHLImg().type(alterTextHLImg)
								.getTitleHLImg().type(titleHLImg)
								.getLink().type(extLink)
								.getCountry().type(country)
								.getHubCategoryItem().click()
								.getSaveButton().click();

				softAssert.assertTrue(apiCreateContentP.getMessageCreation().contains(expectedMessage1),
						"doesn't contain the expected message: \"" + expectedMessage1 + "\"");

				break;
			case "infografia":
				infographicTitle = title + getTodaysDate() + getSystemTime();
				apiCreateContentP.getAddInfograPhicButton().click()
								.getTitle().type(infographicTitle)
								.getMainImage().type(dirMainImg)
								.getPreviewMainImage().waitForImage()
								.getCountry().type(country)
								.getSaveButton().click();

				softAssert.assertTrue(apiCreateContentP.getMessageCreation().contains(expectedMessage1),
						"doesn't contain the expected message: \"" + expectedMessage1 + "\"");

				break;
			case "listasEnlaces":
				apiCreateContentP.getAddLinkListButton().click()
								.getTitle().type(title + getTodaysDate() + getSystemTime())
								.getFrame().swichToFrame()
								.getBody().type(frame)
								.swichToMain()
								.getMainImage().type(dirMainImg)
								.getPreviewMainImage().waitForImage()
								.getLink().type(extLink)
								.getSection().type(section)
								.getColumn().click()
								.getColumnItem().click()
								.getCountry().type(country)
								.getSaveButton().click();

				break;
			case "referenciasMarca":

				break;
			case "video":

				break;
			case "diversidadFoco":

				break;
			default:
				log.info("new content type = " + testData.get("contentType"));
				break;
			}
		}
		softAssert.assertAll();
	}

}
