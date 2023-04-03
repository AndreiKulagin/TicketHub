package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.ManagersPage;

import java.util.Map;

public class CreateNewManager extends BaseUiTest {

    @Test
    public void createNewManager()  {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='create-new-ticket']")));
        ManagersPage managersPage = new ManagersPage(driver);
        Map<String,String> generatedData = managersPage.createNewManager();
        Map<String,String> filedValues = managersPage.findManager();
        generatedData.remove("First name");
        generatedData.remove("Last name");
        Assertions.assertEquals(generatedData,filedValues);
    }
}