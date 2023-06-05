package tests;

import org.junit.jupiter.api.Test;
import pageobjects.TicketsPage;

public class CreateNewTicket extends BaseUiTest{

    @Test
    public void testCreateNewTicket() throws InterruptedException {
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.createNewTicket("Samokat15","RedBull","Tania","Managers","YouTube","OPEN");
    }
}