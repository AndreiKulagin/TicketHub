package utils;

import java.util.Random;

public class NumberUtils {

    public static int generateRandomInt(int min, int max) {
        Random rnd = new Random();
        return rnd.nextInt(max - min + 1) + min;
    }

    public static double generateRandomDouble(double min, double max) {
        Random rnd = new Random();
        return min + (max - min) * rnd.nextDouble();
    }
}