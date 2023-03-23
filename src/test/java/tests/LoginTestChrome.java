package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.DashboardPage;
import pageobjects.TicketsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

public class LoginTestChrome extends BaseUiTest{

    @Test
    public void testLogin() throws InterruptedException {

        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-signin")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='create-new-ticket']")));

        TicketsPage ticketsPage = new TicketsPage(driver);

        ticketsPage.getAllIds("Id");
        ticketsPage.getAllTitles("Title");
        ticketsPage.getAllAssignees("Assignee");
        ticketsPage.getAllStages("Stage");

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.getAllTitlesWithCategoryDevelopment();
        dashboardPage.getAllTitlesWithCategoryFinance();
        dashboardPage.getAllIdsWithPriorityP3();
    }
}