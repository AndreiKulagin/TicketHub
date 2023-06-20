package tests;

import model.Department;
import org.junit.jupiter.api.Test;
import pageobjects.DepartmentsPage;

public class CreateNewDepartment extends BaseUiTest {

    @Test
    public void testCreateNewDepartment() {
        logger.info("Starting testCreateNewDepartment");
        Department department = new Department.Builder()
                .setTitle("Relation Television016")
                .setPhone("1284167190")
                .setSkype("new_department_skype")
                .setWebsite("qa.com")
                .setEmail("kullagin976@gmail.com")
                .setCountry("England")
                .setCity("Wigan")
                .build();
        new DepartmentsPage(driver).createNewDepartment(department);
        logger.info("Finished testCreateNewDepartment");
    }
}