package tests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTestChrome {

    private WebDriver driver;
    private String url;

    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/maven/chromedriver");
    }

    @BeforeEach
    public void setUp() throws IOException {
        // Load properties from config file
        Properties props = new Properties();
        FileInputStream input = new FileInputStream("src/test/resources/login.properties");
        props.load(input);
        url = props.getProperty("url");

        // Create Chrome driver
        driver = new ChromeDriver();
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
