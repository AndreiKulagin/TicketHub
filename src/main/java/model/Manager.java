package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.BasePage;

import java.util.Map;

public class Manager extends BasePage {

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

    public Manager(WebDriver driver) {

        super(driver);
    }

    public String generateFirstName(){

        return faker.name().firstName();
    }

    public String generateLastName() {

        return faker.name().lastName();
    }

    public String generateEmail(){
        String username = faker.name().firstName().toLowerCase();
        String domain = faker.internet().domainName().toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(username).append("@").append(domain).append(".com");
        String generatedEmail = sb.toString();
            if (generatedEmail.length() > 25) {
            generatedEmail = sb.substring(0, 22) + "...";
        }
        return generatedEmail;
        }

        public String generateSkype(){
        return faker.lorem().characters(10);
        }

        public String generatePhone(){
        return faker.phoneNumber().cellPhone();
        }

    public Map<String,String> getRandomManager(){
        wait.until(ExpectedConditions.visibilityOf(createNewTicketButton));
        actions.moveToElement(managersMenuButton).perform();
        managersMenuButton.click();
        newManagerButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        String generatedFirstName = generateFirstName();
        firstNameInput.sendKeys(generatedFirstName);
        manager.put("First name", generatedFirstName);
        lastNameInput.click();
        String generatedLastName = generateLastName();
        lastNameInput.sendKeys(generatedLastName);
        manager.put("Last name", generatedLastName);
        emailInput.click();
        String generatedEmail = generateEmail();
        emailInput.sendKeys(generatedEmail);
        manager.put("Email", generatedEmail);
        departmentSelect.click();
        wait.until((ExpectedConditions.visibilityOf(departmentOptionDepoButton)));
        departmentOptionDepoButton.click();
        phoneInput.click();
        String generatedPhone = generatePhone();
        phoneInput.sendKeys(generatedPhone);
        manager.put("Phone", generatedPhone);
        skypeInput.click();
        String generatedSkype = generateSkype();
        skypeInput.sendKeys(generatedSkype);
        manager.put("Skype", generatedSkype);
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        actions.moveToElement(submitButton).perform();
        submitButton.click();
        return manager;
    }
    }