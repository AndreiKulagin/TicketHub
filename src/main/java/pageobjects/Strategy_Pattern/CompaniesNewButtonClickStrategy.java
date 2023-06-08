package pageobjects.Strategy_Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompaniesNewButtonClickStrategy implements NewButtonClickStrategy {
    public void newButtonClick(WebDriver driver) {
        driver.findElement(By.id("new-company")).click();
    }
}