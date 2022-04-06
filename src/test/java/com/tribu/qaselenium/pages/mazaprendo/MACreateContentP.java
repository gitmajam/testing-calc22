package com.tribu.qaselenium.pages.mazaprendo;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
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

	public MACreateContentP getMenuContentButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuContentButton,predicates);
	return this;
	}

	public MACreateContentP getSaveButton(Predicate<WebElement>... predicates){
	this.setWebElement(saveButton,predicates);
	return this;
	}

	public MACreateContentP getMessageCursoCreation(Predicate<WebElement>... predicates){
	this.setWebElement(messageCursoCreation,predicates);
	return this;
	}

	public MACreateContentP getMessageLeccionCreation(Predicate<WebElement>... predicates){
	this.setWebElement(messageLeccionCreation,predicates);
	return this;
	}

	public MACreateContentP getTitleSumary(Predicate<WebElement>... predicates){
	this.setWebElement(titleSumary,predicates);
	return this;
	}

	public MACreateContentP getAddContentButton(Predicate<WebElement>... predicates){
	this.setWebElement(addContentButton,predicates);
	return this;
	}

	public MACreateContentP getAddArticleButton(Predicate<WebElement>... predicates){
	this.setWebElement(addArticleButton,predicates);
	return this;
	}

	public MACreateContentP getAddCursoButton(Predicate<WebElement>... predicates){
	this.setWebElement(addCursoButton,predicates);
	return this;
	}

	public MACreateContentP getAddLeccionButton(Predicate<WebElement>... predicates){
	this.setWebElement(addLeccionButton,predicates);
	return this;
	}

	public MACreateContentP getAddLeccionF2FButton(Predicate<WebElement>... predicates){
	this.setWebElement(addLeccionF2FButton,predicates);
	return this;
	}

	public MACreateContentP getAddPaginaBasicaButton(Predicate<WebElement>... predicates){
	this.setWebElement(addPaginaBasicaButton,predicates);
	return this;
	}

	public MACreateContentP getTitle(Predicate<WebElement>... predicates){
	this.setWebElement(title,predicates);
	return this;
	}

	public MACreateContentP getFrame(Predicate<WebElement>... predicates){
	this.setWebElement(frame,predicates);
	return this;
	}

	public MACreateContentP getBody(Predicate<WebElement>... predicates){
	this.setWebElement(body,predicates);
	return this;
	}

	public MACreateContentP getEtiqueta(Predicate<WebElement>... predicates){
	this.setWebElement(etiqueta,predicates);
	return this;
	}

	public MACreateContentP getMainImage(Predicate<WebElement>... predicates){
	this.setWebElement(mainImage,predicates);
	return this;
	}

	public MACreateContentP getPreviewMainImage(Predicate<WebElement>... predicates){
	this.setWebElement(previewMainImage,predicates);
	return this;
	}

	public MACreateContentP getCursoType(Predicate<WebElement>... predicates){
	this.setWebElement(cursoType,predicates);
	return this;
	}

	public MACreateContentP getCursoDigital(Predicate<WebElement>... predicates){
	this.setWebElement(cursoDigital,predicates);
	return this;
	}

	public MACreateContentP getCursoPresencial(Predicate<WebElement>... predicates){
	this.setWebElement(cursoPresencial,predicates);
	return this;
	}

	public MACreateContentP getDuracion(Predicate<WebElement>... predicates){
	this.setWebElement(duracion,predicates);
	return this;
	}

	public MACreateContentP getDuracionF2FLesson(Predicate<WebElement>... predicates){
	this.setWebElement(duracionF2FLesson,predicates);
	return this;
	}

	public MACreateContentP getTopic(Predicate<WebElement>... predicates){
	this.setWebElement(topic,predicates);
	return this;
	}

	public MACreateContentP getBu(Predicate<WebElement>... predicates){
	this.setWebElement(bu,predicates);
	return this;
	}

	public MACreateContentP getCountry(Predicate<WebElement>... predicates){
	this.setWebElement(country,predicates);
	return this;
	}

	public MACreateContentP getViceprecidency(Predicate<WebElement>... predicates){
	this.setWebElement(viceprecidency,predicates);
	return this;
	}

	public MACreateContentP getCoverImg(Predicate<WebElement>... predicates){
	this.setWebElement(coverImg,predicates);
	return this;
	}

	public MACreateContentP getCursoPadre(Predicate<WebElement>... predicates){
	this.setWebElement(cursoPadre,predicates);
	return this;
	}

	public MACreateContentP getOrderInsideCourse(Predicate<WebElement>... predicates){
	this.setWebElement(orderInsideCourse,predicates);
	return this;
	}

	public MACreateContentP getLeccionType(Predicate<WebElement>... predicates){
	this.setWebElement(leccionType,predicates);
	return this;
	}

	public MACreateContentP getLeccionInfogrphicItem(Predicate<WebElement>... predicates){
	this.setWebElement(leccionInfogrphicItem,predicates);
	return this;
	}

	public MACreateContentP getLeccionVideoItem(Predicate<WebElement>... predicates){
	this.setWebElement(leccionVideoItem,predicates);
	return this;
	}

	public MACreateContentP getLeccionScormItem(Predicate<WebElement>... predicates){
	this.setWebElement(leccionScormItem,predicates);
	return this;
	}

	public MACreateContentP getInfographic(Predicate<WebElement>... predicates){
	this.setWebElement(infographic,predicates);
	return this;
	}

	public MACreateContentP getInfoText(Predicate<WebElement>... predicates){
	this.setWebElement(infoText,predicates);
	return this;
	}

	public MACreateContentP getScorm(Predicate<WebElement>... predicates){
	this.setWebElement(scorm,predicates);
	return this;
	}

	public MACreateContentP getPdf(Predicate<WebElement>... predicates){
	this.setWebElement(pdf,predicates);
	return this;
	}

	public MACreateContentP getPdfUploadedLink(Predicate<WebElement>... predicates){
	this.setWebElement(pdfUploadedLink,predicates);
	return this;
	}

	public MACreateContentP getMiniImgInfo(Predicate<WebElement>... predicates){
	this.setWebElement(miniImgInfo,predicates);
	return this;
	}

	public MACreateContentP getVideo(Predicate<WebElement>... predicates){
	this.setWebElement(video,predicates);
	return this;
	}

	public MACreateContentP getUploadingIcon(Predicate<WebElement>... predicates){
	this.setWebElement(uploadingIcon,predicates);
	return this;
	}

	public MACreateContentP getUploadedHref(Predicate<WebElement>... predicates){
	this.setWebElement(uploadedHref,predicates);
	return this;
	}

	public MACreateContentP getPreviewCoverImage(Predicate<WebElement>... predicates){
	this.setWebElement(previewCoverImage,predicates);
	return this;
	}

	public MACreateContentP getAltCoverText(Predicate<WebElement>... predicates){
	this.setWebElement(altCoverText,predicates);
	return this;
	}

	public MACreateContentP getMinScore(Predicate<WebElement>... predicates){
	this.setWebElement(minScore,predicates);
	return this;
	}

	public MACreateContentP getAttempts(Predicate<WebElement>... predicates){
	this.setWebElement(attempts,predicates);
	return this;
	}
	@SuppressWarnings("unchecked")
	public MACreateContentP loadContentType(Map<String, String>  provider) {

		this.getLeccionType().type(provider.get("lessonType"));
		switch (provider.get("lessonType")) {
		case "scorm":
			this.getScorm().type(resourcesPath + "media" + File.separator + "scorm" + File.separator + provider.get("scorm"));
			this.getUploadedHref().waitForVisibility();
			break;
		case "pdf":
			this.getPdf().type(resourcesPath + "media" + File.separator + "pdf" + File.separator + provider.get("pdf"));
			this.getPdfUploadedLink().waitForVisibility();
			break;
		case "infografia":
			this.getInfographic().type(resourcesPath + "media" + File.separator + "image" + File.separator + provider.get("infografia"));
			this.getMiniImgInfo().waitForVisibility();
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
