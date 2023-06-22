package tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        CreateNewCategoryCheckDB.class,
        CreateNewCompany.class,
        CreateNewCompanyCheckDB.class,
        CreateNewDepartment.class,
        CreateNewInnerTicketCheckDB.class,
        CreateNewManager.class,
        CreateNewManagerCheckDB.class,
        CreateNewTicket.class,
        CreateNewTicketCheckDB.class,
        FindContact.class,
        NegativeCreateNewContact.class
})
public class TestSuite {
}
