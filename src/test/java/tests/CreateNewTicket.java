package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.TicketsPage;

public class CreateNewTicket extends BaseUiTest{

    @Test
    public void testCreateNewTicket()throws InterruptedException{
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-signin")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='create-new-ticket']")));

        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.createNewTicket("Andrei Kulagins","Test");
    }
}