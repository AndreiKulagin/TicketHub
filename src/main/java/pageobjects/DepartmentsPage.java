package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DepartmentsPage{
    private WebDriver driver;

    @FindBy(id = "menu-departments")
    public WebElement departmentsMenu;

    @FindBy(id = "new-department")
    public WebElement newDepartmentButton;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement inputTitle;

    @FindBy(xpath = "//button[@id='department-form-submit']")
    public WebElement submitButton;

    public DepartmentsPage(WebDriver driver)throws InterruptedException{
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void createNewDepartment() throws InterruptedException {
        departmentsMenu.click();
        newDepartmentButton.click();
        Thread.sleep(1000);
        inputTitle.sendKeys("Andrei Kulagin");
        submitButton.click();
    }
}