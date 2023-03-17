package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class DashboardPage {
    private final WebDriver driver;

    @FindBy(xpath = "//a[@id='menu-dashboard']")
    private WebElement dashboardMenu;

    @FindBy(xpath = "//a[@id='company-additional-information'][1]") //div[contains(text(),'Deadline is over')]")
    public WebElement companyAdditionalInformationButton;

    @FindBy(css = "button#dashboard-done")
    public WebElement doneDeadlineButton;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

        public List<String> getAllTitlesByCategory(String categoryName) throws InterruptedException {
        dashboardMenu.click();

        Actions action = new Actions(driver);
        action.moveToElement(doneDeadlineButton).perform();
        doneDeadlineButton.click();

        companyAdditionalInformationButton.click();
        Thread.sleep(10_000);

        List<WebElement> rows = driver.findElements(By.xpath("//span[contains(text(), '" + categoryName + "')]//ancestor::tr//a[@id='ticket-block-title']"));

        return rows.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getAllIdsWithPriorityP3() throws InterruptedException {
        dashboardMenu.click();
        companyAdditionalInformationButton.click();
        Thread.sleep(10_000);

        List<WebElement> rows = driver.findElements(By.xpath("//td[contains(text(), 'P3')]//ancestor::tr/td[2]"));

        return rows.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}