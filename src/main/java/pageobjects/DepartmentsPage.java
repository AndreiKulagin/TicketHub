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

    public DepartmentsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}