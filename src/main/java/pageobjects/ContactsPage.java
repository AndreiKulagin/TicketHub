package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends BasePage {

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
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage
                .waitUntil(contactsMenu)
                .clickButton(contactsMenu)
                .clickButton(searchFirstNameInput)
                .fillInInput(searchFirstNameInput, "Andrei")
                .clickButton(searchLastNameInput)
                .fillInInput(searchFirstNameInput, "Kul")
                .clickButton(searchContactButton)
                .clickButton(searchContactResult);
    }
}