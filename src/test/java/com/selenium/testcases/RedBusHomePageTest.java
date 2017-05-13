package com.selenium.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pages.RedBusHomePage;
import utils.BrowserFactory;

/**
 * Created by subbu on 5/13/2017.
 */
public class RedBusHomePageTest {
    @Test
    public void loadingRedBusHomePage(){
        WebDriver driver = BrowserFactory.launchBrowser("firefox","https://www.redbus.in/");
        RedBusHomePage homePage = new RedBusHomePage(driver);
        homePage.launchRedBusHomePage();
    }
}
