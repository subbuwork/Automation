package com.selenium.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.UpdatePostPage;
import pages.WordPressLogin;
import utils.BrowserFactory;
import utils.SeleniumUtil;


/**
 * @author subbu
 *
 */
public class UpdatePostTest {
	private static final String screenshots_location="./screenshots/wordperss/updatepost";
	@Test
	public void updatePost() throws Exception{

		WebDriver driver = BrowserFactory.launchBrowser("chrome","http://demosite.center/wordpress/wp-login.php");
	//SeleniumUtil.takeScreenShot(driver, "wordPressHomePage");
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	WordPressLogin loginPage =PageFactory.initElements(driver,WordPressLogin.class);
	loginPage.login("admin","demo123");
	SeleniumUtil.takeScreenShot(driver, "dashBorad",screenshots_location);
	Thread.sleep(5000);
	UpdatePostPage updatePostPage = PageFactory.initElements(driver,UpdatePostPage.class);
	updatePostPage.updatePost("Update Test Case","Update test case demo..");
	
	
	}

}
