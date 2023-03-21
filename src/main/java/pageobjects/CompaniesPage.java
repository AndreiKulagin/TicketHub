package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CompaniesPage {
    private WebDriver driver;

    @FindBy(id = "menu-companies")
    public WebElement companiesMenu;

    @FindBy(id ="new-company")
    public WebElement newCompanyButton;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement inputCompanyName;

    @FindBy(xpath = "//button[@id='company-submit-btn']")
    public WebElement submitButton;

    @FindBy(xpath ="//tr[2]//td[5]//a")
    public WebElement deleteButton;

    public CompaniesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void createNewCompany() throws InterruptedException{
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(companiesMenu).perform();
        Thread.sleep(2000);
        companiesMenu.click();
        newCompanyButton.click();
        Thread.sleep(1000);
        inputCompanyName.sendKeys("Kulagin");
        submitButton.click();
        Thread.sleep(1000);
        actions.moveToElement(deleteButton).perform();
        Thread.sleep(1000);
        deleteButton.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}