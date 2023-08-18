package step_definitions;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks{
    public static WebDriver driver;

    @Before
    public void openBrowser() throws MalformedURLException {
    	System.out.println("Called openBrowser");
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\RBK\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	driver =new ChromeDriver();
    	driver.manage().deleteAllCookies();
    }

 
    
    @After
    public void embedScreenshot(Scenario scenario) {
       
        if (scenario.isFailed()) {
        try {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "blah.png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        
        }
        driver.quit();
        
    }
    
}