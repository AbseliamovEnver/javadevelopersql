package com.abseliamov.cinema.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class IOUtil {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static long getValidLongInputData(String message) {
        System.out.println(message);
        Long inputData = null;
        String input;
        try {
            while ((input = getReader().readLine()) != null) {
                if (!StringUtils.isNumeric(input) || Long.parseLong(input) < 0) {
                    System.out.println("Please enter a correct number:");
                } else {
                    inputData = Long.parseLong(input);
                    break;
                }
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error reading input data from console " + e);
        }
        return inputData;
    }

    public static String readString(String message) {
        System.out.println(message);
        String data = null;
        try {
            data = getReader().readLine();
        } catch (IOException e) {
            System.out.println("Error read from console " + e);
        }
        return data;
    }

    public static long readNumber(String message) {
        System.out.println(message);
        long number = -1;
        do {
            try {
                number = Long.parseLong(getReader().readLine());
                if (number < 0) {
                    System.out.println("Enter a number greater than \'0\' or \'0\' to return: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect number. " + e);
                System.out.println("Enter correct number or \'0\' for return: ");
            } catch (IOException e) {
                System.out.println("Error read from console " + e);
            }
        } while (number < 0);
        return number;
    }

    private static BufferedReader getReader() {
        return reader;
    }

    public static <T> void printMenuHeader(List<T> header) {
        if (header != null) {
            header.forEach(System.out::println);
        }
    }

    public static <T> void printMenuItem(List<T> menu) {

        if (menu != null) {
            System.out.println("*********************************");
            for (int i = 0; i < menu.size(); i++) {
                if (i == 0) {
                    System.out.println("\t" + menu.get(i) + "\n*********************************");
                    continue;
                }
                if (i == menu.size() - 1) {
                    System.out.println(0 + ". " + menu.get(i)
                            + "\n*********************************");
                } else {
                    System.out.println(i + ". " + menu.get(i));
                }
            }
        }
    }

    public static boolean validateNumberSize(long min, long max) {
        return min >= 0 && min <= (max - 2);
    }
}
