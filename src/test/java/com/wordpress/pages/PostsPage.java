package com.wordpress.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.utilities.Driver;

public class PostsPage {
	private WebDriver driver;
	public PostsPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='wp-heading-inline']/../a")
	public WebElement addNewButton;
	
	public WebElement post_title;
	
	@FindBy(xpath="//textarea[@id='content']")
	public WebElement bodyOfPost;
	
	@FindBy(xpath="//div[@id='category-all']/ul/li/label/input")
	public List<WebElement> categoryAll;
	
	@FindBy(xpath="//div[@id='category-all']/ul/li/label/input/..")
	public List<WebElement> categoryAlllabels;
	
	@FindBy(xpath="//span[.='Featured Image']")
	public WebElement featureImageTabTitle;
	
	@FindBy(linkText="Set featured image")
	public WebElement setFeatureImageLink;
	
	@FindBy(linkText="Media Library")
	public WebElement mediaLibraryTab;
	
	@FindBy(xpath="//ul[@class='attachments ui-sortable ui-sortable-disabled']/li")
	public List<WebElement> allPicturesMediaLibrary;
	
	@FindBy(xpath="//button[.='Set featured image']")
	public WebElement setFeatureImageButton;
	
	@FindBy(xpath="//input[@class='button button-primary button-large']")
	public WebElement publishButton;
	
	@FindBy(xpath="//span[@id='editable-post-name']")
	public WebElement postLink;
	
	@FindBy(xpath="//h1")
	public WebElement titleOfCreatedPost;
	
	@FindBy(xpath="//div[@class='post-content']/p")
	public WebElement contentOfCreatedPost;

	@FindBy(xpath="//p[@class='categories']/a")
	public WebElement categoryOfCreatedPost;
	
	
	public void chooseBlindspot(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("var evt = document.createEvent('MouseEvents');"
				+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
				+ "arguments[0].dispatchEvent(evt);", element);
	}
	
}
