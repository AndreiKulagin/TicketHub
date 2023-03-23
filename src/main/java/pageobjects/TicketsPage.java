package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TicketsPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[@id='create-new-ticket']")
    public WebElement newTicketButton;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement inputTitle;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement textareaDescription;

    @FindBy(xpath = "//select[@id='categoryId']")
    public WebElement selectCategoryButton;

    @FindBy(xpath = "//select[@id='categoryId']/option[contains(text(),'Test')][1]")
    public WebElement categoryOptionTestButton;

    @FindBy(xpath = "//select[@id='stageId']")
    public WebElement selectStageButton;

    @FindBy(xpath = "//option[contains(text(),'DONE')]")
    public WebElement stageOptionOpenButton;

    @FindBy(xpath = "//select[@id='company']")
    public WebElement companySelectButton;

    @FindBy(xpath = "//select[@id='company']/option[contains(text(),'Kul')]")
    public WebElement companyOptionTestButton;

    @FindBy(xpath = "//select[@id='contactId']")
    public WebElement contactSelectButton;

    @FindBy(xpath = "//select[@id='contactId']/option[contains(text(),'Kul')]")
    public WebElement contactOptionButton;

    @FindBy(xpath = "//select[@id='priority']")
    public WebElement prioritySelectButton;

    @FindBy(xpath = "//select[@id='priority']/option[contains(text(),'P1')]")
    public WebElement priorityOptionP1Button;

    @FindBy(xpath = "//p-calendar[@id='done-deadline-date']/span/button/span[1]")
    public WebElement doneDeadlineCalendarButton;

    @FindBy(xpath = "//table/tbody/tr[5]/td[5]")
    public WebElement calendarSelectDateButton;

    @FindBy(xpath = "//select[@id='department']")
    public WebElement departmentSelectButton;

    @FindBy(xpath = "//select[@id='department']/option[contains(text(),'Managers')]")
    public WebElement departmentOptionManagersButton;

    @FindBy(xpath = "//button[@id='submit-btn']")
    public WebElement submitButton;

    @FindBy(xpath = "//th[[8]]]")
    public WebElement idHeader;

    @FindBy(xpath = "//th[contains(text(),'Title')]")
    public WebElement titleHeader;

    @FindBy(xpath = "//th[contains(text(),'Assignee')]")
    public WebElement assigneeHeader;

    @FindBy(xpath = "//th[contains(text(),'Stage')]")
    public WebElement stageHeader;

    public TicketsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void createNewTicket()throws InterruptedException {
        newTicketButton.click();
        inputTitle.sendKeys("Andrei Kulagins");

        textareaDescription.click();
        textareaDescription.sendKeys("Test");

        selectCategoryButton.click();
        Thread.sleep(1000);
        categoryOptionTestButton.click();

        selectStageButton.click();
        Thread.sleep(1000);
        stageOptionOpenButton.click();

        companySelectButton.click();
        Thread.sleep(1000);
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