package pageobjects;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BasePage {

    protected WebDriver driver;
    protected Actions actions;
    protected Faker faker;
    Map<String, String> fieldValues;
    protected Map<String, String> manager;
    protected WebDriverWait wait;
    public static final Duration TIMEOUT = Duration.ofSeconds(10);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.faker = new Faker();
        this.manager = new HashMap<>();
        this.fieldValues = new HashMap<>();
        this.wait = new WebDriverWait(driver, TIMEOUT);
        PageFactory.initElements(driver, this);
    }
}