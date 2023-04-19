package tests.Builder_Pattern;

import org.junit.jupiter.api.Test;
import pageobjects.Buider_Pattern.Department;
import pageobjects.Buider_Pattern.DepartmentBuilder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepartmentTest {
    @Test
    public void testUserBuilder() {
        Department department = new DepartmentBuilder()
                .withTitle("New Department")
                .withWebsite("Department.com")
                .withEmail("department@example.com")
                .withPhone("+1-555-555-5555")
                .withSkype("johndoe")
                .withCountry("England")
                .withCity("Wigan")
                .withStreet("Miller's lane")
                .withBuilding(99)
                .withZipcode("WN25DY")
                .withRoomNumber(25)
                .build();

        department.populate("New Department", "Department.com", "department@example.com", "+1-555-555-5555", "janedoe", "England", "Wigan", "Miller's lane",99, "WN25DY", 25);

        assertTrue(department.verify("New Department", "Department.com", "department@example.com", "+1-555-555-5555", "janedoe", "England", "Wigan", "Miller's lane", 99, "WN25DY", 25));
    }
}