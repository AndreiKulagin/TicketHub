package tests;

import DataBase.DataBase;
import model.Manager;
import org.junit.jupiter.api.Test;
import pageobjects.ManagersPage;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewManagerCheckDB extends BaseUiTest {

    @Test
    public void testCreateNewManagerCheckDB() throws SQLException, InterruptedException {
        logger.info("Starting testCreateNewManagerCheckDB");
        ManagersPage managersPage = new ManagersPage(driver);
        Manager manager = new Manager(driver);
        logger.info("Fetching manager information from the page");
        Map<String, String> generatedManager = manager.getManager("Thetford", "Peckham");
        logger.info("Fetching manager information from the database");
        DataBase database = new DataBase();
        List<Map<String, String>> managerInformationQuery = database.executeQueryForList("SELECT CONCAT(first_name,' ',last_name) AS name, phone, skype\n" +
                "FROM manager\n" +
                "WHERE first_name = 'Thetford' AND last_name = 'Peckham';" + "\t\t");
        Map<String, String> filedValues = managersPage.findManager((generatedManager));
        assertTrue(filedValues.equals(managerInformationQuery.get(0)));
        logger.info("Finished testCreateNewManagerCheckDB");
    }
}