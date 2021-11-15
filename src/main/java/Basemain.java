
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Basemain {
    static WebDriver driver;

//   @BeforeClass
//    public void openBrowser() throws IOException {
//        System.out.println("opening browser");
//        Properties prop = new Properties();
//        FileInputStream fileInputStreamfs = new FileInputStream("C:\\Users\\sudha\\IdeaProjects\\CarValidation\\src\\test\\resources\\config.properties");
//        prop.load(fileInputStreamfs);
//        String url = prop.getProperty("url");
//        String browser = prop.getProperty("browser");
//        System.out.print("browser: " + browser);
//        switch (browser) {
//            case "chrome":
//                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Browsers\\chromedriver.exe");
//                driver = new ChromeDriver();
//                break;
//            case "ie":
//                System.setProperty("webdriver.ie.driver", "C:\\Users\\Browsers\\IEDriverServer.exe");
//               // driver = (new InternetExplorerDriver());
//                break;
//            default:
//                driver = (new ChromeDriver());
//                break;
//        }
//        driver.get(url);
//    }
    public void closeBrowser()

    {
        driver.quit();
    }
}
