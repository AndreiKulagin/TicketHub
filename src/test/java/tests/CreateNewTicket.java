package tests;

import org.junit.jupiter.api.Test;
import pageobjects.TicketsPage;

public class CreateNewTicket extends BaseUiTest {

    @Test
    public void testCreateNewTicket() throws InterruptedException {
        logger.info("Starting testCreateNewTicket");
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.createNewTicket("Samokat15", "RedBull", "Tania", "Managers", "YouTube", "OPEN");
        logger.info("Finished testCreateNewTicket");
    }
}