package pageobjects.Buider_Pattern;

public class Department {
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

    Department(String title, String website, String email, String phone, String skype, String country, String city, String street, Integer building, String zipcode, Integer roomNumber) {
        this.title = title;
        this.website = website;
        this.email = email;
        this.phone = phone;
        this.skype = skype;
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.zipcode = zipcode;
        this.roomNumber = roomNumber;
    }

    public void populate(String title, String website, String email, String phone, String skype, String country, String city, String street, Integer building, String zipcode, Integer roomNumber) {
        this.title = title;
        this.website = website;
        this.email = email;
        this.phone = phone;
        this.skype = skype;
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.zipcode = zipcode;
        this.roomNumber = roomNumber;
    }

    public boolean verify(String expectedTitle, String expectedWebsite, String expectedEmail, String expectedPhone, String expectedSkype, String expectedCountry, String expectedCity, String expectedStreet, Integer expectedBuilding, String expectedZipcode, Integer expectedRoomNumber) {
        return title.equals(expectedTitle) &&
                website.equals(expectedWebsite) &&
                email.equals(expectedEmail) &&
                phone.equals(expectedPhone) &&
                skype.equals(expectedSkype) &&
                country.equals(expectedCountry)&&
                city.equals(expectedCity)&&
                street.equals(expectedStreet)&&
                building.equals(expectedBuilding)&&
                zipcode.equals(expectedZipcode)&&
                roomNumber.equals(expectedRoomNumber);
    }
}