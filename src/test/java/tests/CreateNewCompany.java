package tests;

import org.junit.jupiter.api.Test;
import pageobjects.CompaniesPage;

public class CreateNewCompany extends BaseUiTest {

    @Test
    public void testCreateNewCompany(){

        logIn();
        CompaniesPage companiesPage = new CompaniesPage(driver);
        companiesPage.createNewCompany("Kulagin");
    }
}