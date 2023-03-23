package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TicketsPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[@id='create-new-ticket']")
    private WebElement newTicketButton;

    @FindBy(xpath = "//input[@id='title']")
    private WebElement inputTitle;

    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement textareaDescription;

    @FindBy(xpath = "//select[@id='categoryId']")
    private WebElement selectCategoryButton;

    @FindBy(xpath = "//select[@id='categoryId']/option[contains(text(),'Test')][1]")
    private WebElement categoryOptionTestButton;

    @FindBy(xpath = "//select[@id='stageId']")
    private WebElement selectStageButton;

    @FindBy(xpath = "//option[contains(text(),'DONE')]")
    private WebElement stageOptionOpenButton;

    @FindBy(xpath = "//select[@id='company']")
    private WebElement companySelectButton;

    @FindBy(xpath = "//select[@id='company']/option[contains(text(),'Kul')]")
    private WebElement companyOptionTestButton;

    @FindBy(xpath = "//select[@id='contactId']")
    private WebElement contactSelectButton;

    @FindBy(xpath = "//select[@id='contactId']/option[contains(text(),'Kul')]")
    private WebElement contactOptionButton;

    @FindBy(xpath = "//select[@id='priority']")
    private WebElement prioritySelectButton;

    @FindBy(xpath = "//select[@id='priority']/option[contains(text(),'P1')]")
    private WebElement priorityOptionP1Button;

    @FindBy(xpath = "//p-calendar[@id='done-deadline-date']/span/button/span[1]")
    private WebElement doneDeadlineCalendarButton;

    @FindBy(xpath = "//table/tbody/tr[5]/td[5]")
    private WebElement calendarSelectDateButton;

    @FindBy(xpath = "//select[@id='department']")
    private WebElement departmentSelectButton;

    @FindBy(xpath = "//select[@id='department']/option[contains(text(),'Managers')]")
    private WebElement departmentOptionManagersButton;

    @FindBy(xpath = "//button[@id='submit-btn']")
    private WebElement submitButton;


    public TicketsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void createNewTicket(String titleName,String textareaName) {

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver,duration);

        newTicketButton.click();
        inputTitle.sendKeys(titleName);

        textareaDescription.click();
        textareaDescription.sendKeys(textareaName);

        selectCategoryButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='categoryId']/option[contains(text(),'Test')][1]")));
        categoryOptionTestButton.click();

        selectStageButton.click();
        wait.until((ExpectedConditions.presenceOfElementLocated(By.xpath("//option[contains(text(),'DONE')]"))));
        stageOptionOpenButton.click();

        companySelectButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='company']/option[contains(text(),'Kul')]")));
        companyOptionTestButton.click();

        contactSelectButton.click();
        contactOptionButton.click();

        prioritySelectButton.click();
        priorityOptionP1Button.click();

        doneDeadlineCalendarButton.click();
        calendarSelectDateButton.click();
        doneDeadlineCalendarButton.click();

        departmentSelectButton.click();
        departmentOptionManagersButton.click();

        submitButton.click();
    }

    public void getAllIds(String columnTitle){
        List<WebElement> headers = driver.findElements(By.xpath("//th"));
        int neededColumnNumber = 0;
        for(int i=0; i< headers.size(); i++){
            if (headers.get(i).getText().contains(columnTitle)) {
                neededColumnNumber = i;
                break;
            }
        }

        List<WebElement> neededColumn = driver.findElements(By.xpath("//table//tr/td[" + (neededColumnNumber + 1) + "]"));

        for(WebElement cell : neededColumn){
            System.out.println(cell.getText());
        }
    }

    public void getAllTitles(String columnTitle){
        List<WebElement> headers = driver.findElements(By.xpath("//th"));
        int neededColumnNumber = 0;
        for(int i=0; i< headers.size(); i++){
            if (headers.get(i).getText().contains(columnTitle)) {
                neededColumnNumber = i;
                break;
            }
        }

        List<WebElement> neededColumn = driver.findElements(By.xpath("//table//tr/td[" + (neededColumnNumber + 1) + "]"));

        for(WebElement cell : neededColumn){
            System.out.println(cell.getText());
        }
    }

    public void getAllAssignees(String columnTitle){
        List<WebElement> headers = driver.findElements(By.xpath("//th"));
        int neededColumnNumber = 0;
        for(int i=0; i< headers.size(); i++){
            if (headers.get(i).getText().contains(columnTitle)) {
                neededColumnNumber = i;
                break;
            }
        }

        List<WebElement> neededColumn = driver.findElements(By.xpath("//table//tr/td[" + (neededColumnNumber + 1) + "]"));

        for(WebElement cell : neededColumn){
            System.out.println(cell.getText());
        }
    }

    public void getAllStages(String columnTitle){
        List<WebElement> headers = driver.findElements(By.xpath("//th"));
        int neededColumnNumber = 0;
        for(int i=0; i< headers.size(); i++){
            if (headers.get(i).getText().contains(columnTitle)) {
                neededColumnNumber = i;
                break;
            }
        }

        List<WebElement> neededColumn = driver.findElements(By.xpath("//table//tr/td[" + (neededColumnNumber + 1) + "]"));

        for(WebElement cell : neededColumn){
            System.out.println(cell.getText());
        }
    }
}