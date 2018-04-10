package com.wordpress.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//body[@id='tinymce']")
	public WebElement bodyOfPost;
	
	public WebElement content;
	
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
	
	@FindBy(xpath="//div[@class='tablenav top']//span[@class='total-pages']")
	public List<WebElement> totalPagesOfPosts;
	
	@FindBy(id="current-page-selector")
	public WebElement pageSelectorTextOfPostsPage;
	
	@FindBy(xpath="//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr/th/input")
	public List<WebElement> checkboxesofPageOfPosts;
	
	@FindBy(xpath="//select[@id='bulk-action-selector-top']")
	public WebElement bulkActionSelectorDropDown;
	
	@FindBy(id="doaction")
	public WebElement applyButton;
	
	@FindBy(xpath="//div[@id='message']/p")
	public WebElement deletedPostConfirmationText;//9 posts moved to the Trash.
	
	@FindBy(xpath="//span[@class='displaying-num']")
	public WebElement totalNumberOfPostsText;//24 items
	
	public void switchIframe() {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='content_ifr']"));
		driver.switchTo().frame(iframe);
	}
	
	public void switchToParent() {
		driver.switchTo().parentFrame();
	}
	
	public void clickElements(int totalSize, int numberofElementSelect, List<WebElement> element,
			int startIndex) {
		Random rand = new Random();
		List<Integer> num = new ArrayList<>();
		for (int i = 0; i < totalSize; i++)
			num.add(i);
		for (int i = startIndex; i < numberofElementSelect; i++) {
			int index = rand.nextInt(num.size() - 1);
			int r = num.get(index) + 1;
			chooseBlindspot(element.get(r));
			num.remove(index);
		}
	}
	
	public void chooseBlindspot(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("var evt = document.createEvent('MouseEvents');"
				+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
				+ "arguments[0].dispatchEvent(evt);", element);
	}
	
}
