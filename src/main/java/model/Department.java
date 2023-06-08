package model;

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

    public String getTitle() {
        return title;
    }

    public String getWebsite() {
        return website;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getSkype() {
        return skype;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getBuilding() {
        return building;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Department(String title, String website, String email, String phone, String skype, String country, String city, String street, Integer building, String zipcode, Integer roomNumber) {
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

    public static class Builder {
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

        public Builder() {
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

        public Department build() {
            return new Department(title, website, email, phone, skype, country, city, street, building, zipcode, roomNumber);
        }
    }
}