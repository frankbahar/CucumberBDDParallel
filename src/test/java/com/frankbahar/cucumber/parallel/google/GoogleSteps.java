package com.frankbahar.cucumber.parallel.google;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;
import com.frankbahar.cucumber.parallel.extent.ExtentManager;
import com.frankbahar.cucumber.parallel.extent.ExtentTestManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSteps extends BaseSteps{
	protected Scenario scenario;
	static String scenarioName;
	static int x=0;
	
	@Before
	public void before(Scenario scenario) {
		x=x+1;
		this.scenario=scenario;
		this.scenarioName=scenario.getName();
		ExtentTestManager.startTest("Scenario No : " + x + " : " +scenario.getName());
		ExtentTestManager.getTest().log(Status.INFO, "Scenario started : - " + scenario.getName());
	}
	
	@After
	public void after(Scenario scenario) {
		if(scenario.isFailed()) {
			ExtentTestManager.logFail("Scenario Failed");
			ExtentTestManager.addScreenShotsOnFailure();
		}else {
			ExtentTestManager.logPass("Scenario Passed");
		}
		ExtentManager.getReporter().flush();
		stopWebDriver();
	}

	@Given("^launch browser '(.*?)'$")
	public void launch_browser_firefox(String browserName) {
		startWebDriver(browserName);
		ExtentTestManager.logInfo("Launching Browser : " + browserName);
	}

	@When("^user navigates to '(.*?)'$")
	public void user_navigates_to_https_www_google_com(String url) {
		ExtentTestManager.logInfo("Navigating to the URL : " + url);
		navigate(url);
	}

	@Then("^user enters search term '(.*?)'$")
	public void user_enters_search_term_Cucumber(String searchText) {
		ExtentTestManager.logInfo("Entering the value in Search box " + searchText);
		getDriver().findElement(By.name("q")).sendKeys(searchText);
		
	}

	@Then("^clicks on search button$")
	public void clicks_on_search_button() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentTestManager.logInfo("Clicking Search button");
		getDriver().findElement(By.name("btnK")).click();
	}
}
