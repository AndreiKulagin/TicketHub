package tests;

import DataBase.DataBase;
import org.junit.jupiter.api.Test;
import pageobjects.TicketsPage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewInnerTicketCheckDB extends BaseUiTest {
    @Test
    public void testCreateNewInnerTicketWithDB() throws InterruptedException, SQLException {
        logger.info("Starting testCreateNewInnerTicketWithDB");
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.createNewInnerTicket("ManchesterUnited", "MU", "Call Center", "Events");
        ticketsPage.findTicket("ManchesterUnited");
        logger.info("Fetching ticket information from the page");
        HashMap<String, String> innerTicketValues = ticketsPage.getAllInformationAboutInnerTicket("IN PROGRESS", "ManchesterUnited");
        logger.info("Fetching ticket information from the database");
        DataBase database = new DataBase();
        List<Map<String, String>> innerTicketInformationQuery = database.executeQueryForList("SELECT t.title, t.description, s.name AS stage, c.name AS category\n" +
                "FROM ticket t\n" +
                "JOIN stage s ON t.stage_id = s.id\n" +
                "JOIN category c ON t.category_id=c.id\n" +
                "WHERE t.title = 'ManchesterUnited';" + "\t\t");
        assertTrue(innerTicketValues.equals(innerTicketInformationQuery.get(0)));
    }
}