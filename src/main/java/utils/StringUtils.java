package utils;

import java.util.Random;

public class StringUtils {

    public String generateRandomString(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < length) {
            int index = (int) (rnd.nextFloat() * allowedChars.length());
            sb.append(allowedChars.charAt(index));
        }
        return sb+"@example.com";
    }
}