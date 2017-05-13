
package com.selenium.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.PostCommentPage;
import pages.WordPressLogin;
import utils.BrowserFactory;
import utils.SeleniumUtil;


/**
 * @author subbu
 *
 */
public class PostCommentsTest {
	

	
	@Test
	public void postingComments()throws Exception{
         WebDriver driver = BrowserFactory.launchBrowser("chrome","http://demosite.center/wordpress/wp-login.php");
		//SeleniumUtil.takeScreenShot(driver, "wordPressHomePage");
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		WordPressLogin loginPage =PageFactory.initElements(driver,WordPressLogin.class);
		loginPage.login("admin","demo123");
		Thread.sleep(5000);
		//SeleniumUtil.takeScreenShot(driver, "wordPressLoggedInPage");
		PostCommentPage postPage = PageFactory.initElements(driver, PostCommentPage.class);
		postPage.postComment();
		//postPage.udpateCommentOnSamePage();
		Thread.sleep(3000);
		loginPage.logOut();
		Thread.sleep(3000);
		SeleniumUtil.takeScreenShot(driver,"wordPressLogOutPage","./screenshots/wordpress/newpost");
		BrowserFactory.tearDownBrowser(driver);
	}

}
