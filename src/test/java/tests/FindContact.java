package tests;

import org.junit.jupiter.api.Test;
import pageobjects.ContactsPage;

public class FindContact extends BaseUiTest {

    @Test
    public void testFindContact() {
        logger.info("Starting testFindContact");
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.findContact();
        logger.info("Finished testFindContact");
    }
}