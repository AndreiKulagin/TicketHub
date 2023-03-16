package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TicketsPage {
    private WebDriver driver;

    @FindBy(id = "menu-tickets")
    private WebElement ticketsMenu;

    @FindBy(xpath = "//th[contains(text(),'Id')]")
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