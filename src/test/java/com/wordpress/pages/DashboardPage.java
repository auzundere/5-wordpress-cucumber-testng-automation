package com.wordpress.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.utilities.Driver;

public class DashboardPage {
 private WebDriver driver;
 
 public DashboardPage() {
	 this.driver=Driver.getDriver();
	 PageFactory.initElements(driver, this);
 }
 
 @FindBy(xpath="//div[@class='wrap']/h1")
 public WebElement dashboardText;
 
 //not() function find the elements opposite of the filter 
 //in which we found elements with no "Welcome to WordPress!" text in h2 category
 @FindBy(xpath="//h2[not((.='Welcome to WordPress!'))]")
 public List<WebElement> headersOfDashboard;

 @FindBy(xpath="//div[@class='wp-menu-name']")
 public List<WebElement> first10ElementsofLeftMenu;
 
 @FindBy(linkText="Home")
 public WebElement homeLink;
 
 @FindBy(linkText="Updates ")
 public WebElement updateLink;
 
 @FindBy(id="collapse-button")
 public WebElement collapseMenuLink;

 @FindBy(id="wp-admin-bar-wp-logo")
 public WebElement wMenu;
 
 @FindBy(xpath="//li[@id='wp-admin-bar-wp-logo']//span[@class='screen-reader-text']")
 public WebElement aboutWordpressLink;

 @FindBy(xpath="//li[@id='wp-admin-bar-wp-logo']//span[@class='screen-reader-text']")
 public WebElement wordpressDotOrgLink;
 
 @FindBy(xpath="//ul[@id='wp-admin-bar-wp-logo-external']/li/a")
 public List<WebElement> last4ElementsOfWSubMenu;
 
 @FindBy(xpath="//li[@id='wp-admin-bar-site-name']/a")
 public WebElement BlogLink;
 
 @FindBy(xpath="//li[@id='wp-admin-bar-view-site']/a")
 public WebElement visitSiteLink;

 @FindBy(id="wp-admin-bar-comments")
 public WebElement topCommentsLink;
 
 @FindBy(xpath="//li[@id='wp-admin-bar-new-content']/a")
 public WebElement plusNewLink;
 
 @FindBy(xpath="//ul[@id='wp-admin-bar-new-content-default']/li/a")
 public List<WebElement> plusNewMenuElements;
 
 @FindBy(xpath="//a[contains(text(),'Howdy, ')]")
 public WebElement howdyMenuLink;
 
 @FindBy(xpath="//ul[@id='wp-admin-bar-user-actions']/li/a")
 public List<WebElement> howdyMenuElements;
 
}
