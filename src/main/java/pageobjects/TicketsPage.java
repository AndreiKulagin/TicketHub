package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TicketsPage {
    private final WebDriver driver;

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

    public void getAllIds(){
        List<String> ids = new ArrayList<>();
        List<WebElement> idElements = driver.findElements(By.xpath("//td[@width='80px']//span/span"));

        for(WebElement idElement : idElements){
            ids.add(idElement.getText());
        }
        System.out.println(ids);
    }

    public void getAllTitles(){
        List<String> titles = new ArrayList<>();
        List<WebElement> titlesElements = driver.findElements(By.xpath("//a[@class='ticket-title-id locked-link']//span"));
        for(WebElement titlesElement : titlesElements){
            titles.add(titlesElement.getText());
        }
        System.out.println(titles);
    }

    public void getAllAssignees(){
        List<String> assignees = new ArrayList<>();
        List<WebElement>assigneesElements = driver.findElements(By.xpath("//tr[@class='assigned-manager']//span"));
        for(WebElement assigneesElement : assigneesElements){
            assignees.add(assigneesElement.getText());
        }
        System.out.println(assignees);
    }

    public void getAllStages(){
        List<String> stages = new ArrayList<>();
        List<WebElement>stagesElements = driver.findElements(By.xpath("//*[@id='body']/app-root" +
                "/ticketshub-application/div[2]/div[3]/tickets/div/div/div/div/table/tbody/tr/td[7]/span"));
        for(WebElement stagesElement : stagesElements){
            stages.add(stagesElement.getText());
        }
        System.out.println(stages);
    }
}