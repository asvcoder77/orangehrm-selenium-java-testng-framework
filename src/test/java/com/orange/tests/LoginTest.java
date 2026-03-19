package com.orange.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orange.base.BaseTest;
import com.orange.pages.DashboardPage;
import com.orange.pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void loginTest() {
		LoginPage loginPage=new LoginPage();
		//verify login page
		Assert.assertTrue(loginPage.isAt(),"Not on loginpage");
		//perform login
		DashboardPage dashboardPage=loginPage.login("Admin", "admin123");
		//verify dashboardpage
		Assert.assertTrue(dashboardPage.isAt(),"Not on dashboardpage");
	}

}
