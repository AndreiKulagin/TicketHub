package pageobjects.Buider_Pattern;

public class DepartmentBuilder {
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

    public DepartmentBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public DepartmentBuilder withWebsite(String website) {
        this.website = website;
        return this;
    }

    public DepartmentBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public DepartmentBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public DepartmentBuilder withSkype(String skype) {
        this.skype = skype;
        return this;
    }

    public DepartmentBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public DepartmentBuilder withCity(String city){
        this.city = city;
        return this;
    }

    public DepartmentBuilder withStreet(String street){
        this.street = street;
        return this;
    }

    public DepartmentBuilder withBuilding(Integer building){
        this.building = building;
        return this;
    }

    public DepartmentBuilder withZipcode(String zipcode){
        this.zipcode = zipcode;
        return this;
    }

    public DepartmentBuilder withRoomNumber(Integer roomNumber){
        this.roomNumber = roomNumber;
        return this;
    }

    public Department build() {
        return new Department(title, website, email, phone, skype, country, city, street, building, zipcode, roomNumber);
    }
}