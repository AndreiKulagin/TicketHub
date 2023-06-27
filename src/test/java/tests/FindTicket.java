package tests;

import org.junit.jupiter.api.Test;
import pageobjects.TicketsPage;

public class FindTicket extends BaseUiTest{
    @Test
    public void testFindTicket() throws InterruptedException {
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.findTicket("Spider52");
    }
}
