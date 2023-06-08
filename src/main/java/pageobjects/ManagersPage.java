package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class ManagersPage extends BasePage {

    @FindBy(xpath = "//a[@id = 'managers-delete-btn']")
    private WebElement managersDeleteButton;

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

    public Map<String, String> findManager(Map<String, String> manager) throws InterruptedException {
        logger.info("Finding manager: " + manager.get("first_name") + " " + manager.get("last_name"));
        wait.until((ExpectedConditions.visibilityOf(firstNameSearchInput)));
        firstNameSearchInput.click();
        String firstNameValue = manager.get("first_name");
        logger.info("Entering first name: " + firstNameValue);
        firstNameSearchInput.sendKeys(firstNameValue);
        lastNameSearchInput.click();
        String lastNameValue = manager.get("last_name");
        logger.info("Entering last name: " + lastNameValue);
        lastNameSearchInput.sendKeys(lastNameValue);
        searchManagerFilterButton.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(searchManagersResult));
        actions.moveToElement(searchManagersResult).perform();
        logger.info("Clicking on manager result");
        searchManagersResult.click();
        wait.until(ExpectedConditions.visibilityOf(managerDetailsBackToListButton));
        String nameFieldValue = nameValue.getText();
        fieldValues.put("name", nameFieldValue);
        String phoneFieldValue = phoneValue.getText();
        fieldValues.put("phone", phoneFieldValue);
        String skypeFieldValue = skypeValue.getText();
        fieldValues.put("skype", skypeFieldValue);
        return fieldValues;
    }
}