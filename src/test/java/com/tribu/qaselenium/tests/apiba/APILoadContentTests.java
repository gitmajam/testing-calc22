package com.tribu.qaselenium.tests.apiba;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
	String ficha1;
	String ficha2;
	String ficha3;
	String banner1;
	String banner2;
	String banner3;
	String tarjeta1;
	String tarjeta2;

	BiFunction<String, String, APIHomeP> apiLogin = (s, p) -> {
		log.info("Login to API Beer Ambassador");
		apiLandingP = openUrl(APILandingP::new).get();
		apiLoginP = apiLandingP.getLoginButton().click(APILoginP::new).get();
		return apiLoginP.getSharpIdField().type(s).getPasswordField().type(p).getLoginButton().click(APIHomeP::new)
				.get();
	};

	BiFunction<String, String, BPHomeP> bpLogin = (s, p) -> {
		bpLandingP = openUrl(BPLandingP::new).get();
		log.info("Login to Beer Passion");
		ssoLandingP = bpLandingP.getLoginButton().click(SSOLandingP::new).get();
		ssoLoginP = ssoLandingP.getSharpIdButton().click(SSOLoginP::new).get();
		return ssoLoginP.getSharpIdField().type(s).getPasswordField().type(p).getLoginButton().click(BPHomeP::new)
				.get();
	};

	Consumer<APIHomeP> cleanAPICache = (apiHomeP) -> {
		log.info("Cleaning API cache");
		apiConfigurationP = apiHomeP.getConfigurationButton().click(APIConfigurationP::new).get();
		apiConfigurationP.getPerformance().click().getClearCache().click();
	};

	@Test(dataProvider = "csvReaderCredentials", dataProviderClass = CsvDataProviders.class, groups = { "smoke",
			"loadContent" })
	public void loadContent(Method method, Map<String, String> dataList) {
		log.info("loadMethod");
		SoftAssert softAssert = new SoftAssert();
		sharpId1 = dataList.get("sharpId1");
		password1 = dataList.get("password1");
		String infographicTitle = null;
		
		// list for store multiple content type ficha
		List<String> fichaList = new ArrayList<String>();
		Iterator<String> fichaListIterator = null;
		String fichaTitle;

		// list for store multiple content type banner
		List<String> bannerList = new ArrayList<String>();
		Iterator<String> bannerListIterator = null;
		String bannerTitle;

		// list for store multiple content type tarjeta
		List<String> tarjetaList = new ArrayList<String>();
		Iterator<String> tarjetaListIterator = null;
		String tarjetaTitle;

		/* load content file */
		String pathName1 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "APILoadContentTests" + File.separator
				+ "dataproviders" + File.separator + "loadContent.csv";

		/* login */
		apiHomeP = apiLogin.apply(sharpId1, password1);
		// cleanAPICache.accept(apiHomeP);

		softAssert.assertTrue(apiHomeP.getMenuContentButton().isDisplayed(),
				"[Falla Assert - no encuentra boton de contenido");

		//read csv data file
		Iterator<Map<String, String>> dataSet;
		dataSet = csvReader(pathName1);
		
		while (dataSet.hasNext()) {

			Map<String, String> dataMap = dataSet.next();

			// content variables
			title = dataMap.get("title");
			video = dataMap.get("addVideo");
			frame = dataMap.get("frame");
			multimediaContent = dataMap.get("multimediaContent");
			country = dataMap.get("country");
			miniImage = dataMap.get("miniImage");
			mainImage = dataMap.get("mainImage");
			brand = dataMap.get("brand");
			refAtributeTitle = dataMap.get("refAtributeTitle");
			refAtributeValue = dataMap.get("refAtributeValue");
			refAtributeTitleDescription = dataMap.get("refAtributeTitleDescription");
			refAtributeIcon = dataMap.get("refAtributeIcon");
			refAtributeDescription = dataMap.get("refAtributeDescription");
			socialIcon = dataMap.get("socialIcon");
			socialUrl = dataMap.get("socialUrl");
			socialUrlText = dataMap.get("socialUrlText");
			column = dataMap.get("column");
			columnItem = dataMap.get("columnItem");
			link = dataMap.get("link");
			section = dataMap.get("section");
			hubCategoryItem = dataMap.get("hubCategoryItem");
			highLImage = dataMap.get("highLImage");
			articleType = dataMap.get("articleType");
			articleTypeItem = dataMap.get("articleTypeItem");
			autor = dataMap.get("autor");
			wellnessPillar = dataMap.get("wellnessPillar");
			direccion = dataMap.get("direccion");
			date = dataMap.get("date");
			information = dataMap.get("information");
			textLink = dataMap.get("textLink");
			phone = dataMap.get("phone");
			subtitle = dataMap.get("subtitle");
			contentTitle = dataMap.get("contentTitle");
			published = dataMap.get("published");
			guardar = dataMap.get("guardar");
			focoName = dataMap.get("focoName");
			focoRelations = dataMap.get("focoRelations");
			focoRelationsItem = dataMap.get("focoRelationsItem");
			focoRelationsWeight = dataMap.get("focoRelationsWeight");
			focoUrlAlias = dataMap.get("focoUrlAlias");
			expectedMessage1 = dataMap.get("expectedMessage1");
			expectedMessage2 = dataMap.get("expectedMessage2");
			testDescription = dataMap.get("testDescription");
			extLink = dataMap.get("extLink");
			textExtLink = dataMap.get("textExtLink");
			diversityFocus = dataMap.get("diversityFocus");
			titleHLImg = dataMap.get("titleHLImg");
			alterTextHLImg = dataMap.get("alterTextHLImg");
			ficha1 = dataMap.get("ficha1");
			ficha2 = dataMap.get("ficha2");
			ficha3 = dataMap.get("ficha3");
			banner1 = dataMap.get("banner1");
			banner2 = dataMap.get("banner2");
			banner3 = dataMap.get("banner3");
			tarjeta1 = dataMap.get("tarjeta1");
			tarjeta2 = dataMap.get("tarjeta2");

			log.info("Creating content = * " + dataMap.get("contentType") + " *");

			apiCreateContentP = apiHomeP.getMenuContentButton().hoverElement().getAddContentButton()
					.click(APICreateContentP::new).get();
			
			/* path for mainImage */
			String dirMainImg = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "images" + File.separator
					+ method.getDeclaringClass().getSimpleName() + File.separator + mainImage;
			
			/* path for miniImage */
			String dirMiniImg = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "images" + File.separator
					+ method.getDeclaringClass().getSimpleName() + File.separator + miniImage;

			/* path for highLightImg */
			String dirHLImg = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "images" + File.separator
					+ method.getDeclaringClass().getSimpleName() + File.separator + highLImage;

			switch (dataMap.get("contentType")) {

			case "banner":
				//store multiple content type banner in a list
				bannerTitle = title + getTodaysDate() + getSystemTime();
				bannerList.add(bannerTitle);

				apiCreateContentP.getAddBannerButton().click()
								.getTitle().type(bannerTitle)
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

				apiCreateContentP.getAddWellnessEventButton().click()
								.getTitle().type(title + getTodaysDate() + getSystemTime())
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
				
			case "ficha":
				//store multiple content type ficha in a list
				fichaTitle = title + getTodaysDate() + getSystemTime();
				fichaList.add(fichaTitle);

				apiCreateContentP.getAddFichaButton().click()
								.getTitle().type(fichaTitle)
								.getFrame().swichToFrame()
								.getBody().type(frame)
								.swichToMain()
								.getMiniImage().type(dirMiniImg)
								.getPreviewMiniLImage().waitForImage()
								.getMultimediaContent().type(infographicTitle)
								.getCountry().type(country)
								.getSaveButton().click();
				
				softAssert.assertTrue(apiCreateContentP.getMessageCreation().contains(expectedMessage1),
						"doesn't contain the expected message: \"" + expectedMessage1 + "\"");	
				break;

			case "tarjeta":
				//store multiple content type tarjeta in a list
				tarjetaTitle = title + getTodaysDate() + getSystemTime();
				tarjetaList.add(tarjetaTitle);

				fichaListIterator = fichaList.iterator();
				bannerListIterator =  bannerList.iterator();
				
				apiCreateContentP.getAddTarjetaButton().click()
								.getTitle().type(tarjetaTitle)
								.getHighLImage().type(dirHLImg)
								.getPreviewHighLImage().waitForImage()
								.getCountry().type(country)
								.getFicha1Tarjeta().type(fichaListIterator.next())
								.getAddFichaToTarjetaButton().click()
								.getFicha2Tarjeta().type(fichaListIterator.next())
								.getAddFichaToTarjetaButton().click()
								.getFicha3Tarjeta().type(fichaListIterator.next())
								.getBanner1Tarjeta().type(bannerListIterator.next())
								.getAddBannerToTarjetaButton().click()
								.getBanner2Tarjeta().type(bannerListIterator.next())
								.getAddBannerToTarjetaButton().click()
								.getBanner3Tarjeta().type(bannerListIterator.next())
								.getSaveButton().click();
				
				softAssert.assertTrue(apiCreateContentP.getMessageCreation().contains(expectedMessage1),
						"doesn't contain the expected message: \"" + expectedMessage1 + "\"");
				break;
				
			case "bienestarPilares":
				
				tarjetaListIterator =  tarjetaList.iterator();
				bannerListIterator =  bannerList.iterator();
				
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
								.getTextLink().type(textLink)
								.getBanner1Pilar().type(bannerListIterator.next())
								.getAddBannerToPilarButton().click()
								.getBanner2Pilar().type(bannerListIterator.next())
								.getAddBannerToPilarButton().click()
								.getBanner3Pilar().type(bannerListIterator.next())
								.getTarjeta1Pilar().type(tarjetaListIterator.next())
								.getAddTarjetaToPilarButton().click()
								.getTarjeta2Pilar().type(tarjetaListIterator.next())
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
				log.info("new content type = " + dataMap.get("contentType"));
				break;
			}
		}
		softAssert.assertAll();
	}
}
