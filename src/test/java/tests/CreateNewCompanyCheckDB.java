package tests;

import DataBase.DataBase;
import org.junit.jupiter.api.Test;
import pageobjects.CompaniesPage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewCompanyCheckDB extends BaseUiTest {

    @Test
    public void testCreateNewCompanyCheckDB() throws InterruptedException, SQLException {
        logger.info("Starting testCreateNewCompanyCheckDB");
        CompaniesPage companiesPage = new CompaniesPage(driver);
        companiesPage.createNewCompany("Mazda3");
        companiesPage.findCompany("Mazda3");
        logger.info("Fetching company information from the page");
        HashMap<String, String> companyValues = companiesPage.getAllInformationAboutCompany();
        logger.info("Fetching company information from the database");
        DataBase database = new DataBase();
        List<Map<String, String>> companyInformationQuery = database.executeQueryForList("SELECT name, ticket_prefix FROM company\n" +
                "WHERE name = 'Mazda3';" + "\t\t");
        assertTrue(companyValues.equals(companyInformationQuery.get(0)));
    }
}