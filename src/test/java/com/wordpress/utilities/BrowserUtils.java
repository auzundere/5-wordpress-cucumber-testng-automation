package com.wordpress.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

	
	public static String generateText() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public static void hover(WebElement element) {
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(element).perform();
	}

	/**
	 * * return a list of string from a list of elements * ignores any element with
	 * no text * @param list * @return
	 */
	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elementTexts = new ArrayList<>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elementTexts.add(el.getText());
			}
		}
		return elementTexts;
	}

	public static List<String> getElementsText(By locator) {

		List<WebElement> list = Driver.getDriver().findElements(locator);
		List<String> links = new ArrayList<>();
		for (WebElement webElement : list) {
			if (!webElement.getText().isEmpty()) {
				links.add(webElement.getText());
			}
		}
		return links;
	}

	public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement waitForVisibility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForClickablility(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForClickablility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// public static WebElement fluentWait(final WebElement webElement, int
	// timeinsec) {
	// FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
	// .withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(timeinsec,
	// TimeUnit.SECONDS)
	// .ignoring(NoSuchElementException.class);
	// WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	// public WebElement apply(WebDriver driver) {
	// return webElement;
	// }
	// });
	// return element;
	// }

	public static void waitForPageToLoad(long timeOutInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			System.out.println("Waiting for page to load...");
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println(
					"Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
		}
	}

	public static void waitFor(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void switchToWindow(String targetTitle) {
		String origin = Driver.getDriver().getWindowHandle();
		for (String handle : Driver.getDriver().getWindowHandles()) {
			Driver.getDriver().switchTo().window(handle);
			if (Driver.getDriver().getTitle().equals(targetTitle)) {
				return;
			}
		}
		Driver.getDriver().switchTo().window(origin);
	}

}
