package tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses({
        FindContact.class,
        EditContact.class,
        DeleteContact.class
})
public class ContactsPageTestSuite {
}