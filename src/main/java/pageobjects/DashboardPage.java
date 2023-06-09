package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@id='menu-dashboard']")
    private WebElement dashboardMenu;

    @FindBy(xpath = "//*[@id='accordion7']/div")
    private WebElement companyAdditionalInformationButton;

    @FindBy(xpath = "//button[@id='dashboard-done']")
    private WebElement dashboardDoneButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void getPageDeadlineIsOver() throws InterruptedException {
        logger.info("Navigating to dashboard");
        dashboardMenu.click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(dashboardDoneButton).perform();
        Thread.sleep(2000);
        logger.info("Clicking on 'Done' button");
        dashboardDoneButton.click();
        Thread.sleep(2000);
        logger.info("Opening company additional information");
        companyAdditionalInformationButton.click();
        Thread.sleep(2000);
    }

    public void getAllTitlesWithCategoryDevelopment() throws InterruptedException {
        getPageDeadlineIsOver();
        logger.info("Retrieving all titles with category 'Разработка'");
        List<WebElement> ticketTitles = driver.findElements(By.xpath("//span[contains(text(), 'Разработка')]//ancestor::tr//a[@id='ticket-block-title']"));
        for (WebElement title : ticketTitles) {
            String text = title.getText();
            logger.info("Title: " + text);
        }
    }

    public void getAllTitlesWithCategoryFinance() throws InterruptedException {
        getPageDeadlineIsOver();
        logger.info("Retrieving all titles with category 'Финансы'");
        List<WebElement> ticketTitles = driver.findElements(By.xpath("//span[contains(text(), 'Финансы')]//ancestor::tr//a[@id='ticket-block-title']"));
        for (WebElement title : ticketTitles) {
            String text = title.getText();
            logger.info("Title: " + text);
        }
    }

    public void getAllIdsWithPriorityP3() throws InterruptedException {
        getPageDeadlineIsOver();
        logger.info("Retrieving all ticket IDs with priority 'P3'");
        List<WebElement> ticketTitles = driver.findElements(By.xpath("//td[contains(text(), 'P3')]//ancestor::tr//td[2]"));
        for (WebElement title : ticketTitles) {
            String text = title.getText();
            logger.info("Ticket ID: " + text);
        }
    }
}