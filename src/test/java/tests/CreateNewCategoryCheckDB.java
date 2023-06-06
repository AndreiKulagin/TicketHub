package tests;

import DataBase.DataBase;
import org.junit.jupiter.api.Test;
import pageobjects.CategoriesPage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewCategoryCheckDB extends BaseUiTest{
    @Test
    public void testCreateNewCategoryCheckDB() throws SQLException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        HashMap<String,String>categoryValues=categoriesPage.createNewCategory("Production","blue");
        DataBase database = new DataBase();
        List<Map<String, String>> categoryInformationQuery = database.executeQueryForList("SELECT name, color FROM category\n" +
                "WHERE name = 'Production';"+"\t\t");
        assertTrue(categoryValues.equals(categoryInformationQuery.get(0)));
    }
}