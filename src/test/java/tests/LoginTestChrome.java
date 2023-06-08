package tests;

import pageobjects.DashboardPage;
import pageobjects.TicketsPage;
import org.junit.jupiter.api.*;

public class LoginTestChrome extends BaseUiTest {

    @Test
    public void testLogin() throws InterruptedException {
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