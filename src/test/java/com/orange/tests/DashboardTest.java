package com.orange.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orange.base.BaseTest;
import com.orange.pages.DashboardPage;
import com.orange.pages.LoginPage;

public class DashboardTest extends BaseTest {
	
	@Test
	public void dashboardTest() {
		
		//Login function
		LoginPage loginPage = new LoginPage();
		DashboardPage dashboardPage=loginPage.login("Admin", "admin123");
		
		//Verify dashboard page
		Assert.assertTrue(dashboardPage.isAt(),"Dashboard page not loaded");
		
		//Scroll till bottemlink
		dashboardPage.scrollToBottom();
	}
	

}
