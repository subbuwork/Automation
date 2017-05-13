package pages;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.SeleniumUtil;

/**
 * Created by subbu on 5/13/2017.
 */
public class RedBusHomePage {
    private  static  final String SCREEN_SHOT_LOCATION = "./screenshots/redbus";
    private WebDriver webDriver;
    public RedBusHomePage(WebDriver driver){
        this.webDriver = driver;
    }
    public void launchRedBusHomePage(){
        System.out.println("......Loading home page....");
        SeleniumUtil.takeScreenShot(webDriver,"RedBusHomePage",SCREEN_SHOT_LOCATION);

    }
}
