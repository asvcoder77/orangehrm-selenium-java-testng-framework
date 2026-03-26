package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orange.base.BasePage;

public class DashboardPage extends BasePage{
	
	@FindBy(css="button[size='large']")
	private WebElement upgradebutton;
	
	@FindBy(css="a[href='http://www.orangehrm.com']")
	private WebElement bottemlink;
	
	@FindBy(css="button.oxd-icon-button--solid-main")
	private WebElement time;
	

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.elementToBeClickable(upgradebutton));
		return this.upgradebutton.isDisplayed();
	}
	
	public boolean isBottemLinkVisible() {
		return wait.until(ExpectedConditions.visibilityOf(bottemlink)).isDisplayed();
		
	}
	public TimePage clickTimeButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(time)).click();
		return new TimePage();
		
	}

		
		
	}


