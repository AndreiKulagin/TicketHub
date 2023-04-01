package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ManagersPage {

    private WebDriver driver;
    Map<String, String> generatedData = new HashMap<>();
    Duration duration = Duration.ofSeconds(10);
    WebDriverWait wait = new WebDriverWait(driver, duration);
    Actions actions = new Actions(driver);


    @FindBy(xpath = "//a[@id = 'menu-managers']")
    private WebElement managersMenuButton;

    @FindBy(xpath = "//button[@id = 'managers-new-manager']")
    private WebElement newManagerButton;

    @FindBy(xpath = "//button[@id='create-new-ticket']")
    private WebElement createNewTicketButton;

    @FindBy(xpath = "//input[@id = 'firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id = 'lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id = 'email']")
    private WebElement emailInput;

    @FindBy(xpath = "//select[@name = 'departmentId']")
    private WebElement departmentSelect;

    @FindBy(xpath = "//select[@name='departmentId']/option[contains(text(),'Depo')]")
    private WebElement departmentOptionDepoButton;

    @FindBy(xpath = "//input[@id = 'phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@id = 'skype']")
    private WebElement skypeInput;

    @FindBy(xpath = "//button[@id = 'manager-form-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@id ='search-manager-firstname']")
    private WebElement firstNameSearchInput;

    @FindBy(xpath = "//input[@id = 'search-manager-lastname']")
    private WebElement lastNameSearchInput;

    @FindBy(xpath = "//button[@id = 'search-manager-filter']")
    private WebElement searchManagerFilterButton;

    @FindBy(xpath = "//table//td[1]/a")
    private WebElement searchManagersResult;

    @FindBy(xpath = "//button[@id = 'manager-details-backtolist']")
    private WebElement managerDetailsBackToListButton;

    public ManagersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createNewManager() {
        wait.until(ExpectedConditions.visibilityOf(createNewTicketButton));
        actions.moveToElement(managersMenuButton).perform();
        managersMenuButton.click();
        newManagerButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        Faker faker = new Faker();
        String generatedFirstName = faker.name().firstName();
        firstNameInput.sendKeys(generatedFirstName);
        generatedData.put("First name", generatedFirstName);
        lastNameInput.click();
        String generatedLastName = faker.name().lastName();
        lastNameInput.sendKeys(generatedLastName);
        generatedData.put("Last name", generatedLastName);
        emailInput.click();
        String generatedEmail = faker.internet().emailAddress();
        emailInput.sendKeys(generatedEmail);
        generatedData.put("Email", generatedEmail);
        departmentSelect.click();
        wait.until((ExpectedConditions.visibilityOf(departmentOptionDepoButton)));
        departmentOptionDepoButton.click();
        phoneInput.click();
        String generatedPhoneNumber = faker.phoneNumber().cellPhone();
        phoneInput.sendKeys(generatedPhoneNumber);
        generatedData.put("Phone", generatedPhoneNumber);
        skypeInput.click();
        String generatedSkype = faker.lorem().characters(10);
        skypeInput.sendKeys(generatedSkype);
        generatedData.put("Skype", generatedSkype);
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
        for (Map.Entry<String, String> entry : generatedData.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        }

        public void findManager(){
            Duration duration = Duration.ofSeconds(10);
            WebDriverWait wait = new WebDriverWait(driver, duration);
            wait.until((ExpectedConditions.visibilityOf(firstNameSearchInput)));
            firstNameSearchInput.click();
            String firstNameValue = generatedData.get("First name");
            firstNameSearchInput.sendKeys(firstNameValue);
            lastNameSearchInput.click();
            String lastNameValue = generatedData.get("Last name");
            lastNameSearchInput.sendKeys(lastNameValue);
            searchManagerFilterButton.click();
            searchManagersResult.click();
            wait.until(ExpectedConditions.visibilityOf(managerDetailsBackToListButton));
            Map<String,String> fieldValues = new HashMap<>();
            //String nameFieldValue =
            //fieldValues.put("Name",)
        }
    }
