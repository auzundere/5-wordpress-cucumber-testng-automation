package com.wordpress.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin= {
				"html:target/cucumber_report",
				"json:target/cucumber.json"		
				},
		tags="@Posts",	
		features = "src/test/resources/com/wordpress/features/", 
		glue = "com/wordpress/step_defs",
		dryRun=false
)
public class CukesRunner extends AbstractTestNGCucumberTests {

}