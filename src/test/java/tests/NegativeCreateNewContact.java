package tests;

import org.junit.jupiter.api.Test;
import pageobjects.ContactsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class NegativeCreateNewContact extends BaseUiTest {
    @Test
    public void testEmailMustBeValidError() {
        ContactsPage contactsPage = new ContactsPage(driver);
        String actualAlertValue = contactsPage.createNewContact("Andrei","abc","Kulagin","kullagin97@gmail.com","kullag");
        assertTrue(actualAlertValue.equals("Email must be valid"));
    }

    @Test
    public void testEmailIsRequiredError() {
        ContactsPage contactsPage = new ContactsPage(driver);
        String actualAlertValue = contactsPage.createNewContact("Andrei","","Kulagin","kullagin97@gmail.com","kullag");
        assertTrue(actualAlertValue.equals("Email is required\n" + "Email must be valid"));
    }

    @Test
    public void testInvalidTicketPrefix() {
        ContactsPage contactsPage = new ContactsPage(driver);
        String actualAlertValue = contactsPage.createNewContact("Andrei","kullagin97@gmail.com","Kulagin","kullagin97@gmail.com","k");
        assertTrue(actualAlertValue.equals("Tickets prefix must be from 3 to 6 characters long"));
    }

    @Test
    public void testLoginLengthError() {
        ContactsPage contactsPage = new ContactsPage(driver);
        String actualAlertValue = contactsPage.createNewContact("Andrei","kullagin97@gmail.com","Kulagin","ddd","kullag");
        assertTrue(actualAlertValue.equals("Login must be at least 4 characters long"));
    }

    @Test
    public void testLastNameLengthError() {
        ContactsPage contactsPage = new ContactsPage(driver);
        String actualAlertValue = contactsPage.createNewContact("Andrei","kullagin97@gmail.com","K","kullagin97@gmail.com","kullag");
        assertTrue(actualAlertValue.equals("Last name must be at least 2 characters long."));
    }
}