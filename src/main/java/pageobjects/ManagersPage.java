package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Map;

public class ManagersPage extends BasePage {

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

    public Map<String,String> findManager(Map<String, String> manager) {
            wait.until((ExpectedConditions.visibilityOf(firstNameSearchInput)));
            firstNameSearchInput.click();
            String firstNameValue = manager.get("First name");
            firstNameSearchInput.sendKeys(firstNameValue);
            lastNameSearchInput.click();
            String lastNameValue = manager.get("Last name");
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