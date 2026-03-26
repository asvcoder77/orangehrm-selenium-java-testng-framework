package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orange.base.BasePage;

public class TimePage extends BasePage {
	
	@FindBy(xpath="(//span[@class=\"oxd-topbar-body-nav-tab-item\"])[2]")
	private WebElement attendance;

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.elementToBeClickable(attendance));
		return this.attendance.isDisplayed();	
		
	}

}
