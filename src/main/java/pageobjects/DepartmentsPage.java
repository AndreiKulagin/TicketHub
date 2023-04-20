package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DepartmentsPage {

    private WebDriver driver;

    @FindBy(id = "menu-departments")
    private WebElement departmentsMenu;

    @FindBy(id = "new-department")
    private WebElement newDepartmentButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputTitle;

    @FindBy(xpath = "//button[@id='department-form-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@id = 'department-form-additional-info']")
    private WebElement additionalInfoButton;

    @FindBy(xpath = "//input[@id = 'phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@id = 'skype']")
    private WebElement skypeInput;

    public DepartmentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DepartmentsPage(String title, String website, String email, String phone, String skype, String country, String city, String street, Integer building, String zipcode, Integer roomNumber) {

    }

    public static class Builder {
        private WebDriver driver;
        private String title;
        private String website;
        private String email;
        private String phone;
        private String skype;
        private String country;
        private String city;
        private String street;
        private Integer building;
        private String zipcode;
        private Integer roomNumber;

        public Builder(WebDriver driver) {
            this.driver = driver;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setWebsite(String website) {
            this.website = website;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setSkype(String skype) {
            this.skype = skype;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setBuilding(Integer building) {
            this.building = building;
            return this;
        }

        public Builder setZipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public Builder setRoomNumber(Integer roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public DepartmentsPage build() {
            DepartmentsPage departmentsPage = new DepartmentsPage(driver);
            departmentsPage.departmentsMenu.click();
            departmentsPage.newDepartmentButton.click();
            departmentsPage.inputTitle.click();
            departmentsPage.inputTitle.sendKeys(title);
            departmentsPage.additionalInfoButton.click();
            departmentsPage.phoneInput.click();
            departmentsPage.phoneInput.sendKeys(phone);
            departmentsPage.skypeInput.click();
            departmentsPage.skypeInput.sendKeys(skype);
            return departmentsPage;
        }
    }

        /*public void createNewDepartment(String titleName) {
            departmentsMenu.click();
            newDepartmentButton.click();
            DepartmentsPage departmentsPage = new DepartmentsPage.Builder(driver)
                    .setTitle("Andrei Kulagin")
                    .setWebsite("")
            inputTitle.sendKeys(titleName);
            additionalInfoButton.click();
            submitButton.click();
        }*/
    }
