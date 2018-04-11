package com.wordpress.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.utilities.Driver;

public class CategoriesPage {
	private WebDriver driver;

	public CategoriesPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="show-settings-link")
	public WebElement showSettingsLink;
	
	public WebElement edit_category_per_page;
	
	@FindBy(id="screen-options-apply")
	public WebElement screenOptionsApply;
	
	
	@FindBy(xpath="//table[@class='wp-list-table widefat fixed striped tags']/tbody/tr/th/input")
	public List<WebElement> categoryCheckboxes;
	
	@FindBy(xpath="//table[@class='wp-list-table widefat fixed striped tags']/tbody/tr/td/strong/a")
	public List<WebElement> categoryNames;
	
	@FindBy(xpath="//table[@class='wp-list-table widefat fixed striped tags']/tbody/tr/td[@data-colname='Slug']")
	public List<WebElement> categorySlugs;
	
	@FindBy(xpath="//div[.='Posts']")
	public WebElement postsMenu;
	
	@FindBy(linkText="Categories")
	public WebElement categoriesMenu;
	
	@FindBy(id="tag-name")
	public WebElement categoryName;
	
	@FindBy(id="tag-slug")
	public WebElement categorySlug;
	
	@FindBy(id="submit")
	public WebElement addNewCategoryButton;
	
	@FindBy(id="bulk-action-selector-top")
	public WebElement bulkActionDropDown;
	
	@FindBy(id="doaction")
	public WebElement applyButton;
	
	public void refreshThePage() {
		driver.navigate().refresh();
	}
	
}
