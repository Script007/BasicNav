package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationTests {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.quit();

        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver1 = new FirefoxDriver();
        driver.get("https://google.com");
        driver.quit();

        WebDriverManager.edgedriver().setup();
        EdgeDriver driver2 = new EdgeDriver();
        driver.get("https://google.com");
        driver.quit();
    }
}
