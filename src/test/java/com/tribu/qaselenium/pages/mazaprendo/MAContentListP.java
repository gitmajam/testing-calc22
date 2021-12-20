package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class MAContentListP extends BasePO<MAContentListP> {

	private String pageUrl = "https://api-beerambassador-stage.somosmaz.com/admin/content?title=&type=content_banner&status=All&langcode=All&field_country_target_id=All";
	private By profileMenuButton = By.xpath("//li/a[contains(text(),'Mi cuenta')]");
	private By menuContentButton = By.xpath("//li/a[@href='/admin/content']");
	private By addContentButton = By.xpath("//li/a[@href='/node/add']");
	private By addLinksButton = By.xpath("//a[@href='/node/add/content' and contains(text(),'Lista de Enlaces')]");
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

	public MAContentListP getSelectAllCheck() {
		this.locator = selectAllCheck;
		return this;
	}

	public MAContentListP getProfileMenuButton() {
		this.locator = profileMenuButton;
		return this;
	}

	public MAContentListP getMenuContentButton() {
		this.locator = menuContentButton;
		return this;
	}

	public MAContentListP getAddContentButton() {
		this.locator = addContentButton;
		return this;
	}

	public MAContentListP getAddLinksButton() {
		this.locator = addLinksButton;
		return this;
	}

	public MAContentListP getTitlefilterField() {
		this.locator = titlefilterField;
		return this;
	}

	public MAContentListP getfilterButton() {
		this.locator = filterButton;
		return this;
	}

	public MAContentListP getListItem() {
		this.locator = listItem;
		return this;
	}

	public MAContentListP getActionSelect() {
		this.locator = actionSelect;
		return this;
	}

	public MAContentListP getActionDeleteItem() {
		this.locator = actionDeleteItem;
		return this;
	}

	public MAContentListP getSelectItemCheck() {
		this.locator = selectItemCheck;
		return this;
	}

	public MAContentListP getApplyAction() {
		this.locator = applyAction;
		return this;
	}

	public MAContentListP getDeleteButton() {
		this.locator = deleteButton;
		return this;
	}

	public MAContentListP getContentTypeFilter() {
		this.locator = contentTypeFilter;
		return this;
	}

	public MAContentListP getBannerFilter() {
		this.locator = bannerFilter;
		return this;
	}

	public MAContentListP getWellnessEventFilter() {
		this.locator = wellnessEventFilter;
		return this;
	}

	public MAContentListP getWellnessPillarFilter() {
		this.locator = wellnessPillarFilter;
		return this;
	}

	public MAContentListP getWellnessProgramFilter() {
		this.locator = wellnessProgramFilter;
		return this;
	}

	public MAContentListP getDiversityArticleFilter() {
		this.locator = diversityArticleFilter;
		return this;
	}

	public MAContentListP getHubAppFilter() {
		this.locator = hubAppFilter;
		return this;
	}

	public MAContentListP getLinkListFilter() {
		this.locator = linkListFilter;
		return this;
	}

	public MAContentListP getBrandRefFilter() {
		this.locator = brandRefFilter;
		return this;
	}

	public MAContentListP getInfographicsFilter() {
		this.locator = infographicsFilter;
		return this;
	}

	public MAContentListP getVideoFilter() {
		this.locator = videoFilter;
		return this;
	}

	public MAContentListP getActionMessage() {
		this.locator = actionMessage;
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
