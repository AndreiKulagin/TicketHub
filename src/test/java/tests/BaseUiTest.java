package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseUiTest {

    protected WebDriver driver;
    protected String url;
    protected String username;
    protected String password;
    protected WebDriverWait wait;

    @BeforeAll
    public static void setUpClass() {

        System.setProperty("webdriver.chrome.driver", "/usr/local/maven/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
    }

    @BeforeEach
    public void setUp() throws IOException {

        Properties props = new Properties();
        FileInputStream input = new FileInputStream("src/test/resources/login.properties");
        props.load(input);

        url = props.getProperty("url");
        username = props.getProperty("username");
        password = props.getProperty("password");

        driver = new ChromeDriver();

        Duration duration = Duration.ofSeconds(30);
        wait = new WebDriverWait(driver, duration);
    }

    @AfterEach
    public void tearDown() {

        driver.quit();
    }
}