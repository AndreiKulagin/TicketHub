package tests;

import org.junit.jupiter.api.Test;
import pageobjects.ContactsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NegativeCreateNewContact extends BaseUiTest {
    @Test
    public void testEmailMustBeValidError() {
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setTicketsEmail("abc");
        String actualAlertValue = contactsPage.getAlertMessageValue();
        assertEquals("Email must be valid", actualAlertValue);
    }

    @Test
    public void testEmailIsRequiredError() {
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setTicketsEmail("");
        String actualAlertValue = contactsPage.getAlertMessageValue();
        assertEquals("Email is required\n" + "Email must be valid", actualAlertValue);
    }

    @Test
    public void testInvalidTicketPrefix() {
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setTicketPrefix("k");
        String actualAlertValue = contactsPage.getAlertMessageValue();
        assertEquals("Tickets prefix must be from 3 to 6 characters long",actualAlertValue);
    }

    @Test
    public void testLoginLengthError() {
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setTicketLogin("ddd");
        String actualAlertValue = contactsPage.getAlertMessageValue();
        assertEquals("Login must be at least 4 characters long", actualAlertValue);
    }

    @Test
    public void testLastNameLengthError() {
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setTicketLastName("K");
        String actualAlertValue = contactsPage.getAlertMessageValue();
        assertEquals("Last name must be at least 2 characters long.", actualAlertValue);
    }
}