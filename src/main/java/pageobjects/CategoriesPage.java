package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;

public class CategoriesPage extends BasePage{

    @FindBy(xpath = "//button[@id='create-new-ticket']")
    private WebElement createNewTicketButton;

    @FindBy(id = "menu-categories")
    private WebElement categoriesMenu;

    @FindBy(xpath = "//button[@id ='new-category-btn']")
    private WebElement newCategoryButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement categoryTitleInput;

    @FindBy(xpath = "//input[@id = 'color']")
    private WebElement categoryColorInput;

    @FindBy(xpath = "//button[@id = 'category-form-submit']")
    private WebElement categoryFormSubmit;

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }
    public HashMap<String,String> createNewCategory(String categoryName,String categoryColor){
        wait.until(ExpectedConditions.visibilityOf(createNewTicketButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(categoriesMenu).perform();
        categoriesMenu.click();
        newCategoryButton.click();
        wait.until(ExpectedConditions.visibilityOf(categoryTitleInput));
        categoryTitleInput.sendKeys(categoryName);
        wait.until(ExpectedConditions.visibilityOf(categoryColorInput));
        categoryColorInput.click();
        categoryColorInput.sendKeys(categoryColor);
        categoryFormSubmit.click();
        HashMap<String,String>categoryValues = new HashMap<>();
        categoryValues.put("name",categoryName);
        categoryValues.put("color",categoryColor);
        return categoryValues;
    }
}