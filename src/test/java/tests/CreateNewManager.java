package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.ManagersPage;

public class CreateNewManager extends BaseUiTest {

    @Test
    public void createNewManager(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='create-new-ticket']")));
        ManagersPage managersPage = new ManagersPage(driver);
        managersPage.createNewManager();
        managersPage.findManager();
    }
}