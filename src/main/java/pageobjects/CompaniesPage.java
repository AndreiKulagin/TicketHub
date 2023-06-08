package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class CompaniesPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Tickets prefix') and contains(@class, 'col-sm-4')]/following-sibling::div")
    private WebElement ticketsPrefixInformation;

    @FindBy(xpath = "//div[contains(text(),'Company name') and contains(@class, 'col-sm-4')]/following-sibling::div")
    private WebElement companyNameInformation;

    @FindBy(xpath = "//button[@id = 'search-company-submit']")
    private WebElement searchCompanySubmitButton;

    @FindBy(id = "menu-companies")
    private WebElement companiesMenu;

    @FindBy(id = "new-company")
    private WebElement newCompanyButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputCompanyName;

    @FindBy(xpath = "//button[@id='company-submit-btn']")
    private WebElement submitButton;

    @FindBy(xpath = "//tr[2]//td[5]//a")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[@id='create-new-ticket']")
    private WebElement createNewTicketButton;

    @FindBy(xpath = "//span[@class = 'ui-tabview-title' and contains(text(), 'Company details')]")
    private WebElement companyDetailsTab;

    public WebElement getCompanySearchResult(String companyName) {
        String xpath = "//a[contains(text(), '" + companyName + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public CompaniesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void createNewCompany(String companyName) {
        wait.until(ExpectedConditions.visibilityOf(createNewTicketButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(companiesMenu).perform();
        companiesMenu.click();
        newCompanyButton.click();
        wait.until(ExpectedConditions.visibilityOf(inputCompanyName));
        inputCompanyName.sendKeys(companyName);
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(newCompanyButton));
    }

    public void findCompany(String companyName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(searchCompanySubmitButton));
        inputCompanyName.click();
        inputCompanyName.sendKeys(companyName);
        searchCompanySubmitButton.click();
        Thread.sleep(2000);
        getCompanySearchResult(companyName).click();
        wait.until(ExpectedConditions.visibilityOf(companyDetailsTab));
    }

    public HashMap<String, String> getAllInformationAboutCompany() {
        HashMap<String, String> companyValues = new HashMap<>();
        String companyName = companyNameInformation.getText();
        companyValues.put("name", companyName);
        String prefixInformation = ticketsPrefixInformation.getText();
        companyValues.put("ticket_prefix", prefixInformation);
        return companyValues;
    }
}