package com.tribu.qaselenium.pages.apiba;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class APIContentListP extends BasePO<APIContentListP> {

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
	private By selectItemCheck = By
			.xpath("//tbody/tr[1]//input[@type='checkbox']");
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

	public APIContentListP getProfileMenuButton() {
		this.locator = profileMenuButton;
		return this;
	}

	public APIContentListP getMenuContentButton() {
		this.locator = menuContentButton;
		return this;
	}

	public APIContentListP getAddContentButton() {
		this.locator = addContentButton;
		return this;
	}

	public APIContentListP getAddLinksButton() {
		this.locator = addLinksButton;
		return this;
	}

	public APIContentListP getTitlefilterField() {
		this.locator = titlefilterField;
		return this;
	}

	public APIContentListP getfilterButton() {
		this.locator = filterButton;
		return this;
	}

	public APIContentListP getListItem() {
		this.locator = listItem;
		return this;
	}

	public APIContentListP getActionSelect() {
		this.locator = actionSelect;
		return this;
	}

	public APIContentListP getActionDeleteItem() {
		this.locator = actionDeleteItem;
		return this;
	}

	public APIContentListP getSelectItemCheck() {
		this.locator = selectItemCheck;
		return this;
	}

	public APIContentListP getApplyAction() {
		this.locator = applyAction;
		return this;
	}

	public APIContentListP getDeleteButton() {
		this.locator = deleteButton;
		return this;
	}

	public APIContentListP getContentTypeFilter() {
		this.locator = contentTypeFilter;
		return this;
	}

	public APIContentListP getBannerFilter() {
		this.locator = bannerFilter;
		return this;
	}

	public APIContentListP getWellnessEventFilter() {
		this.locator = wellnessEventFilter;
		return this;
	}

	public APIContentListP getWellnessPillarFilter() {
		this.locator = wellnessPillarFilter;
		return this;
	}

	public APIContentListP getWellnessProgramFilter() {
		this.locator = wellnessProgramFilter;
		return this;
	}

	public APIContentListP getDiversityArticleFilter() {
		this.locator = diversityArticleFilter;
		return this;
	}

	public APIContentListP getHubAppFilter() {
		this.locator = hubAppFilter;
		return this;
	}

	public APIContentListP getLinkListFilter() {
		this.locator = linkListFilter;
		return this;
	}

	public APIContentListP getBrandRefFilter() {
		this.locator = brandRefFilter;
		return this;
	}

	public APIContentListP getInfographicsFilter() {
		this.locator = infographicsFilter;
		return this;
	}

	public APIContentListP getVideoFilter() {
		this.locator = videoFilter;
		return this;
	}

	public APIContentListP getActionMessage() {
		this.locator = actionMessage;
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
