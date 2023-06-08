package pageobjects.Strategy_Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TicketsNewButtonClickStrategy implements NewButtonClickStrategy {
    public void newButtonClick(WebDriver driver) {
        driver.findElement(By.xpath("//button[@id='create-new-ticket']")).click();
    }
}