package pageobjects;

import model.Department;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class DepartmentsPage extends BasePage {

    private WebDriver driver;

    @FindBy(id = "menu-departments")
    private WebElement departmentsMenu;

    @FindBy(id = "new-department")
    private WebElement newDepartmentButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputTitle;

    @FindBy(xpath = "//button[@id='department-form-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@id = 'department-form-additional-info']")
    private WebElement additionalInfoButton;

    @FindBy(xpath = "//input[@id = 'phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@id = 'skype']")
    private WebElement skypeInput;

    @FindBy(xpath = "//input[@id = 'website']")
    private WebElement websiteInput;

    @FindBy(xpath = "//input[@id = 'email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id = 'country']")
    private WebElement countryInput;

    @FindBy(xpath = "//input[@id = 'city']")
    private WebElement cityInput;

    public DepartmentsPage(WebDriver driver) {
        super(driver);
    }

    public void createNewDepartment(Department department) {
        logger.info("Creating a new department");
        departmentsMenu.click();
        newDepartmentButton.click();
        logger.info("Entering department title: " + department.getTitle());
        inputTitle.click();
        inputTitle.sendKeys(department.getTitle());
        additionalInfoButton.click();
        logger.info("Entering department phone: " + department.getPhone());
        phoneInput.click();
        phoneInput.sendKeys(department.getPhone());
        logger.info("Entering department Skype: " + department.getSkype());
        skypeInput.click();
        skypeInput.sendKeys(department.getSkype());
        logger.info("Entering department website: " + department.getWebsite());
        websiteInput.click();
        websiteInput.sendKeys(department.getWebsite());
        logger.info("Entering department email: " + department.getEmail());
        emailInput.click();
        emailInput.sendKeys(department.getEmail());
        logger.info("Entering department country: " + department.getCountry());
        countryInput.click();
        countryInput.sendKeys(department.getCountry());
        logger.info("Entering department city: " + department.getCity());
        cityInput.click();
        cityInput.sendKeys(department.getCity());
        submitButton.click();
    }
}