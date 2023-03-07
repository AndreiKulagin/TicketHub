import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class ContactsPage{
    private WebDriver driver;

    @FindBy(id = "menu-contacts")
    private WebElement contactsMenu;
    @FindBy(xpath = "//button[@id='new-contact']")
    private WebElement newContact;

    public ContactsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}