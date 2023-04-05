package pageobjects;

import model.Manager;
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
    Map<String,String> fieldValues;
    Map<String, String> generatedData;
    protected Manager manager;
    protected WebDriverWait wait;
    public static final Duration TIMEOUT = Duration.ofSeconds(10);

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
        this.generatedData = new HashMap<>();
        this.fieldValues = new HashMap<>();
        this.manager = new Manager();
        this.wait = new WebDriverWait(driver,TIMEOUT);
        PageFactory.initElements(driver, this);
    }
}