package com.orange.base;



import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.orange.listeners.TestListeners;
import com.orange.utils.Config;
import com.orange.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(TestListeners.class)
public class BaseTest {

	private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
	
	@BeforeSuite
	public void setUpConfig() {
		// Loads configuration from the properties file and system properties.
		// This only initializes settings required for the framework.
		// It does NOT start the automation or browser.
		Config.initialize();		
		
	}
	@BeforeMethod
	public void setDriver(ITestContext ctx) throws MalformedURLException, URISyntaxException {
		if (Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED))) {
            DriverManager.setDriver(getRemoteDriver());
        } else {
            DriverManager.setDriver(getLocalDriver());
        }
		WebDriver driver = DriverManager.getDriver();
		driver.manage().window().maximize();
		driver.get(Config.get(Constants.ORANGE_HRM_URL));

        ctx.setAttribute(Constants.DRIVER, DriverManager.getDriver());		
	}
	private RemoteWebDriver getRemoteDriver() throws MalformedURLException, URISyntaxException {
		Capabilities capabilities=new ChromeOptions();
		if (Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
            capabilities = new FirefoxOptions();
        }
		String url = String.format(
                Config.get(Constants.GRID_URL_FORMAT),
                Config.get(Constants.GRID_HUB_HOST)
        );
		log.info("Grid URL: {}", url);
        return new RemoteWebDriver(new URI(url).toURL(), capabilities);
	}
	private ChromeDriver getLocalDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
	@AfterMethod
	public void quitDriver() {
		DriverManager.getDriver().quit();
		DriverManager.unload();
	}
}
	
