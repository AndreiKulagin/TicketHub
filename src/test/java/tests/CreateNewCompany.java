package tests;

import org.junit.jupiter.api.Test;
import pageobjects.CompaniesPage;

public class CreateNewCompany extends BaseUiTest {

    @Test
    public void testCreateNewCompany() throws InterruptedException {
        logger.info("Starting testCreateNewCompany");
        CompaniesPage companiesPage = new CompaniesPage(driver);
        companiesPage.createNewCompany("Granit405");
        companiesPage.findCompany("Granit405");
        logger.info("Finished testCreateNewCompany");
    }
}