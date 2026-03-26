package com.orange.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

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
		Assert.assertTrue(timePage.isAt(),"TimePage is not loaded");
	}
	
	
	

}
