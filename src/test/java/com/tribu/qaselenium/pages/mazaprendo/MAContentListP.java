package com.tribu.qaselenium.pages.mazaprendo;

import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class MAContentListP extends BasePO<MAContentListP> {

	private String pageUrl = "https://api-beerambassador-stage.somosmaz.com/admin/content?title=&type=content_banner&status=All&langcode=All&field_country_target_id=All";

	private By profileMenuButton = By.xpath("//li/a[contains(text(),'Mi cuenta')]");
	private By menuContentButton = By.xpath("//li/a[contains(@href,'/admin/content')]");
	private By addContentButton = By.xpath("//li/a[contains(@href,'/node/add')]");
	private By addLinksButton = By.xpath("//a[contains(@href,'/node/add/content' and contains(text(),'Lista de Enlaces')]");
	private By titlefilterField = By.xpath("/html//input[@id='edit-title']");
	private By filterButton = By.xpath("/html//input[@id='edit-submit-content']");
	private By listItem = By.xpath(
			"//form[@id='views-form-content-page-1']/table/tbody/tr[1]/td[@class='views-field views-field-title']");
	private By actionSelect = By.xpath("/html//select[@id='edit-action']");
	private By actionDeleteItem = By.xpath("/html//select[@id='edit-action']/option[@value='node_delete_action']");
	private By selectItemCheck = By.xpath("//tbody/tr[1]//input[@type='checkbox']");
	private By applyAction = By.xpath("/html//input[@id='edit-submit--2']");
	private By deleteButton = By.xpath("/html//input[@id='edit-submit']");
	private By contentTypeFilter = By.xpath("/html//select[@id='edit-type']");

	private By bannerFilter = By.xpath("/html//select[@id='edit-type']/option[@value='content_banner']");
	private By wellnessEventFilter = By.xpath("/html//select[@id='edit-type']/option[@value='bienestar_eventos']");
	private By wellnessPillarFilter = By.xpath("/html//select[@id='edit-type']/option[@value='bienestar_pilares']");
	private By wellnessProgramFilter = By.xpath("/html//select[@id='edit-type']/option[@value='bienestar_programa']");
	private By diversityArticleFilter = By
			.xpath("/html//select[@id='edit-type']/option[@value='diversidad_articulos']");
	private By hubAppFilter = By.xpath("/html//select[@id='edit-type']/option[@value='hub']");
	private By linkListFilter = By.xpath("/html//select[@id='edit-type']/option[@value='infografia']");
	private By brandRefFilter = By.xpath("/html//select[@id='edit-type']/option[@value='content']");
	private By infographicsFilter = By.xpath("/html//select[@id='edit-type']/option[@value='referencia_marca']");
	private By videoFilter = By.xpath("/html//select[@id='edit-type']/option[@value='video']");
	private By actionMessage = By
			.xpath("/html/body//main[@role='main']/div[@class='region region-highlighted']/div[2]/div[1]");
	private By selectAllCheck = By.xpath(
			"/html//form[@id='views-form-content-page-1']/table//input[@title='Seleccionar todas las filas de esta tabla']");
	private By emptyMessage = By.xpath("//form[@id='views-form-content-page-1']/table//td[@class='views-empty']");
	
	public MAContentListP getProfileMenuButton(Predicate<WebElement>... predicates){
	this.setWebElement(profileMenuButton,predicates);
	return this;
	}

	public MAContentListP getMenuContentButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuContentButton,predicates);
	return this;
	}

	public MAContentListP getAddContentButton(Predicate<WebElement>... predicates){
	this.setWebElement(addContentButton,predicates);
	return this;
	}

	public MAContentListP getAddLinksButton(Predicate<WebElement>... predicates){
	this.setWebElement(addLinksButton,predicates);
	return this;
	}

	public MAContentListP getTitlefilterField(Predicate<WebElement>... predicates){
	this.setWebElement(titlefilterField,predicates);
	return this;
	}

	public MAContentListP getFilterButton(Predicate<WebElement>... predicates){
	this.setWebElement(filterButton,predicates);
	return this;
	}

	public MAContentListP getListItem(Predicate<WebElement>... predicates){
	this.setWebElement(listItem,predicates);
	return this;
	}

	public MAContentListP getActionSelect(Predicate<WebElement>... predicates){
	this.setWebElement(actionSelect,predicates);
	return this;
	}

	public MAContentListP getActionDeleteItem(Predicate<WebElement>... predicates){
	this.setWebElement(actionDeleteItem,predicates);
	return this;
	}

	public MAContentListP getSelectItemCheck(Predicate<WebElement>... predicates){
	this.setWebElement(selectItemCheck,predicates);
	return this;
	}

	public MAContentListP getApplyAction(Predicate<WebElement>... predicates){
	this.setWebElement(applyAction,predicates);
	return this;
	}

	public MAContentListP getDeleteButton(Predicate<WebElement>... predicates){
	this.setWebElement(deleteButton,predicates);
	return this;
	}

	public MAContentListP getContentTypeFilter(Predicate<WebElement>... predicates){
	this.setWebElement(contentTypeFilter,predicates);
	return this;
	}

	public MAContentListP getBannerFilter(Predicate<WebElement>... predicates){
	this.setWebElement(bannerFilter,predicates);
	return this;
	}

	public MAContentListP getWellnessEventFilter(Predicate<WebElement>... predicates){
	this.setWebElement(wellnessEventFilter,predicates);
	return this;
	}

	public MAContentListP getWellnessPillarFilter(Predicate<WebElement>... predicates){
	this.setWebElement(wellnessPillarFilter,predicates);
	return this;
	}

	public MAContentListP getWellnessProgramFilter(Predicate<WebElement>... predicates){
	this.setWebElement(wellnessProgramFilter,predicates);
	return this;
	}

	public MAContentListP getDiversityArticleFilter(Predicate<WebElement>... predicates){
	this.setWebElement(diversityArticleFilter,predicates);
	return this;
	}

	public MAContentListP getHubAppFilter(Predicate<WebElement>... predicates){
	this.setWebElement(hubAppFilter,predicates);
	return this;
	}

	public MAContentListP getLinkListFilter(Predicate<WebElement>... predicates){
	this.setWebElement(linkListFilter,predicates);
	return this;
	}

	public MAContentListP getBrandRefFilter(Predicate<WebElement>... predicates){
	this.setWebElement(brandRefFilter,predicates);
	return this;
	}

	public MAContentListP getInfographicsFilter(Predicate<WebElement>... predicates){
	this.setWebElement(infographicsFilter,predicates);
	return this;
	}

	public MAContentListP getVideoFilter(Predicate<WebElement>... predicates){
	this.setWebElement(videoFilter,predicates);
	return this;
	}

	public MAContentListP getActionMessage(Predicate<WebElement>... predicates){
	this.setWebElement(actionMessage,predicates);
	return this;
	}

	public MAContentListP getSelectAllCheck(Predicate<WebElement>... predicates){
	this.setWebElement(selectAllCheck,predicates);
	return this;
	}

	public MAContentListP getEmptyMessage(Predicate<WebElement>... predicates){
	this.setWebElement(emptyMessage,predicates);
	return this;
	}

	@SuppressWarnings("unchecked")
	public MAContentListP removeContent(SoftAssert assertion) {
		this.getSelectAllCheck().click()
			.getApplyAction().click()
			.getDeleteButton().click()
			.getActionMessage(e->e.getText().contains("Eliminado")).assertExist(assertion::assertTrue);
			log.info("past courses removed");
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
