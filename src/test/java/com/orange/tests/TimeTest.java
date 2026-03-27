package com.orange.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orange.base.BaseTest;
import com.orange.pages.DashboardPage;
import com.orange.pages.LoginPage;
import com.orange.pages.TimePage;

public class TimeTest extends BaseTest{
	
	private TimePage timePage;
	
	@BeforeMethod
	public void setUpTimePage(){
		LoginPage loginPage = new LoginPage();
		DashboardPage dashboardPage = loginPage.login("Admin","admin123");
		//Verify dashboardpage is displayed
		Assert.assertTrue(dashboardPage.isAt(), "Dashboard page not loaded");
		timePage = dashboardPage.clickTimeButton();	
		
	}
	@Test(description="Verify timepage loaded successfully")
	public void verifyTimePageLoaded() {
		Assert.assertTrue(timePage.isAt(),"TimePage is not loaded");
	}
	@Test(description="Verify all the UI elements are shown in page")
	public void verifyAllElementsPresent() {
		timePage.verifyDashboardElements();	
	}
	
	

}
