package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.DashboardPage;
import pageobjects.TicketsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginTestChrome {

    private WebDriver driver;
    private String url;
    private String username;
    private String password;

    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/maven/chromedriver");
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
    }

    @Test
    public void testLogin() {
        Duration duration = Duration.ofSeconds(10);
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-signin")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='body']/app-root/" +
                "ticketshub-application/div[2]/div[3]/tickets/div/div/div/div/table/tbody/tr[1]/th[2]")));


        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.getAllIds();
        ticketsPage.getAllTitles();
        ticketsPage.getAllAssignees();
        ticketsPage.getAllStages();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.getAllTitlesWithCategoryDevelopment();
        dashboardPage.getAllTitlesWithCategoryFinance();
        dashboardPage.getAllIdsWithPriorityP3();

    }

    @AfterEach
    public void tearDown() {

        driver.quit();
    }
}