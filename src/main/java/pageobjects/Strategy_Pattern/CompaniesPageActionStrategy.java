package pageobjects.Strategy_Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompaniesPageActionStrategy implements PageActionStrategy{
    public void performAction(WebDriver driver){
        driver.findElement(By.id("new-company")).click();
    }
}