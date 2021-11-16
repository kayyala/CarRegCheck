package stefDef;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class Hooks {
    public static  WebDriver driver;

    @Before
    public void openBrowser() throws IOException {
        System.out.println("opening browser");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cartaxcheck.co.uk/");
        driver.manage().window().maximize();
    }

    @After
    public  void closeBrowser()
    {
       driver.close();
    }
}
