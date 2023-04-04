package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.ManagersPage;

import java.util.Map;

public class CreateNewManager extends BaseUiTest {

    @Test
    public void createNewManager()  {
        ManagersPage managersPage = new ManagersPage(driver);
        Map<String,String> generatedData = managersPage.createNewManager();
        Map<String,String> filedValues = managersPage.findManager();
        String combinedName =  generatedData.get("First name")+" " + generatedData.get("Last name");
        generatedData.put("Name",combinedName);
        generatedData.remove("First name");
        generatedData.remove("Last name");
        Assertions.assertEquals(generatedData,filedValues);
    }
}