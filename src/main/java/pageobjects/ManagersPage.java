package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Map;

public class ManagersPage extends BasePage {

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

    @FindBy(xpath = "//a[@id='managers-delete-btn']/i")
    private WebElement managersDeleteButton;

    @FindBy(xpath = "//div[@class = 'row'][1]//p")
    private WebElement nameValue;

    @FindBy(xpath = "//div[@class = 'row'][2]//p")
    private WebElement phoneValue;

    @FindBy(xpath = "//div[@class = 'row'][3]//p")
    private WebElement skypeValue;

    @FindBy(xpath = "//div[@class = 'row'][4]//p")
    private WebElement emailValue;

    public ManagersPage(WebDriver driver) {
        super(driver);
    }

    public Map<String,String> createNewManager() {
        wait.until(ExpectedConditions.visibilityOf(createNewTicketButton));
        actions.moveToElement(managersMenuButton).perform();
        managersMenuButton.click();
        newManagerButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        String generatedFirstName = manager.generateFirstName();
        firstNameInput.sendKeys(generatedFirstName);
        generatedData.put("First name", generatedFirstName);
        lastNameInput.click();
        String generatedLastName = manager.generateLastName();
        lastNameInput.sendKeys(generatedLastName);
        generatedData.put("Last name", generatedLastName);
        emailInput.click();
        String generatedEmail = manager.generateEmail();
        emailInput.sendKeys(generatedEmail);
        generatedData.put("Email", generatedEmail);
        departmentSelect.click();
        wait.until((ExpectedConditions.visibilityOf(departmentOptionDepoButton)));
        departmentOptionDepoButton.click();
        phoneInput.click();
        String generatedPhone = manager.generatePhone();
        phoneInput.sendKeys(generatedPhone);
        generatedData.put("Phone", generatedPhone);
        skypeInput.click();
        String generatedSkype = manager.generateSkype();
        skypeInput.sendKeys(generatedSkype);
        generatedData.put("Skype", generatedSkype);
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        actions.moveToElement(submitButton).perform();
        submitButton.click();
        return generatedData;
        }

        public Map<String,String> findManager() {
            wait.until((ExpectedConditions.visibilityOf(firstNameSearchInput)));
            firstNameSearchInput.click();
            String firstNameValue = generatedData.get("First name");
            firstNameSearchInput.sendKeys(firstNameValue);
            lastNameSearchInput.click();
            String lastNameValue = generatedData.get("Last name");
            lastNameSearchInput.sendKeys(lastNameValue);
            searchManagerFilterButton.click();
            wait.until(ExpectedConditions.elementToBeClickable(searchManagersResult));
            actions.moveToElement(searchManagersResult).perform();
            searchManagersResult.click();
            wait.until(ExpectedConditions.visibilityOf(managerDetailsBackToListButton));
            String nameFieldValue = nameValue.getText();
            fieldValues.put("Name",nameFieldValue);
            String phoneFieldValue = phoneValue.getText();
            fieldValues.put("Phone",phoneFieldValue);
            String skypeFieldValue = skypeValue.getText();
            fieldValues.put("Skype",skypeFieldValue);
            String emailFieldValue = emailValue.getText().replaceAll("com.*","com");;
            fieldValues.put("Email",emailFieldValue);
            return fieldValues;
        }
    }