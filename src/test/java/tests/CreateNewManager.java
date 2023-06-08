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
        Map<String, String> generatedManager = manager.getManager("Andrei", "Grigoshvili");
        Map<String, String> filedValues = managersPage.findManager((generatedManager));
        String combinedName = generatedManager.get("First name") + " " + generatedManager.get("Last name");
        generatedManager.put("Name", combinedName);
        generatedManager.remove("First name");
        generatedManager.remove("Last name");
        Assertions.assertEquals(generatedManager, filedValues);
        logger.info("Finished testCreateNewManager");
    }
}