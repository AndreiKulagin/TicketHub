package tests;

import org.junit.jupiter.api.Test;
import pageobjects.CompaniesPage;
import pageobjects.Strategy_Pattern.CompaniesNewButtonClickStrategy;

public class CreateNewCompany extends BaseUiTest {

    @Test
    public void testCreateNewCompany(){
        CompaniesPage companiesPage = new CompaniesPage(driver,new CompaniesNewButtonClickStrategy());
        companiesPage.createNewCompany("Kulagin");
    }
}