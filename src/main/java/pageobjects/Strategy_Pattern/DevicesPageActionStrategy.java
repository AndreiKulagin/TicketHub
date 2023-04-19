package pageobjects.Strategy_Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DevicesPageActionStrategy implements PageActionStrategy{
    public void performAction(WebDriver driver){
        driver.findElement(By.xpath("//button[@id = 'device-list-new-device']")).click();
    }
}
