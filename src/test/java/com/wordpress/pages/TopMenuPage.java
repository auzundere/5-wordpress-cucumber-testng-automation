package com.wordpress.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.utilities.Driver;

public class TopMenuPage {
	
	private WebDriver driver;
	public TopMenuPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='profile-page']/h1")
	public WebElement textProfile;
	
	public WebElement admin_color_sunrise;
	
	public WebElement admin_color_blue;
	
	@FindBy(xpath="//fieldset[@id='color-picker']")   //iterate to select color
	public List<WebElement> colorSheme;
	
	public WebElement comment_shortcuts;
	
	@FindBy(id="admin_bar_front")
	public WebElement toolbar;
	
	public WebElement first_name;
	
	public WebElement last_name;
	
	public WebElement nickname;
	
	public WebElement display_name;
	
	public WebElement description;
	
	public WebElement submit;
	
	@FindBy(id="message")
	public WebElement profileUpdated;
	
	@FindBy(xpath="//a[@href='users.php']")
	public WebElement users;
	
	@FindBy(xpath="//tbody[@id='the-list']/tr[@id='user-3']/td[2]")
	public WebElement verifyName;
	
	@FindBy(id="user-search-input")
	public WebElement userSearchInput;
	
	@FindBy(id="search-submit")
	public WebElement searchUsersButton;
	
	@FindBy(xpath="//div[@class='header section-inner']/h1")
	public WebElement header;
	
	@FindBy(id="adminbar-search")
	public WebElement search;
	
	@FindBy(xpath="//div[@class='page-title']/p")
	public WebElement textSearchResult;
	
	@FindBy(xpath="//div[@class='page-title']/h4")
	public WebElement Searchedtext;
}
