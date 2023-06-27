package tests;

import org.junit.jupiter.api.Test;
import pageobjects.ContactsPage;

public class DeleteContact extends BaseUiTest{
    @Test
    public void testDeleteContact(){
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.findContact("Manro","Min");
        contactsPage.deleteContact();
    }
}
