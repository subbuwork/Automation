package com.selenium.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.WordPressLogin;
import utils.BrowserFactory;


public class VerifyWordPressLoginTest {


	@Test
	public void verifyLogin()throws Exception{
		WebDriver driver = BrowserFactory.launchBrowser("chrome","http://demosite.center/wordpress/wp-login.php");
		
		WordPressLogin login =PageFactory.initElements(driver, WordPressLogin.class);
		login.login("admin","demo123");
		
		//login.postComment();
		
		Thread.sleep(8000);
		
		login.logOut();
		
		//CreateDriver.tearDownBrowser(driver);
		
		
	}
	
	
}
