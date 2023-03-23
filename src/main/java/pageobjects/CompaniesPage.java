package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompaniesPage {
    private WebDriver driver;

    @FindBy(id = "menu-companies")
    private WebElement companiesMenu;

    @FindBy(id ="new-company")
    private WebElement newCompanyButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputCompanyName;

    @FindBy(xpath = "//button[@id='company-submit-btn']")
    private WebElement submitButton;

    @FindBy(xpath ="//tr[2]//td[5]//a")
    private WebElement deleteButton;

    public CompaniesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void createNewCompany(String companyName){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='create-new-ticket']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(companiesMenu).perform();
        companiesMenu.click();
        newCompanyButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='name']")));
        inputCompanyName.sendKeys(companyName);
        submitButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='new-company']")));
        actions.moveToElement(deleteButton).perform();
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}