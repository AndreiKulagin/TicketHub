package tests;

import DataBase.DataBase;
import org.junit.jupiter.api.Test;
import pageobjects.TicketsPage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditTicket extends BaseUiTest{
    @Test
    public void testEditTicket() throws InterruptedException, SQLException {
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.findTicket("Spider52");
        DataBase database = new DataBase();
        List<Map<String, String>> ticketInformationQuery = database.executeQueryForList("SELECT title, description FROM Ticket\n" +
                "WHERE title = 'Arnold';" + "\t\t");
        HashMap<String, String> ticketFieldValue = ticketsPage.editTicket("Arnold","Arn");
        assertTrue(ticketFieldValue.equals(ticketInformationQuery.get(0)));
    }
}
