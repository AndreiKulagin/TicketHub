package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.DepartmentsPage;

public class CreateNewDepartment extends BaseUiTest{

    @Test
    public void testCreateNewDepartment(){
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='create-new-ticket']")));

        DepartmentsPage.Builder builder = new DepartmentsPage.Builder(driver)
                .setTitle("Andrei Kulagin25")
                .setPhone("1234567890")
                .setSkype("new_department_skype");

        DepartmentsPage departmentsPage = builder.build();
        departmentsPage.createNewDepartment();

    }
}