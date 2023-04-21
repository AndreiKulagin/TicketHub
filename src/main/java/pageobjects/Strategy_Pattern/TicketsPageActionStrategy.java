package pageobjects.Strategy_Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TicketsPageActionStrategy implements PageActionStrategy {
    public void performAction(WebDriver driver){
        driver.findElement(By.xpath("//button[@id='create-new-ticket']")).click();
    }
}