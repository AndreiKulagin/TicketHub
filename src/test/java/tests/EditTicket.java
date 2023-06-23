package tests;

import org.junit.jupiter.api.Test;
import pageobjects.TicketsPage;

public class EditTicket extends BaseUiTest{
    @Test
    public void testEditTicket() throws InterruptedException {
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.findTicket("Spider52");
        ticketsPage.editTicket("Arnold","Arn");

    }
}
