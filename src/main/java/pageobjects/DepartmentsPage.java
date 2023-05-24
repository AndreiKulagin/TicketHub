package pageobjects;

import model.Department;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DepartmentsPage {

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
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void createNewDepartment(Department department) {
        departmentsMenu.click();
        newDepartmentButton.click();
        inputTitle.click();
        inputTitle.sendKeys(department.getTitle());
        additionalInfoButton.click();
        phoneInput.click();
        phoneInput.sendKeys(department.getPhone());
        skypeInput.click();
        skypeInput.sendKeys(department.getSkype());
        websiteInput.click();
        websiteInput.sendKeys(department.getWebsite());
        emailInput.click();
        emailInput.sendKeys(department.getEmail());
        countryInput.click();
        countryInput.sendKeys(department.getCountry());
        cityInput.click();
        cityInput.sendKeys(department.getCity());
        submitButton.click();
    }
}