package tests;

import DataBase.DataBase;
import org.junit.jupiter.api.Test;
import pageobjects.ContactsPage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditContact extends BaseUiTest{

    @Test
    public void testEditContact() throws SQLException {
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.findContact("Arnold","Arnold");
        DataBase database = new DataBase();
        List<Map<String, String>> contactInformationQuery = database.executeQueryForList("SELECT * FROM Contact\n" +
                "WHERE first_name = 'Manro' AND last_name = 'Min';" + "\t\t");
        HashMap<String,String> fieldValues = contactsPage.editContact("Manro","Min");
        assertTrue(fieldValues.equals(contactInformationQuery.get(0)));
    }
}