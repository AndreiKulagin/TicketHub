package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;

public class ContactsPage extends BasePage {

    private String alertMessageValue;

    @FindBy(xpath = "//a[@id='delete-btn']")
    private WebElement contactDeleteButton;

    @FindBy(xpath = "//button[@id ='contact-form-submit']")
    private WebElement contactSubmitButton;

    @FindBy(xpath = "//a[@id = 'edit-btn']")
    private WebElement contactEditButton;

    @FindBy(xpath = "//input[@id = 'login']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id = 'ticketPrefix']")
    private WebElement ticketPrefixInput;

    @FindBy(xpath = "//div[@class = 'alert alert-danger']")
    private WebElement alertMessage;

    @FindBy(xpath = "//input[@id = 'lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id = 'email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id = 'firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//button[@id='create-new-ticket']")
    private WebElement newTicketButton;

    @FindBy(id = "menu-contacts")
    private WebElement contactsMenu;

    @FindBy(xpath = "//button[@id='new-contact']")
    private WebElement newContactButton;

    @FindBy(xpath = "//input[@id = 'first-name']")
    private WebElement searchFirstNameInput;

    @FindBy(xpath = "//input[@id = 'last-name']")
    private WebElement searchLastNameInput;

    @FindBy(xpath = "//button[@id = 'search-contacts']")
    private WebElement searchContactButton;

    @FindBy(xpath = "//table//td[1]/a")
    private WebElement searchContactResult;

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public ContactsPage clickButton(WebElement buttonName) {
        waitUntil(contactsMenu);
        buttonName.click();
        return this;
    }

    public ContactsPage fillInInput(WebElement inputName, String value) {
        inputName.sendKeys(value);
        return this;
    }

    public ContactsPage waitUntil(WebElement waitVisibilityOF) {
        wait.until(ExpectedConditions.visibilityOf(waitVisibilityOF));
        return this;
    }

    public void findContact(String firstName, String lastName) {
        logger.info("Finding contact");
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage
                .clickButton(contactsMenu);
        logger.info("Clicked on 'Contacts' menu");
        contactsPage
                .fillInInput(searchFirstNameInput, firstName);
        logger.info("Filled in search criteria: first name -" + firstName);
        contactsPage
                .clickButton(searchLastNameInput)
                .fillInInput(searchLastNameInput, lastName);
        logger.info("Filled in search criteria: last name -" + lastName);
        contactsPage
                .clickButton(searchContactButton);
        logger.info("Clicked on 'Search' button");
    }

    public void deleteContact(){
       contactDeleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public HashMap<String, String> editContact(String contactNewFirstName, String contactNewLastname) {
        HashMap<String,String> firstNameLastNameValues = new HashMap<>();
        firstNameLastNameValues.put("first_name",contactNewFirstName);
        firstNameLastNameValues.put("last_name",contactNewLastname);
        contactEditButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.clear();
        firstNameInput.sendKeys(contactNewFirstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(contactNewLastname);
        actions.moveToElement(contactSubmitButton);
        contactSubmitButton.click();
        return firstNameLastNameValues;
    }

    public void createNewContact(String firstName, String email, String lastName, String login, String ticketPrefix) {
        wait.until(ExpectedConditions.visibilityOf(newTicketButton));
        actions.moveToElement(contactsMenu).perform();
        contactsMenu.click();
        wait.until(ExpectedConditions.visibilityOf(newContactButton));
        newContactButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.sendKeys(firstName);
        emailInput.sendKeys(email);
        lastNameInput.sendKeys(lastName);
        loginInput.clear();
        loginInput.sendKeys(login);
        wait.until(ExpectedConditions.visibilityOf(ticketPrefixInput));
        ticketPrefixInput.sendKeys(ticketPrefix);
        contactSubmitButton.click();
    }

    public void openPage() {
        wait.until(ExpectedConditions.visibilityOf(newTicketButton));
        actions.moveToElement(contactsMenu).perform();
        contactsMenu.click();
        newContactButton.click();
    }

    public void pressNewContactButton() {
        newContactButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
    }

    public String getAlertMessageValue() {
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        alertMessageValue = alertMessage.getText();
        return alertMessageValue;
    }

    public void setTicketsEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setTicketPrefix(String ticketPrefix) {
        wait.until(ExpectedConditions.visibilityOf(ticketPrefixInput));
        ticketPrefixInput.sendKeys(ticketPrefix);
    }

    public void setTicketLogin(String login) {
        wait.until(ExpectedConditions.visibilityOf(loginInput));
        loginInput.sendKeys(login);
    }

    public void setTicketLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(loginInput));
        lastNameInput.sendKeys(lastName);
    }
}