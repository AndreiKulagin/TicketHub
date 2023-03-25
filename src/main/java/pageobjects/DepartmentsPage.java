package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DepartmentsPage{

    private WebDriver driver;

    @FindBy(id = "menu-departments")
    private WebElement departmentsMenu;

    @FindBy(id = "new-department")
    private WebElement newDepartmentButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputTitle;

    @FindBy(xpath = "//button[@id='department-form-submit']")
    private WebElement submitButton;

    public DepartmentsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void createNewDepartment(String titleName){

        departmentsMenu.click();
        newDepartmentButton.click();
        inputTitle.sendKeys(titleName);
        submitButton.click();
    }
}