package tests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTestChrome {

    private WebDriver driver;
    private String url;
    private String username;
    private String password;

    @BeforeAll
    public static void setUpClass() {
        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", "/Users/andreikulagin/maven/bin/chromedriver");
    }

    @BeforeEach
    public void setUp() throws IOException {
        // Load properties from config file
        Properties props = new Properties();
        FileInputStream input = new FileInputStream("src/test/resources/login.properties");
        props.load(input);
        url = props.getProperty("url");
        username = props.getProperty("username");
        password = props.getProperty("password");

        // Create Chrome driver
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        // Go to login page
        driver.get(url);

        // Enter username and password
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        // Click login button
        driver.findElement(By.id("login-signin")).click();

        // Check that user is redirected to the dashboard
        String expectedUrl = "http://176.36.27.131:8180/#/tickets?page=0&size=10&sort=&stage=&category=-1";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @AfterEach
    public void tearDown() {
        // Close browser
        driver.quit();
    }
}
