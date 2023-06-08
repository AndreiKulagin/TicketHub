package utils;

import java.util.Random;

public class BooleanUtils {

    public static boolean generateRandomBoolean() {
        Random rnd = new Random();
        return rnd.nextBoolean();
    }
}