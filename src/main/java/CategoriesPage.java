import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class CategoriesPage{
    private WebDriver driver;

    @FindBy(id = "menu-categories")
    private WebElement categoriesMenu;

    public CategoriesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}