package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends BasePage {

    private String alertMessageValue;

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

    public void findContact() {
        logger.info("Finding contact");
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage
                .waitUntil(contactsMenu)
                .clickButton(contactsMenu);
        logger.info("Clicked on 'Contacts' menu");
        contactsPage
                .clickButton(searchFirstNameInput)
                .fillInInput(searchFirstNameInput, "Andrei");
        logger.info("Filled in search criteria: first name - Andrei");
        contactsPage
                .clickButton(searchLastNameInput)
                .fillInInput(searchFirstNameInput, "Kul");
        logger.info("Filled in search criteria: last name - Kul");
        contactsPage
                .clickButton(searchContactButton);
        logger.info("Clicked on 'Search' button");
        contactsPage
                .clickButton(searchContactResult);
        logger.info("Clicked on search result");
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
    }

    public void openPage(){
        wait.until(ExpectedConditions.visibilityOf(newTicketButton));
        actions.moveToElement(contactsMenu).perform();
        contactsMenu.click();
        newContactButton.click();
    }

    public void pressNewContactButton(){
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