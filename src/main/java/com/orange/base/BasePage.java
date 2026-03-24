package com.orange.base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	public BasePage() {
		this.driver=DriverManager.getDriver();
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		this.js=(JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	public abstract boolean isAt();
	
//Scroll to specific element
public void scrollToElement(WebElement element)	{
	wait.until(ExpectedConditions.visibilityOf(element));
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
}
//Scroll to bottom
public void scrollToBottom() {
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
}	
}