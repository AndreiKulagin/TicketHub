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
    public void createNewManagerCheckDB() throws SQLException, InterruptedException {
        ManagersPage managersPage = new ManagersPage(driver);
        Manager manager = new Manager(driver);
        Map<String, String> generatedManager = manager.getManager("Artur555","Spartak555");
        DataBase database = new DataBase();
        List<Map<String, String>> managerInformationQuery = database.executeQueryForList("SELECT CONCAT(first_name,' ',last_name) AS name, phone, skype\n" +
                "FROM manager\n" +
                "WHERE first_name = 'Artur555' AND last_name = 'Spartak555';"+"\t\t");
        Map<String, String> filedValues = managersPage.findManager((generatedManager));
        assertTrue(filedValues.equals(managerInformationQuery.get(0)));
    }
}