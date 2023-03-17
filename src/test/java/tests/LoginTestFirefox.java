package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTestFirefox {

    private WebDriver driver;
    private String url;

    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\viktor.chmel\\.m2\\repository\\webdriver\\gecko\\geckodriver.exe");
        System.setProperty("webdriver.firefox.marionette", "C:\\Users\\viktor.chmel\\.m2\\repository\\webdriver\\gecko\\geckodriver.exe");
    }

    @BeforeEach
    public void setUp() throws IOException {
        // Load properties from config file
        Properties props = new Properties();
        FileInputStream input = new FileInputStream("src/test/resources/login.properties");
        props.load(input);
        url = props.getProperty("url");

        // Create Firefox driver
        driver = new FirefoxDriver();
    }

    @Test
    public void testLogin() {

        driver.get(url);

        String expectedUrl = "http://176.36.27.131:8180/#/login";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @AfterEach
    public void tearDown() {
        // Close browser
        driver.quit();
    }
}
