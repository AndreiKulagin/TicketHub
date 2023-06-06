package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;

public class TicketsPage extends BasePage{

    @FindBy(xpath = "//button[@id = 'new-inner-ticket']")
    private WebElement newInnerTicketButton;

    @FindBy(xpath = "//select[@id = 'setPriority']//option[5]")
    private WebElement ticketPriorityInformation;

    @FindBy(xpath = "//th[contains(text(),'Company') and contains(@class, 'first')]/following-sibling::td")
    private WebElement ticketCompanyInformation;

    @FindBy(xpath = "//th[contains(text(),'Contact') and contains(@class, 'first')]/following-sibling::td")
    private WebElement ticketContactInformation;

    @FindBy(xpath = "//select[@id = 'setCategory']//option[2]")
    private WebElement ticketCategoryInformation;

    @FindBy(xpath = "//select[@id = 'setCategory']//option[3]")
    private WebElement innerTicketCategoryInformation;

    @FindBy(xpath = "//th[contains(text(),'Stage') and contains(@class, 'first')]/following-sibling::td")
    private WebElement ticketStageInformation;

    @FindBy(xpath = "//th[contains(text(),'Done') and contains(@class, 'first')]/following-sibling::td")
    private WebElement doneDeadlineInformation;

    @FindBy(xpath = "//th[contains(text(),'Update') and contains(@class, 'first')]/following-sibling::td")
    private WebElement updateTimestampInformation;

    @FindBy(xpath = "//th[contains(text(),'Creation') and contains(@class, 'first')]/following-sibling::td")
    private WebElement creationTimestampInformation;

    @FindBy(xpath = "//span[@class = 'ui-tabview-left-icon fa fa-info-circle']")
    private WebElement ticketInformationTab;

    @FindBy(xpath = "//div[@class = 'ticket-details_table-color_description']")
    private WebElement ticketDescriptionValue;

    @FindBy(xpath = "//div[@id = 'headingThree']")
    private WebElement ticketsSearchResult;

    @FindBy(xpath = "//button[@id = 'search-bar-submit']")
    private WebElement searchBarSubmit;

    @FindBy(xpath = "//input[@id = 'search-bar']")
    private WebElement inputSearchBar;

    @FindBy(xpath = "//button[@class = 'close']")
    private WebElement alertCloseButton;

    @FindBy(xpath = "//button[@id='create-new-ticket']")
    private WebElement newTicketButton;

    @FindBy(xpath = "//input[@id='title']")
    private WebElement inputTitle;

    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement textareaDescription;

    @FindBy(xpath = "//select[@id='categoryId']")
    private WebElement selectCategoryButton;

    @FindBy(xpath = "//select[@id='stageId']")
    private WebElement selectStageButton;

    @FindBy(xpath = "//select[@id='company']")
    private WebElement companySelectButton;

    @FindBy(xpath = "//select[@id='contactId']")
    private WebElement contactSelectButton;

    @FindBy(xpath = "//select[@id='contactId']/option[2]")
    private WebElement contactOptionButton;

    @FindBy(xpath = "//select[@id='priority']")
    private WebElement prioritySelectButton;

    @FindBy(xpath = "//p-calendar[@id='done-deadline-date']/span/button/span[1]")
    private WebElement doneDeadlineCalendarButton;

    @FindBy(xpath = "//table/tbody/tr[5]/td[5]")
    private WebElement calendarSelectDateButton;

    @FindBy(xpath = "//select[@id='department']")
    private WebElement departmentSelectButton;

    @FindBy(xpath = "//button[@id='submit-btn']")
    private WebElement submitButton;

