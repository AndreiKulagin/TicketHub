package tests;

import DataBase.DataBase;
import org.junit.jupiter.api.Test;
import pageobjects.CompaniesPage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewCompanyCheckDB extends BaseUiTest{

    @Test
    public void createNewCompanyCheckDB() throws InterruptedException, SQLException {
        CompaniesPage companiesPage = new CompaniesPage(driver);
        companiesPage.createNewCompany("BazanovAlex3535");
        companiesPage.findCompany("BazanovAlex3535");
        HashMap<String, String> companyValues = companiesPage.getAllInformationAboutCompany();
        DataBase database = new DataBase();
        List<Map<String, String>> companyInformationQuery = database.executeQueryForList("SELECT name, ticket_prefix FROM company\n" +
                "WHERE name = 'BazanovAlex3535';"+"\t\t");
        assertTrue(companyValues.equals(companyInformationQuery.get(0)));
    }
}