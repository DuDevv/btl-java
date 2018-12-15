package game;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static Scanner in = createScanner();
    private static Random random = new Random();

    private static Scanner createScanner() {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        return in;
    }

    public static String getInputString() {
        return getInputString(null);
    }

    public static String getInputString(String message) {
        if(stringNotNullOrEmpty(message)) {
            System.out.println(message);
        }
        return in.nextLine();
    }

    public static int getInputInteger() throws NumberFormatException {
        return getInputInteger(null);
    }

    public static int getInputInteger(String message) throws NumberFormatException{
        if(stringNotNullOrEmpty(message)) {
            System.out.println(message);
        }
        return Integer.parseInt(in.nextLine());
    }

    public static boolean stringNotNullOrEmpty(String s) {
        return s != null && s != "";
    }

    public static int clampNumber(int num, int min, int max) {
        return num < min ? min : num > max ? max : num;
    }

    public static int randomInt(int bound) {
        return random.nextInt(bound);
    }
}
