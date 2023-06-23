package tests;

import org.junit.jupiter.api.Test;
import pageobjects.ContactsPage;

public class EditContact extends BaseUiTest{

    @Test
    public void testEditContact(){
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.findContact("Arnold","Arnold");
        contactsPage.editContact("Manro","Min");
    }
}
