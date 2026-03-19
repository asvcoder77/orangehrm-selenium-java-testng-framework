package com.orange.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	public BasePage() {
		this.driver=DriverManager.getDriver();
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		PageFactory.initElements(driver, this);
	}
	public abstract boolean isAt();
		
}