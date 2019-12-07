package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static void getDriver (String driverName) {

        if (System.getProperty("os.name") == "safari") {
            return;
        }
        else if (driverName == "chrome") {
            WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://google.com");
        }
        else if (driverName == "firefox") {
            WebDriverManager.firefoxdriver().setup();
            FirefoxDriver driver = new FirefoxDriver();
        }
        else if (driverName == "edge") {
            WebDriverManager.edgedriver().setup();
            EdgeDriver driver = new EdgeDriver();
        }
    }

}