    public WebElement selectPriorityOption(String priority){
        String xpath = "//select[@id='priority']/option[contains(text(),'" + priority + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selectCompanyOptionByPartialName(String companyName) {
        String xpath = "//select[@id='company']/option[contains(text(),'" + companyName + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selectDepartmentOption(String departmentName){
        String xpath = "//select[@id='department']/option[contains(text(),'" + departmentName + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selectCategoryOption(String categoryName){
        String xpath = "//select[@id='categoryId']/option[contains(text(),'" +categoryName + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selectStageOption(String stageOption){
        String xpath = "//option[contains(text(),'" + stageOption + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getTicketsSearchResult(String ticketSearchResult){
        String xpath = "//h4[contains(text(), '" + ticketSearchResult + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getStageInformation(String stageInformation){
        String xpath = "//td[contains(text(),'" + stageInformation + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public TicketsPage(WebDriver driver) {
        super(driver);
    }

    public void createNewTicket(String titleName,String textareaName,String companyName, String departmentName,String categoryName,String stageOption) throws InterruptedException {
        newTicketButton.click();
        inputTitle.sendKeys(titleName);
        textareaDescription.click();
        textareaDescription.sendKeys(textareaName);
        selectCategoryButton.click();
        Thread.sleep(2000);
        selectCategoryOption(categoryName).click();
        selectStageButton.click();
        wait.until(ExpectedConditions.visibilityOf(selectStageOption(stageOption)));
        selectStageOption(stageOption).click();
        companySelectButton.click();
        selectCompanyOptionByPartialName(companyName).click();
        contactSelectButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(contactOptionButton));
        contactOptionButton.click();
        departmentSelectButton.click();
        selectDepartmentOption(departmentName).click();
        submitButton.click();
    }

    public void createNewInnerTicket(String titleName,String descriptionArea,String departmentName,String categoryName) throws InterruptedException {
        newTicketButton.click();
        wait.until(ExpectedConditions.visibilityOf(newInnerTicketButton));
        newInnerTicketButton.click();
        inputTitle.sendKeys(titleName);
        textareaDescription.click();
        textareaDescription.sendKeys(descriptionArea);
        selectCategoryButton.click();
        Thread.sleep(2000);
        selectCategoryOption(categoryName).click();
        departmentSelectButton.click();
        selectDepartmentOption(departmentName);
        submitButton.click();
    }

    public HashMap<String, String> getAllInformationAboutInnerTicket(String stageInformation, String title){
        HashMap<String,String> InnerTicketValues = new HashMap<>();
        String ticketDescription = ticketDescriptionValue.getText();
        InnerTicketValues.put("description",ticketDescription);
        ticketInformationTab.click();
        String stageInformationAboutTicket = ticketStageInformation.getText();
        InnerTicketValues.put("stage",stageInformationAboutTicket);
        String categoryInformation = innerTicketCategoryInformation.getText();
        InnerTicketValues.put("category",categoryInformation);
        InnerTicketValues.put("title",title);
        return InnerTicketValues;
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

    public void findTicket(String title) throws InterruptedException {
                            wait.until(ExpectedConditions.visibilityOf(newTicketButton));
                            Thread.sleep(2000);
                            alertCloseButton.click();
                            Thread.sleep(2000);
                            inputSearchBar.click();
                            Thread.sleep(2000);
                            inputSearchBar.sendKeys(title);
                            searchBarSubmit.click();
                            ticketsSearchResult.click();
                            Thread.sleep(2000);
                            getTicketsSearchResult(title).click();
                            Thread.sleep(2000);
    }

    public HashMap<String,String> getAllInformationAboutTicket(String stageInformation,String title){
    HashMap<String,String> ticketValues = new HashMap<>();
        String ticketDescription = ticketDescriptionValue.getText();
        ticketValues.put("description",ticketDescription);
        ticketInformationTab.click();
        String stageInformationAboutTicket = ticketStageInformation.getText();
        ticketValues.put("stage",stageInformationAboutTicket);
        String contactInformation = ticketContactInformation.getText();
        ticketValues.put("contact",contactInformation);
        String categoryInformation = ticketCategoryInformation.getText();
        ticketValues.put("category",categoryInformation);
        String companyInformation = ticketCompanyInformation.getText();
        ticketValues.put("company",companyInformation);
        String priorityInformation = ticketPriorityInformation.getText();
        ticketValues.put("priority",priorityInformation);
        ticketValues.put("title",title);
        return ticketValues;
    }
}