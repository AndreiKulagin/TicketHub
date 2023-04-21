package tests;

import model.Department;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.DepartmentsPage;

public class CreateNewDepartment extends BaseUiTest{

    @Test
    public void testCreateNewDepartment(){
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='create-new-ticket']")));

      Department department = new Department.Builder()
              .setTitle("Andrei Kulagin555")
              .setPhone("1234567890")
              .setSkype("new_department_skype")
              .setWebsite("qa.com")
              .setEmail("kullagin966@gmail.com")
              .setCountry("England")
              .setCity("Wigan")
              .build();
      new DepartmentsPage(driver).createNewDepartment(department);

    }
}