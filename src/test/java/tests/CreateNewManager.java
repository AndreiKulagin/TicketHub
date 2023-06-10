package tests;

import model.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.ManagersPage;

import java.util.Map;

public class CreateNewManager extends BaseUiTest {

    @Test
    public void testCreateNewManager() throws InterruptedException {
        logger.info("Starting testCreateNewManager");
        ManagersPage managersPage = new ManagersPage(driver);
        Manager manager = new Manager(driver);
        Map<String, String> generatedManager = manager.getManager("Arnolds", "tWister");
        Map<String, String> filedValues = managersPage.findManager((generatedManager));
        String combinedName = generatedManager.get("first_name") + " " + generatedManager.get("last_name");
        generatedManager.put("name", combinedName);
        generatedManager.remove("first_name");
        generatedManager.remove("last_name");
        Assertions.assertEquals(generatedManager, filedValues);
        logger.info("Finished testCreateNewManager");
    }
}