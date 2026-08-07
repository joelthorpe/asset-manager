package com.joelthorpe.assetmanager;

import java.util.Scanner;

/**
 * Utility class for reading and validating console input.
 */
public class InputUtils {
    // Private constructor to prevent instantiation of utility class
    private InputUtils() {}

    /**
     * Prompts the user until a valid integer is entered.
     */
    public static int readInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String rawInput = input.nextLine().trim();
            try {
                return Integer.parseInt(rawInput);
            } catch (NumberFormatException ex) {
                System.out.println("Error: Invalid number. Please enter a valid integer.");
            }
        }
    }

    /**
     *  Prompts the user until a valid non-empty string is entered.
     */
    public static String readString(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String rawInput = input.nextLine().trim();
            if (!rawInput.isEmpty()) {
                return rawInput;
            }
            System.out.println("Error: Input cannot be empty. Please try again.");
        }
    }

    /**
     *  Prompts the user until either 'true' or 'false' is entered.
     */
    public static boolean readBoolean(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String rawInput = input.nextLine().trim().toLowerCase();
            if (rawInput.equals("true") || rawInput.equals("false")) {
                return Boolean.parseBoolean(rawInput);
            }
            System.out.println("Error: Please enter either 'true' or 'false'.");
        }
    }

}
