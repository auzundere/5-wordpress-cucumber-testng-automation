package com.wordpress.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.utilities.Driver;

public class PagePage {

	private WebDriver driver;

	public PagePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='wp-heading-inline']/../a")
	public WebElement addNewButton;

	@FindBy(xpath = "//h1[@class='wp-heading-inline']")
	public WebElement titleAddNewPage;

	@FindBy(xpath = "//div[@id='ed_toolbar']/input")
	public List<WebElement> textFieldButtons;

	@FindBy(id = "content-tmce")
	public WebElement tabVisual;

	@FindBy(id = "content-html")
	public WebElement tabText;

	@FindBy(id = "content-panels")
	public WebElement tabPageBuilder;

	@FindBy(xpath = "//button[@class='button insert-media add_media']")
	public WebElement buttonAddMedia;

	@FindBy(xpath = "//div[@class='so-builder-toolbar'] /a")
	public List<WebElement> buttonsWidjet;

	@FindBy(xpath = "//input[@class='so-row-field']")
	public WebElement numOfRowsWidget;

	@FindBy(xpath = "//select[@name='ratio']")
	public WebElement selectRatioWidjet;

	@FindBy(xpath = "//select[@name='ratio_direction']")
	public WebElement selectRatioDirectionWidjet;

	@FindBy(xpath = "//input[@class='button-primary so-insert']")
	public WebElement insert;

	@FindBy(xpath = "//h3[@class='so-title']")
	public WebElement title_AddNewWidjet;

	@FindBy(xpath = "//div[@class='widget-type-wrapper']/h3")
	public List<WebElement> widjets;

	@FindBy(xpath = "//div[@class='so-dropdown-links-wrapper']//a")
	public List<WebElement> links_editWidjet;

	@FindBy(xpath = "//div[@class='cell-wrapper widgets-container ui-sortable']")
	public WebElement container_Widjet;

	@FindBy(xpath = "//div[@class='cell-wrapper widgets-container ui-sortable']")
	public List<WebElement> container_WidjetS;

	@FindBy(xpath = "//li[contains (text(),'Edit Widget')]")
	public WebElement edit_Widjet;

	@FindBy(xpath = "//div[@class='so-search-wrapper']/input")
	public WebElement input_Widjet_Name;

	@FindBy(xpath = "(//ul[@class='so-items'])[1]")
	public WebElement find_Widjet_ByName;

	@FindBy(xpath = "//button[@class='button select-media not-selected']")
	public WebElement button_AddImage;

	@FindBy(xpath = "(//input[@value='Done'])[1]")
	public WebElement button_Done;
	
	@FindBy(xpath = "//html/body/div[9]/div/div[3]/div[2]/input")
	public WebElement button_Done_forText;

	@FindBy(xpath = "//button[contains(text(),'Add to Widget')]")
	public WebElement button_Add_ToWidjet;

	@FindBy(xpath = "//button[@class='button select-media not-selected']")
	public WebElement addImageGallery;

	@FindBy(xpath = "//div[@class='media-frame-title']/h1")
	public WebElement title_CreateGAllery;

	@FindBy(id = "media-search-input")
	public WebElement input_SearchMedia;

	@FindBy(xpath = "//ul[@class='attachments ui-sortable ui-sortable-disabled']/li")
	public List<WebElement> imagesForGAllery;

	@FindBy(xpath = "//button[@class='button media-button button-primary button-large media-button-gallery']")
	public WebElement button_CreateNewGAllery;

	@FindBy(xpath = "//button[@class='button media-button button-large media-button-reverse']")
	public WebElement button_RecerseOrderGallery;

	@FindBy(xpath = "//button[@class='button media-button button-primary button-large media-button-insert']")
	public WebElement button_InsertGallery;

	@FindBy(xpath = "(//input[@class='button-primary so-close'])[2]")
	public WebElement button_DoneGallery;

	@FindBy(id = "title")
	public WebElement input_Title;

	@FindBy(id = "save-post")
	public WebElement button_SaveDraft;

	@FindBy(id = "post-preview")
	public WebElement button_PostPreview;

	@FindBy(xpath = "//h1[@class='post-title']")
	public WebElement wwwTitle;
	
	@FindBy(xpath = "//h1[@class='post-title']")
	public WebElement new_Page_Name;
	
	
	
	@FindBy(xpath = "//div[@class='content section-inner']//img")
	public WebElement image_onNewPage;
	
}
