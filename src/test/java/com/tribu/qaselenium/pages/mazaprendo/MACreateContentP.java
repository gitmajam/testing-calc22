package com.tribu.qaselenium.pages.mazaprendo;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class MACreateContentP extends BasePO<MACreateContentP> {

	// control variables
	private String pageUrl = "https://api-beerambassador-stage.somosmaz.com/node/add/content";
	private By menuContentButton = By.xpath("//li/a[@href='/admin/content']");
	private By saveButton = By.xpath("//input[@id='edit-submit']");
	private By messageCursoCreation = By.xpath("html//div//section/div/div/h3");
	private By messageLeccionCreation = By.xpath("html//div//section/div/div/h2");
	private By titleSumary = By.xpath("//div[contains(@class,'node__content clearfix')]//p");
	
	private By addContentButton = By
			.xpath("//div[@id='block-seven-local-actions']/ul[@class='action-links']//a[@href='/node/add']");
	private By addArticleButton = By
			.xpath("//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/article']");
	private By addCursoButton = By
			.xpath("//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/curso']");
	private By addLeccionButton = By
			.xpath("//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/leccion']");
	private By addLeccionF2FButton = By
			.xpath("//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/leccion_presencial']");
	private By addPaginaBasicaButton = By
			.xpath("//div[@id='block-seven-content']/ul[@class='admin-list']//a[@href='/node/add/page']");

	// fields
	private By title = By.xpath("/html//input[@id='edit-title-0-value']");
	private By frame = By.tagName("iframe");
	private By body = By.xpath("//body/p");
	private By etiqueta = By.tagName("/html//input[@id='edit-field-tags-target-id']");
	private By mainImage = By.xpath("/html//input[@id='edit-field-image-0-upload']");
	private By previewMainImage = By
			.xpath("/html//div[contains(@id,'ajax-wrapper')]//img[@data-drupal-selector='edit-field-image-0-preview']");
	private By cursoType = By.xpath("/html//select[@id='edit-field-course-type']");
	private By cursoDigital = By.xpath("/html//select[@id='edit-field-course-type']/option[1]");
	private By cursoPresencial = By.xpath("/html//select[@id='edit-field-course-type']/option[2]");
	private By duracion = By.xpath("/html//input[contains(@id,'edit-field-duracion')]");
	private By duracionF2FLesson = By.xpath("/html//input[contains(@id,'edit-field-minutos')]");
	private By topic = By.xpath("/html//input[@id='edit-field-topic-0-target-id']");
	private By bu = By.xpath("/html//input[@id='edit-field-bu-0-target-id']");
	private By country = By.xpath("/html//input[@id='edit-field-country-0-target-id']");
	private By viceprecidency = By.xpath("/html//input[@id='edit-field-vicepresidency-0-target-id']");
	private By coverImg = By.xpath("/html//input[@id='edit-field-cover-image-0-upload']");
	private By cursoPadre = By.xpath("/html//input[@id='edit-field-curso-padre-0-target-id']");
	private By orderInsideCourse = By.xpath("/html//input[contains(@id,'edit-field-orden')]");
	private By leccionType = By.xpath("/html//select[@id='edit-field-tipo']");
	private By leccionInfogrphicItem = By.xpath("/html//select[@id='edit-field-tipo']/option[2]");
	private By leccionVideoItem = By.xpath("/html//select[@id='edit-field-tipo']/option[3]");
	private By leccionScormItem = By.xpath("/html//select[@id='edit-field-tipo']/option[4]");
	private By infographic = By.xpath("/html//input[contains(@id,'infografia')]");
	private By infoText = By.xpath("/html//body//form/div/div/div[8]//input[1]");
	private By scorm = By.xpath("/html//body//form/div/div/div[9]//input[1]");
	private By pdf = By.xpath("/html//body//form/div/div/div[14]//input");
	private By pdfUploadedLink = By.xpath("/html//body//form/div/div/div[14]//span[contains(@class,'pdf')]");
	private By miniImgInfo = By.xpath("/html//body//form/div/div/div[8]//img");
	private By video = By.xpath("/html//body//form/div/div/div[13]//span/input[contains(@class,'submit')]");
	private By uploadingIcon = By.xpath("//div[@id='edit-field-scorm-0']//div[@class='throbber']");
	private By uploadedHref = By.xpath("html//form/div/div/div[9]/div/div/div//a");
	private By previewCoverImage = By
			.xpath("/html//div[contains(@id,'ajax-wrapper')]//div[@class='image-preview']//img");
	private By altCoverText = By
			.xpath("/html//div[contains(@id,'ajax-wrapper')]/div//input[@name='field_cover_image[0][alt]']");
	private By minScore = By.xpath("/html//body//form/div/div//input[contains(@id,'minimum')]");
	private By attempts = By.xpath("/html//body//form/div/div//input[contains(@id,'attemp')]");

	public MACreateContentP getTitleSumary() {
		this.locator = titleSumary;
		return this;
	}

	public MACreateContentP getDuracionF2FLesson() {
		this.locator = duracionF2FLesson;
		return this;
	}

	public MACreateContentP getAddLeccionF2FButton() {
		this.locator = addLeccionF2FButton;
		return this;
	}
	public MACreateContentP getInfoText() {
		this.locator = infoText;
		return this;
	}
	
	public MACreateContentP getPdfUploadedLink() {
		this.locator = pdfUploadedLink;
		return this;
	}

	public MACreateContentP getMiniImgInfo() {
		this.locator = miniImgInfo;
		return this;
	}

	public MACreateContentP getPdf() {
		this.locator = pdf;
		return this;
	}

	public MACreateContentP getVideo() {
		this.locator = video;
		return this;
	}

	public MACreateContentP getMinScore() {
		this.locator = minScore;
		return this;
	}

	public MACreateContentP getAttempts() {
		this.locator = attempts;
		return this;
	}

	public MACreateContentP getCursoDigital() {
		this.locator = cursoDigital;
		return this;
	}

	public MACreateContentP getCursoPresencial() {
		this.locator = cursoPresencial;
		return this;
	}

	public MACreateContentP getUploadingIcon() {
		this.locator = uploadingIcon;
		return this;
	}

	public MACreateContentP getUploadedHref() {
		this.locator = uploadedHref;
		return this;
	}

	public MACreateContentP getAltCoverText() {
		this.locator = altCoverText;
		return this;
	}

	public MACreateContentP getPreviewCoverImage() {
		this.locator = previewCoverImage;
		return this;
	}

	public MACreateContentP getAddContentButton() {
		this.locator = addContentButton;
		return this;
	}

	public MACreateContentP getAddArticleButton() {
		this.locator = addArticleButton;
		return this;
	}

	public MACreateContentP getAddCursoButton() {
		this.locator = addCursoButton;
		return this;
	}

	public MACreateContentP getAddLeccionButton() {
		this.locator = addLeccionButton;
		return this;
	}

	public MACreateContentP getAddPaginaBasicaButton() {
		this.locator = addPaginaBasicaButton;
		return this;
	}

	public MACreateContentP getTitle() {
		this.locator = title;
		return this;
	}

	public MACreateContentP getFrame() {
		this.locator = frame;
		return this;
	}

	public MACreateContentP getBody() {
		this.locator = body;
		return this;
	}

	public MACreateContentP getEtiqueta() {
		this.locator = etiqueta;
		return this;
	}

	public MACreateContentP getMainImage() {
		this.locator = mainImage;
		return this;
	}

	public MACreateContentP getPreviewMainImage() {
		this.locator = previewMainImage;
		return this;
	}

	public MACreateContentP getCursoType() {
		this.locator = cursoType;
		return this;
	}

	public MACreateContentP getDuracion() {
		this.locator = duracion;
		return this;
	}

	public MACreateContentP getBu() {
		this.locator = bu;
		return this;
	}

	public MACreateContentP getCountry() {
		this.locator = country;
		return this;
	}

	public MACreateContentP getViceprecidency() {
		this.locator = viceprecidency;
		return this;
	}

	public MACreateContentP getCoverImg() {
		this.locator = coverImg;
		return this;
	}

	public MACreateContentP getCursoPadre() {
		this.locator = cursoPadre;
		return this;
	}

	public MACreateContentP getOrderInsideCourse() {
		this.locator = orderInsideCourse;
		return this;
	}

	public MACreateContentP getLeccionType() {
		this.locator = leccionType;
		return this;
	}

	public MACreateContentP getLeccionInfogrphicItem() {
		this.locator = leccionInfogrphicItem;
		return this;
	}

	public MACreateContentP getLeccionVideoItem() {
		this.locator = leccionVideoItem;
		return this;
	}

	public MACreateContentP getLeccionScormItem() {
		this.locator = leccionScormItem;
		return this;
	}

	public MACreateContentP getTopic() {
		this.locator = topic;
		return this;
	}

	public MACreateContentP getInfographic() {
		this.locator = infographic;
		return this;
	}

	public MACreateContentP getScorm() {
		this.locator = scorm;
		return this;
	}

	public MACreateContentP getMenuContentButton() {
		this.locator = menuContentButton;
		return this;
	}

	public MACreateContentP getSaveButton() {
		this.locator = saveButton;
		return this;
	}

	public MACreateContentP getMessageCursoCreation() {
		this.locator = messageCursoCreation;
		return this;
	}

	public MACreateContentP getMessageLeccionCreation() {
		this.locator = messageLeccionCreation;
		return this;
	}

	public MACreateContentP loadContentType(Map<String, String>  provider) {

		this.getLeccionType().type(provider.get("lessonType"));
		switch (provider.get("lessonType")) {
		case "scorm":
			this.getScorm().type(resourcesPath + "media" + File.separator + "scorm" + File.separator + provider.get("scorm"));
			this.getUploadedHref().waitForVisivility();
			break;
		case "pdf":
			this.getPdf().type(resourcesPath + "media" + File.separator + "pdf" + File.separator + provider.get("pdf"));
			this.getPdfUploadedLink().waitForVisivility();
			break;
		case "infografia":
			this.getInfographic().type(resourcesPath + "media" + File.separator + "image" + File.separator + provider.get("infografia"));
			this.getMiniImgInfo().waitForVisivility();
			this.getInfoText().type("infografia");
			break;
		case "video":
			this.getVideo().type(resourcesPath + "media" + File.separator + "video" + File.separator + provider.get("video"));
			//not implemented
			break;
		default:
			break;
		}
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}
}
