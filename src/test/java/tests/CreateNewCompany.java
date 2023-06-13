package tests;

import org.junit.jupiter.api.Test;
import pageobjects.CompaniesPage;

public class CreateNewCompany extends BaseUiTest {

    @Test
    public void testCreateNewCompany() throws InterruptedException {
        logger.info("Starting testCreateNewCompany");
        CompaniesPage companiesPage = new CompaniesPage(driver);
        companiesPage.createNewCompany("Opel25");
        companiesPage.findCompany("Opel25");
        logger.info("Finished testCreateNewCompany");
    }
}