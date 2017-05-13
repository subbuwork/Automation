package com.selenium.testcases;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by subbu on 5/12/2017.
 */
public class InterviewQuestions {
    public void interviewQuestions()throws  Exception{
        WebDriver driver = new FirefoxDriver();

        System.out.println("........wait conditions......");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));
        //wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath(""))));

        System.out.println(".......Handling multiple windows....");
        String parentWindow =driver.getWindowHandle();
        Set<String> childWindows = driver.getWindowHandles();


        System.out.println("----Alert questions-----");
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        Alert alertText = driver.switchTo().alert();
        alertText.getText();

        System.out.println(" iFrame questions");
        driver.switchTo().frame(1);
        driver.switchTo().frame("name");
        driver.switchTo().frame(driver.findElement(By.xpath("")));

        System.out.println("----Window handles----");
        String paretnWindowID =driver.getWindowHandle();
        Set<String> childWindowsIDs = driver.getWindowHandles();
        Iterator<String> childWindowID = childWindows.iterator();
        String fWindow = childWindowID.next();
        driver.switchTo().window("fWindow"); // switching to child window
        driver.switchTo().defaultContent(); // switching from child window to parent window

        System.out.println("....Wait condition...");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); // Implicit wait
        WebDriverWait wa = new WebDriverWait(driver,10);
        wa.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));
        wa.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        wa.until(ExpectedConditions.alertIsPresent());

        System.out.println(".......Mouse over operations.....");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(""))).build().perform();

        System.out.println("......Drop down operations.....");
        Select select = new Select(driver.findElement(By.xpath("")));
        select.selectByIndex(1);
        select.selectByValue("test");
        select.selectByVisibleText("Test");
        List<WebElement> webElList=select.getOptions();

        System.out.println(".....Drag and drop.....");
        Actions actions1 = new Actions(driver);
        actions1.dragAndDrop(driver.findElement(By.xpath("")),driver.findElement(By.xpath("")));

        System.out.println(".....Screen shot operations....");
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File screenshotFile =screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile,new File("C:\\screenshots\\login\\login.jpeg"));

        System.out.println(".....Window coordinates....");
        driver.manage().window().getPosition().getX();
        driver.manage().window().getPosition().getY();
        Point position =driver.manage().window().getPosition();
        position.getX();
        position.getX();

        System.out.println(".....Navigation.....");
        driver.navigate().forward();
        driver.navigate().back();

        System.out.println(".....Getting page url....");
        driver.getCurrentUrl();

        System.out.println("Getting page title....");
        driver.getTitle();
        System.out.println("How to count similar variables in the present UI...");
        //Integer numOfele = driver.findElement(By.xpath("")).getSize();
        System.out.println("How find following siblings, preceding sibling, child");

        driver.findElement(By.xpath("//input[@id='123']/following-sibling::td[1]"));
        driver.findElement(By.xpath("//div[@class='xyx']/Preceding-sibling::td[3]"));
        driver.findElement(By.xpath("//div[@id='345']/child::td[34]"));

        System.out.println("How to get particular element");
        driver.findElement(By.xpath("//id[@class='xyz']/td[1]"));

        System.out.println(".....Check box operations.....");
        driver.findElement(By.xpath("")).isSelected();
        driver.findElement(By.xpath("")).isEnabled();
        driver.findElement(By.xpath("")).isDisplayed();

        System.out.println("How to execute javascript in selenium");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("");

        System.out.println("how to maximize window");
        driver.manage().window().maximize();
        driver.get("");//Get url
    }
}
