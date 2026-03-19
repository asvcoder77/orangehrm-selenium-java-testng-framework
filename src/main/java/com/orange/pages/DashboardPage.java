package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orange.base.BasePage;

public class DashboardPage extends BasePage{
	
	@FindBy(css="button[size='largee']")
	private WebElement upgradebutton;
	

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(upgradebutton));
		return this.upgradebutton.isDisplayed();
	}

}
