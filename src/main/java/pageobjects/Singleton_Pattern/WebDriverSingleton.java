package pageobjects.Singleton_Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriver instance;

    private WebDriverSingleton() {}

    public static WebDriver getInstance() {
        if (instance == null) {
            System.setProperty("webdriver.chrome.driver", "/.m2/repository/webdriver/chrome/");
            instance = new ChromeDriver();
        }
        return instance;
    }

    WebDriver driver = WebDriverSingleton.getInstance();
}