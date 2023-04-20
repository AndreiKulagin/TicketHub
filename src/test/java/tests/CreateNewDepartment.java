package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.DepartmentsPage;

public class CreateNewDepartment extends BaseUiTest{

    @Test
    public void testCreateNewDepartment(){
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='create-new-ticket']")));
      DepartmentsPage departmentsPage = new DepartmentsPage.Builder(driver)
              .setTitle("Andrei Kulagin97")
              .setPhone("55555")
              .setSkype("kullagin@skype")
              .build();
    }
}