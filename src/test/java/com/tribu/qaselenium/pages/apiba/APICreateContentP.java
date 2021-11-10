package com.tribu.qaselenium.pages.apiba;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class APICreateContentP extends BasePO<APICreateContentP> {

	// control variables
	private By menuContentButton = By.xpath("//li/a[@href='/admin/content']");
	private String pageUrl = "https://api-beerambassador-stage.somosmaz.com/node/add/content";
	private By saveButton = By.xpath("//input[@id='edit-submit']");
	private By messageCreation = By.xpath(
			"/html//div[@id='page']/div[@class='highlighted']/aside[@role='complementary']//div[@role='contentinfo']");
	private By addArticleButton = By.xpath(
			"//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/article']/span[@class='label']");
	private By addBannerButton = By.xpath(
			"//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/content_banner']/span[@class='label']");
	private By addWellnessEventButton = By.xpath(
			"//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/bienestar_eventos']/span[@class='label']");
	private By addWellnessPillarButton = By.xpath(
			"//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/bienestar_pilares']/span[@class='label']");
	private By addWellnessProgramsButton = By.xpath(
			"//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/bienestar_programas']/span[@class='label']");
	private By addDiversityArticleButton = By.xpath(
			"//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/diversidad_articulos']/span[@class='label']");
	private By addGalleryButton = By.xpath(
			"//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/galeria']/span[@class='label']");
	private By addHubAppButton = By.xpath(
			"//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/hub']/span[@class='label']");
	private By addInfograPhicButton = By.xpath(
			"//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/infografia']/span[@class='label']");
	private By addLinkListButton = By.xpath(
			"//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/content']/span[@class='label']");
	private By addBrandRefButton = By.xpath(
			"//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/referencia_marca']/span[@class='label']");
	private By addVideoButton = By.xpath(
			"//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/video']/span[@class='label']");

	// content variables
	private By brand = By.xpath("/html//input[@id='edit-field-marca-0-target-id']");
	private By title = By.xpath("//input[@id='edit-title-0-value']");
	private By focoRelations = By.xpath("//details[@id='edit-relations']//span[.='Relaciones']");
	private By focoRelationsItem = By.xpath("//select[@id='edit-parent']/option[@value='8']");
	private By focoRelationsWeight = By.xpath("/html//input[@id='edit-weight']");
	private By focoUrlAlias = By.xpath("/html//input[@id='edit-path-0-alias']");
	private By contentTitle = By.xpath("/html//input[@id='edit-field-titulo-contenido-0-value']");
	private By subtitle = By.xpath("/html//input[@id='edit-field-subtitulo-0-value']");
	private By articleType = By.xpath("/html//select[@id='edit-field-tipo-articulo']");
	private By articleTypeItem = By.xpath("/html//select[@id='edit-field-tipo-articulo']/option[@value='Blog']");
	private By frame = By.tagName("iframe");
	private By body = By.xpath("//body/p");
	private By mainImage = By.xpath("//html//input[contains(@id,'edit-field-image-0-upload')]");
	private By previewMainImage = By
			.xpath("/html//div[contains(@id,'ajax-wrapper')]//img[@data-drupal-selector='edit-field-image-0-preview']");
	private By previewHighLImage = By.xpath("/html//div[@id='edit-field-imagen-destacada-wrapper']/div/div//img");

	private By mainImageIcon = By.xpath("//img[contains(@src,'diversidad') and contains(@src,'.jpg')]");
	private By highLImage = By.xpath("/html//input[@id='edit-field-imagen-destacada-0-upload']");
	private By miniImage = By.xpath("/html//input[@id='edit-field-imagen-miniatura-0-upload']");
	private By socialIcon = By.xpath("//input[@name='files[field_referencia_social_0_subform_field_social_icon_0]']");
	private By refAtributeTitle = By.xpath(
			"//input[@name='field_referencia_atributos[0][subform][field_referencia_atributo_titulo][0][value]']");
	private By refAtributeValue = By.xpath(
			"//input[@name='field_referencia_atributos[0][subform][field_referencia_atributo_valor][0][value]']");
	private By refAtributeTitleDescription = By.xpath(
			"//input[@name='field_referencia_atributos[0][subform][field_ref_atributo_titulo_descri][0][value]']");
	private By refAtributeDescription = By.xpath(
			"//textarea[@name='field_referencia_atributos[0][subform][field_ref_atributo_descripcion][0][value]']");
	private By refAtributeIcon = By
			.xpath("//input[@name='files[field_referencia_atributos_0_subform_field_referencia_atributo_icono_0]']");
	private By hubCategoryItem = By.xpath("//select[@id='edit-field-hub-categorias']/option[@value='Onboard']");
	private By wellnessPillar = By.xpath("/html//input[@id='edit-field-bienestar-pilar-0-target-id']");
	private By information = By.xpath("/html//textarea[@id='edit-field-informacion-0-value']");
	private By autor = By.xpath("/html//input[@id='edit-field-autor-0-value']");
	private By direccion = By.xpath("/html//input[@id='edit-field-direccion-0-value']");
	private By date = By.xpath("/html//input[@id='edit-field-fecha-0-value-date']");
	private By phone = By.xpath("/html//input[@id='edit-field-telefono-0-value']");

	private By socialUrl = By.xpath("//input[@name='field_referencia_social[0][subform][field_social_url][0][uri]']");
	private By socialUrlText = By
			.xpath("//input[@name='field_referencia_social[0][subform][field_social_url][0][title]']");
	private By link = By.xpath("//input[@id='edit-field-link-0-uri']");
	private By textLink = By.xpath("/html//input[@id='edit-field-link-0-title']");
	private By section = By.xpath("//input[@id='edit-field-section-0-target-id']");
	private By column = By.xpath("//select[@id='edit-field-column']");
	private By columnItem = By.xpath("/html//select[@id='edit-field-column']//option[@value='1']");
	private By multimediaContent = By.xpath("/html//input[@name='field_contenido_multimedia[0][target_id]']");
	private By video = By.xpath("/html//input[@id='edit-field-video-open-button']");
	private By country = By.xpath("//input[@id='edit-field-country-0-target-id']");
	private By published = By.xpath("//input[@id='edit-status-value']");
	private By extLink = By.xpath("/html//input[@id='edit-field-enlace-externo-0-uri']");
	private By textExtLink = By.xpath("/html//input[@id='edit-field-enlace-externo-0-title']");
	private By diversityFocus = By.xpath("/html//input[@id='edit-field-section-0-target-id']");
	private By alterTextHLImg = By.xpath(
			"/html//div[@id='edit-field-imagen-destacada-wrapper']/div/div//input[@name='field_imagen_destacada[0][alt]']");
	private By titleHLImg = By.xpath("/html//div[@id='edit-field-imagen-destacada-wrapper']/div/div//input[@name='field_imagen_destacada[0][title]']");

	public APICreateContentP getAlterTextHLImg() {
		this.locator = alterTextHLImg;
		return this;
	}

	public APICreateContentP getTitleHLImg() {
		this.locator = titleHLImg;
		return this;
	}

	public APICreateContentP getDiversityFocus() {
		this.locator = diversityFocus;
		return this;
	}

	public APICreateContentP getTextExtLink() {
		this.locator = textExtLink;
		return this;
	}

	public APICreateContentP getExtLink() {
		this.locator = extLink;
		return this;
	}

	public APICreateContentP getMenuContentButton() {
		this.locator = menuContentButton;
		return this;
	}

	public APICreateContentP getSaveButton() {
		this.locator = saveButton;
		return this;
	}

	public APICreateContentP getMessageCreation() {
		this.locator = messageCreation;
		return this;
	}

	public APICreateContentP getAddArticleButton() {
		this.locator = addArticleButton;
		return this;
	}

	public APICreateContentP getAddBannerButton() {
		this.locator = addBannerButton;
		return this;
	}

	public APICreateContentP getAddWellnessEventButton() {
		this.locator = addWellnessEventButton;
		return this;
	}

	public APICreateContentP getAddWellnessPillarButton() {
		this.locator = addWellnessPillarButton;
		return this;
	}

	public APICreateContentP getAddWellnessProgramsButton() {
		this.locator = addWellnessProgramsButton;
		return this;
	}

	public APICreateContentP getAddDiversityArticleButton() {
		this.locator = addDiversityArticleButton;
		return this;
	}

	public APICreateContentP getAddGalleryButton() {
		this.locator = addGalleryButton;
		return this;
	}

	public APICreateContentP getAddHubAppButton() {
		this.locator = addHubAppButton;
		return this;
	}

	public APICreateContentP getAddInfograPhicButton() {
		this.locator = addInfograPhicButton;
		return this;
	}

	public APICreateContentP getAddLinkListButton() {
		this.locator = addLinkListButton;
		return this;
	}

	public APICreateContentP getAddBrandRefButton() {
		this.locator = addBrandRefButton;
		return this;
	}

	public APICreateContentP getAddVideoButton() {
		this.locator = addVideoButton;
		return this;
	}

	public APICreateContentP getBrand() {
		this.locator = brand;
		return this;
	}

	public APICreateContentP getTitle() {
		this.locator = title;
		return this;
	}

	public APICreateContentP getFocoRelations() {
		this.locator = focoRelations;
		return this;
	}

	public APICreateContentP getFocoRelationsItem() {
		this.locator = focoRelationsItem;
		return this;
	}

	public APICreateContentP getFocoRelationsWeight() {
		this.locator = focoRelationsWeight;
		return this;
	}

	public APICreateContentP getFocoUrlAlias() {
		this.locator = focoUrlAlias;
		return this;
	}

	public APICreateContentP getContentTitle() {
		this.locator = contentTitle;
		return this;
	}

	public APICreateContentP getSubtitle() {
		this.locator = subtitle;
		return this;
	}

	public APICreateContentP getArticleType() {
		this.locator = articleType;
		return this;
	}

	public APICreateContentP getArticleTypeItem() {
		this.locator = articleTypeItem;
		return this;
	}

	public APICreateContentP getFrame() {
		this.locator = frame;
		return this;
	}

	public APICreateContentP getBody() {
		this.locator = body;
		return this;
	}

	public APICreateContentP getMainImage() {
		this.locator = mainImage;
		return this;
	}

	public APICreateContentP getPreviewMainImage() {
		this.locator = previewMainImage;
		return this;
	}

	public APICreateContentP getMainImageIcon() {
		this.locator = mainImageIcon;
		return this;
	}

	public APICreateContentP getHighLImage() {
		this.locator = highLImage;
		return this;
	}

	public APICreateContentP getPreviewHighLImage() {
		this.locator = previewHighLImage;
		return this;
	}

	public APICreateContentP getMiniImage() {
		this.locator = miniImage;
		return this;
	}

	public APICreateContentP getSocialIcon() {
		this.locator = socialIcon;
		return this;
	}

	public APICreateContentP getRefAtributeTitle() {
		this.locator = refAtributeTitle;
		return this;
	}

	public APICreateContentP getRefAtributeValue() {
		this.locator = refAtributeValue;
		return this;
	}

	public APICreateContentP getRefAtributeTitleDescription() {
		this.locator = refAtributeTitleDescription;
		return this;
	}

	public APICreateContentP getRefAtributeDescription() {
		this.locator = refAtributeDescription;
		return this;
	}

	public APICreateContentP getRefAtributeIcon() {
		this.locator = refAtributeIcon;
		return this;
	}

	public APICreateContentP getHubCategoryItem() {
		this.locator = hubCategoryItem;
		return this;
	}

	public APICreateContentP getWellnessPillar() {
		this.locator = wellnessPillar;
		return this;
	}

	public APICreateContentP getInformation() {
		this.locator = information;
		return this;
	}

	public APICreateContentP getAutor() {
		this.locator = autor;
		return this;
	}

	public APICreateContentP getDireccion() {
		this.locator = direccion;
		return this;
	}

	public APICreateContentP getDate() {
		this.locator = date;
		return this;
	}

	public APICreateContentP getPhone() {
		this.locator = phone;
		return this;
	}

	public APICreateContentP getTextLink() {
		this.locator = textLink;
		return this;
	}

	public APICreateContentP getSocialUrl() {
		this.locator = socialUrl;
		return this;
	}

	public APICreateContentP getSocialUrlText() {
		this.locator = socialUrlText;
		return this;
	}

	public APICreateContentP getLink() {
		this.locator = link;
		return this;
	}

	public APICreateContentP getSection() {
		this.locator = section;
		return this;
	}

	public APICreateContentP getColumn() {
		this.locator = column;
		return this;
	}

	public APICreateContentP getColumnItem() {
		this.locator = columnItem;
		return this;
	}

	public APICreateContentP getMultimediaContent() {
		this.locator = multimediaContent;
		return this;
	}

	public APICreateContentP getVideo() {
		this.locator = video;
		return this;
	}

	public APICreateContentP getCountry() {
		this.locator = country;
		return this;
	}

	public APICreateContentP getPublished() {
		this.locator = published;
		return this;
	}

	// fraction of the whole width of the page taht spend the image, ex. 1 = the
	// whole width.

	@Override
	public String getPageUrl() {
		return pageUrl;
	}
}
