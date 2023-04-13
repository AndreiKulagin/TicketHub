package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class CategoriesPage extends BasePage{

    private WebDriver driver;

    @FindBy(id = "menu-categories")
    private WebElement categoriesMenu;

    public CategoriesPage(WebDriver driver) {

        super(driver);
    }
}