package tests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageobjects.MainPage;
import utils.ScreenshotUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Logger;

public class BaseUiTest {

    protected static WebDriver driver;
    protected static String url;
    protected static String username;
    protected static String password;
    private static MainPage mainPage;

    private static final String OPERATION_SYSTEM = System.getProperty("os.name");
    protected static final Logger logger = Logger.getLogger(BaseUiTest.class.getName());

    @BeforeAll
    public static void setUpClass() throws IOException, MalformedURLException {
        String driverDir = System.getProperty("user.home").replaceAll("\\\\", "/") + "/.m2/repository/webdriver/chrome/";
        if (OPERATION_SYSTEM.toLowerCase(Locale.ROOT).contains("windows")) {
            System.setProperty("webdriver.chrome.driver", driverDir + "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", driverDir + "chromedriver");
        }
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
            put("enableVideo", true);
        }});

        String selenoidUrl = "http://192.168.0.113:4444";
        driver = new RemoteWebDriver(new URL(selenoidUrl), options);

        Properties props = new Properties();
        FileInputStream input = new FileInputStream("src/test/resources/login.properties");
        props.load(input);
        url = props.getProperty("url");
        username = props.getProperty("username");
        password = props.getProperty("password");

        driver.get(url);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-signin")).click();

        Duration duration = Duration.ofSeconds(30);
        mainPage = new MainPage(driver, duration);
        mainPage.openPage();
    }

    @AfterAll
    public static void takeScreenshotAndTearDown() throws IOException {
        ScreenshotUtils.takeScreenshot(driver, "CreateNewCompanyCheckDB");
        driver.quit();
    }
}