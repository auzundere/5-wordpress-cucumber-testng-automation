package com.wordpress.step_defs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.wordpress.utilities.ConfigurationReader;
import com.wordpress.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	@Before
	public void beforeScenario(Scenario scenario) {
		WebDriver driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		//System.out.println("Before the Scenario started");
	}

	@After
	public void afterScenario(Scenario scenario) {
		//System.out.println("After the Scenario ended");
		//taking a screenshot
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) 
			Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			//adding the screenshot to the report
			scenario.embed(screenshot, "image/png");
		}
		//Driver.closeDriver();
	}
}