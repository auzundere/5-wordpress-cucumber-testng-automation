package com.wordpress.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.utilities.BrowserUtils;
import com.wordpress.utilities.Driver;

public class Media {
	private WebDriver driver;

	public Media() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='wp-menu-image dashicons-before dashicons-admin-media']") // li[@id='wp-admin-bar-new-media']
	public WebElement media;

	@FindBy(xpath = "//a[@class='wp-first-item current']")
	public WebElement library;

	@FindBy(xpath = "//a[@href='/wordpress/wp-admin/upload.php?mode=grid']")
	public WebElement switchGridButton;// it never changes...

	@FindBy(xpath = "//th[@id='title']")
	public WebElement fileUpDownArrow;

	@FindBy(xpath = "//ul[@class='attachments ui-sortable ui-sortable-disabled']/li")
	public List<WebElement> allPicturesMediaLibrary;

	@FindBy(xpath = "")
	public WebElement imgNameVerfy;

	@FindBy(xpath = "//div[.='Media']")
	public WebElement mediaLink;

	@FindBy(xpath = "//a[@class='page-title-action aria-button-if-js']")
	public WebElement addNew;

	@FindBy(id = "__wp-uploader-id-1")
	public WebElement selectFilesButton;

	@FindBy(xpath = "//a[@href='/wordpress/wp-admin/upload.php?mode=grid']")
	public WebElement rt;

	@FindBy(linkText = "")
	public WebElement asd;

	public void uploadMedia(String fileName) throws AWTException {
		//this 3 lines take my file name from start to end and copy to mac clipboard
		File file = new File(fileName);
		StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		Robot robot = new Robot();
		//When the dialog window opens, the selenium looses the control. to take the control bac
		// I am hitting Command + TAB keys. It brings the control to selenium.
		
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(500);
		
		//After that I hit Command+Shift+G together to open Go To Folder,
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);
		//At this point I am pasting what I have in my clipboard. 
		//That is the value of fileName argument "/Users/handanmelis/Desktop/scd.png"
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);
		//BrowserUtils.waitFor(4);
		//At this point 2 time I am hitting enter to close all dialogs.
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
