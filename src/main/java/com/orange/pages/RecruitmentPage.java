package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orange.base.BasePage;

public class RecruitmentPage extends BasePage {
	
	@FindBy(xpath="(//a[@class='oxd-topbar-body-nav-tab-item'])[1]")
	private WebElement candidates;
	
	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.elementToBeClickable(candidates));
		return candidates.isDisplayed();
	}

}
