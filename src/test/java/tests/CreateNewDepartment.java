package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.DepartmentsPage;

public class CreateNewDepartment extends BaseUiTest{

    @Test
    public void testCreateNewDepartment(){

        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-signin")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='create-new-ticket']")));

        DepartmentsPage departmentsPage = new DepartmentsPage(driver);
        departmentsPage.createNewDepartment("Andrei Kulagin");
    }
}