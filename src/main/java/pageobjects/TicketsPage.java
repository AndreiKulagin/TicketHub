package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class TicketsPage {
    private WebDriver driver;

    @FindBy(id = "menu-tickets")
    private WebElement ticketsMenu;

    public TicketsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}