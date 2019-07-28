package com.frankbahar.cucumber.parallel.google;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSteps {
	private WebDriver driver;
	public static ThreadLocal<WebDriver> dr=new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	public static void setWebDriver(WebDriver driver) {
		dr.set(driver);
	}
	
	protected void startWebDriver(String browser) {
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/com/frankbahar/cucumber/parallel/google/executables/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/com/frankbahar/cucumber/parallel/google/executables/chromedriver.exe");
			driver = new ChromeDriver();
		}
		setWebDriver(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	protected void navigate(String url) {
		getDriver().navigate().to(url);
		
	}
	
	protected void stopWebDriver() {
		getDriver().quit();
	}
}
