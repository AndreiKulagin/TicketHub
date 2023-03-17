package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.DashboardPage;
import pageobjects.TicketsPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class LoginTestChrome {

    private WebDriver driver;
    private String url;
    private String username;
    private String password;

    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\viktor.chmel\\.m2\\repository\\webdriver\\chrome\\chromedriver.exe");
        //without this I received 403 error and "Unable to establish websocket connection" during chrome test
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
        options.addArguments("start-maximized");

        this.driver = new ChromeDriver(options);
    }

    @Test
    public void testLogin() throws InterruptedException {
        Duration duration = Duration.ofSeconds(10);
        this.driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        this.driver.findElement(By.id("username")).sendKeys(username);
        this.driver.findElement(By.id("password")).sendKeys(password);
        this.driver.findElement(By.id("login-signin")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='body']/app-root/" +
                "ticketshub-application/div[2]/div[3]/tickets/div/div/div/div/table/tbody/tr[1]/th[2]")));


        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.getAllIds();
        ticketsPage.getAllTitles();
        ticketsPage.getAllAssignees();
        ticketsPage.getAllStages();

        DashboardPage dashboardPage = new DashboardPage(driver);
        System.out.println(Arrays.toString(dashboardPage.getAllTitlesByCategory("Разработка").toArray()));
        System.out.println(Arrays.toString(dashboardPage.getAllTitlesByCategory("Финансы").toArray()));
        //all ID of Priority = P3
        System.out.println(Arrays.toString(dashboardPage.getAllIdsWithPriorityP3().toArray()));
    }

    @AfterEach
    public void tearDown() {
        this.driver.quit();
    }
}