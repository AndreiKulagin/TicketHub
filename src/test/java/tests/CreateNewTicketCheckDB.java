package tests;

import DataBase.DataBase;
import org.junit.jupiter.api.Test;
import pageobjects.TicketsPage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewTicketCheckDB extends BaseUiTest {
    @Test
    public void testCreateNewTicketWithDB() throws InterruptedException, SQLException {
        logger.info("Starting testCreateNewTicketWithDB");
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.createNewTicket("breakfast7420", "break", "Tania", "Managers", "YouTube", "OPEN");
        ticketsPage.findTicket("breakfast7420");
        logger.info("Fetching ticket information from the page");
        HashMap<String, String> ticketValues = ticketsPage.getAllInformationAboutTicket("OPEN", "breakfast7420");
        logger.info("Fetching ticket information from the database");
        DataBase database = new DataBase();
        List<Map<String, String>> TicketInformationQuery = database.executeQueryForList("SELECT t.title, t.description, t.priority, s.name AS stage, c.name AS category, CONCAT(con.first_name,' ',con.last_name) AS contact, com.name AS company\n" +
                "FROM ticket t\n" +
                "JOIN stage s ON t.stage_id = s.id\n" +
                "JOIN category c ON t.category_id=c.id\n" +
                "JOIN contact con ON t.contact_id=con.id\n" +
                "JOIN company com ON t.company_ticket_id = com.max_ticket_id\n" +
                "WHERE t.title = 'breakfast7420';" + "\t\t");
        assertTrue(ticketValues.equals(TicketInformationQuery.get(0)));
    }
}