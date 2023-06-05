package tests;
import DataBase.DataBase;
import org.junit.jupiter.api.Test;
import pageobjects.TicketsPage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateNewTicketCheckDB extends BaseUiTest{
    @Test
    public void testCreateNewTicketWithDB() throws InterruptedException, SQLException {
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.createNewTicket("Samokat15","RedBull","Tania","Managers","YouTube","OPEN");
        ticketsPage.findTicket("Samokat15");
        HashMap<String, String> ticketValues = ticketsPage.getAllInformationAboutTicket("OPEN", "Samokat15");
        DataBase database = new DataBase();
        List<Map<String, String>> TicketInformationQuery = database.executeQueryForList("SELECT t.title, t.description, t.priority, s.name AS stage, c.name AS category, CONCAT(con.first_name,' ',con.last_name) AS contact, com.name AS company\n" +
                "FROM ticket t\n" +
                "JOIN stage s ON t.stage_id = s.id\n" +
                "JOIN category c ON t.category_id=c.id\n" +
                "JOIN contact con ON t.contact_id=con.id\n" +
                "JOIN company com ON t.company_ticket_id = com.max_ticket_id\n" +
                "WHERE t.title = 'Samokat15';"+"\t\t");
        boolean isEqual = ticketValues.equals(TicketInformationQuery.get(0));
        assertEquals(true,isEqual);
    }
}
