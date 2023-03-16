package tests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.DashboardPage;
import pageobjects.TicketsPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginTestFirefox {

    private WebDriver driver;
    private String url;
    private String username;
    private String password;

    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/maven/geckodriver");
    }

    @BeforeEach
    public void setUp() throws IOException {

        Properties props = new Properties();
        FileInputStream input = new FileInputStream("src/test/resources/login.properties");
        props.load(input);
        url = props.getProperty("url");
        username = props.getProperty("username");
        password = props.getProperty("password");

        driver = new FirefoxDriver();
    }

    @Test
    public void testLogin() throws InterruptedException {
        Duration duration = Duration.ofSeconds(10);
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-signin")).click();

        Thread.sleep(5000);

        //TicketsPage ticketsPage = new TicketsPage(driver);

        //ticketsPage.getAllIds("Id");
        //ticketsPage.getAllTitles("Title");
        //ticketsPage.getAllAssignees("Assignee");
        //ticketsPage.getAllStages("Stage");

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.getAllTitlesWithCategoryDevelopment();

    }

    @AfterEach
    public void tearDown() {

        driver.quit();
    }
}