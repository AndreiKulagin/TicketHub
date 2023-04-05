package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

public class BaseUiTest {

    protected WebDriver driver;
    protected String url;
    protected String username;
    protected String password;
    protected WebDriverWait wait;
    private static final String OPERATION_SYSTEM = System.getProperty("os.name");

    @BeforeAll
    public static void setUpClass() {
        String driverDir = System.getProperty("user.home").replaceAll("\\\\", "/") +
                "/.m2/repository/webdriver/chrome/";
        if(OPERATION_SYSTEM.toLowerCase(Locale.ROOT).contains("windows")) {
            System.setProperty("webdriver.chrome.driver", driverDir + "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", driverDir + "chromedriver");
        }
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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        Duration duration = Duration.ofSeconds(30);
        wait = new WebDriverWait(driver, duration);
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-signin")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}