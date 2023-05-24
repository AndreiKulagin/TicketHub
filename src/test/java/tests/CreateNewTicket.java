package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.TicketsPage;

public class CreateNewTicket extends BaseUiTest{

    @Test
    public void testCreateNewTicket(){
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.createNewTicket("Andrei Kulagins","Test");
    }
}