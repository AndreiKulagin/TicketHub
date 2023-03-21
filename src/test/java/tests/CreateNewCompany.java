package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CompaniesPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CreateNewCompany {
    private WebDriver driver;
    private String url;
    private String username;
    private String password;

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
    }

    @Test
    public void testCreateNewCompany() throws InterruptedException {
        Duration duration = Duration.ofSeconds(10);
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-signin")).click();

        CompaniesPage companiesPage = new CompaniesPage(driver);
        companiesPage.createNewCompany();
        Thread.sleep(1000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}