package model;

import com.github.javafaker.Faker;
import utils.StringUtils;

public class Manager {

    Faker faker = new Faker();

    public String generateFirstName(){
        String generatedFirstName = faker.name().firstName();
        return generatedFirstName;
    }

    public String generateLastName() {
        String generatedLastName = faker.name().lastName();
        return generatedLastName;
    }
        public String generateEmail(){
            StringUtils stringUtils = new StringUtils();
            String generatedEmail = stringUtils.generateRandomString(12);
            return generatedEmail;
        }

        public String generateSkype(){
        String generatedSkype = faker.lorem().characters(10);
        return generatedSkype;
        }

        public String generatePhone(){
        String generatedPhoneNumber = faker.phoneNumber().cellPhone();
        return generatedPhoneNumber;
        }
    }