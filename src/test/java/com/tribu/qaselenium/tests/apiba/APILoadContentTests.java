package com.tribu.qaselenium.tests.apiba;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.BiFunction;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
	
	//page variables
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
	
	//assert variables
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
	String urlLink;
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
	
	
	BiFunction<String, String, APIHomeP> apilogin = (s, p) -> {
		apiLandingP = openUrl(APILandingP::new).get();
		apiLoginP = apiLandingP.getLoginButton().click(APILoginP::new).get();
		return apiLoginP.getSharpIdField().type(s)
				.getPasswordField().type(p)
				.getLoginButton().click(APIHomeP::new).get();
	};
	
	BiFunction<String, String, BPHomeP> bplogin = (s, p) -> {
		bpLandingP = openUrl(BPLandingP::new).get();
		ssoLandingP = bpLandingP.getLoginButton().click(SSOLandingP::new).get();
		ssoLoginP = ssoLandingP.getSharpIdButton().click(SSOLoginP::new).get();

		return ssoLoginP.getSharpIdField().type(s).getPasswordField().type(p).getLoginButton().click(BPHomeP::new)
				.get();
	};

	@Test(dataProvider = "csvReaderMethod", dataProviderClass = CsvDataProviders.class, dependsOnGroups = {
			"checkContent" }, groups = { "smoke", "loadContent" })
	public void banner(Method method, Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();

		title = testData.get("title");
		country = testData.get("country");
		mainImage = testData.get("mainImage");
		description = testData.get("description");
		link = testData.get("link");
		section = testData.get("section");
		published = testData.get("published");
		guardar = testData.get("guardar");
		sharpId1 = testData.get("sharpId1");
		password1 = testData.get("password1");
		expectedMessage1 = testData.get("expectedMessage1");
		expectedMessage2 = testData.get("expectedMessage2");
		testDescription = testData.get("testDescription");
		
		// path for upload files
		String imgDir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "images" + File.separator
				+ method.getDeclaringClass().getSimpleName() + File.separator + method.getName() + File.separator
				+ mainImage;

		// login		
		apiHomeP = apilogin.apply(sharpId1, password1);
		
		softAssert.assertTrue(apiHomeP.getMenuContentButton().isDisplayed(), "[Falla Assert - no encuentra boton de contenido");
	
		apiCreateContentP = apiHomeP.getMenuContentButton().hoverElement()
				.getAddContentButton().hoverElement() 
				.getAddBanner().click(APICreateContentP::new).get();
		 
		apiCreateContentP.getTitle().type(title + getTodaysDate() + getSystemTime())
						.getFrame().swichToFrame()
						.getBody().type(description)
						.swichToMain()
						.getMainImage().type(imgDir)
						.getPreviewMainImage().waitForImage()
						.getLink().type(link)
						.getSection().type(section)
						.getCountry().clear()
						.getCountry().type(country)
						.getSaveButton().click();
		
		// Assertions
		softAssert.assertTrue(apiCreateContentP.getMessageCreation().contains(expectedMessage1),
				"doesn't contain the expected message: \"" + expectedMessage1 + "\"");
		softAssert.assertAll();
	}

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class, dependsOnGroups = {
			"checkContent" }, groups = { "smoke", "deleteContent" })
	public void deleteContent(Method method, Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();
		
		title = testData.get("title");
		link = testData.get("link");
		sharpId1 = testData.get("sharpId1");
		password1 = testData.get("password1");
		expectedMessage1 = testData.get("expectedMessage1");
		expectedMessage2 = testData.get("expectedMessage2");
		testDescription = testData.get("testDescription");
		
		//path for upload files
		String imgDir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator
				+ "images" + File.separator + method.getDeclaringClass().getSimpleName() + File.separator
				+ method.getName() + File.separator + mainImage;

		// login		
		apiHomeP = apilogin.apply(sharpId1, password1);
		
		softAssert.assertTrue(apiHomeP.getMenuContentButton().isDisplayed(), "[Falla Assert - no encuentra boton de contenido");
	
		apiContentListP = apiHomeP.getMenuContentButton().click(APIContentListP::new).get();
		
		apiContentListP.getTitlefilterField().type(title + this.getTodaysDate())
						.getActionSelect().click()
						.getActionDeleteItem().click()
						.getActionSelect().click()
						.getfilterButton().click()
						.getSelectItemCheck().click()
						.getApplyAction().click()
						.getDeleteButton().click();
			
		// Assertions
		softAssert.assertTrue(apiContentListP.getActionMessage().contains(expectedMessage2),
				"doesn't contain the expected message: \"" + expectedMessage2+ "\"");
		softAssert.assertAll();
	}

	@Test(dataProvider = "csvReaderMethod", dataProviderClass = CsvDataProviders.class, groups = { "smoke",
			"checkContent" })
	public void bannerCheck(Method method, Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();

		sharpId2 = testData.get("sharpId2");
		password2 = testData.get("password2");
		expectedMessage1 = testData.get("expectedMessage1");
		expectedMessage2 = testData.get("expectedMessage2");
		testDescription = testData.get("testDescription");
		title = testData.get("title");
		log.info("carga variables");
		// login
		//bpHomeP = bplogin.apply(sharpId2, password2);
		bpLandingP = openUrl(BPLandingP::new).get();
		ssoLandingP = bpLandingP.getLoginButton().click(SSOLandingP::new).get();
		ssoLoginP = ssoLandingP.getSharpIdButton().click(SSOLoginP::new).get();

		bpHomeP = ssoLoginP.getSharpIdField().type(sharpId2).getPasswordField().type(password2).getLoginButton().click(BPHomeP::new)
				.get();
		
		log.info("depues de login");
		bpHomeP.getBPLogo().waitForImage();
		log.info("despues de esperar logo");

		softAssert.assertTrue(bpHomeP.getXpathPartBanner().waitForImage(title).verifyImage(),
				"[Falla Assert - no encuentra banner");
		softAssert.assertAll();
		log.info("despues de asserts");
		bpHomeP.getExitButton().click();
		log.info("despues de click en exit");
	}

}
