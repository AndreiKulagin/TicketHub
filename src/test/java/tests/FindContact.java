package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.ContactsPage;

public class FindContact extends BaseUiTest {

    @Test
    public void findContact(){
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.findContact();
    }
}