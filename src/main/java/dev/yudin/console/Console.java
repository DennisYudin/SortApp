package dev.yudin.console;

import java.util.Scanner;

public class Console {
    private static final String SEPARATOR = ",";
    private static final String REPLACEMENT_SYMBOL = "";
    private static final String INPUT_NULL_MESSAGE = "Input cannot be null";
    private static final String INPUT_EMPTY_MESSAGE = "Input cannot be empty";
    private static final String INCORRECT_INPUT_MESSAGE = "Incorrect input. ";
    private static final String DIGITS_REGEX = "^-?\\d+$";
    private static final String IS_INPUT_NUMBER_MESSAGE = "Input can be only numbers";

    public int[] readNumbers(String prompt, Scanner scanner) {
        boolean isGoodInput = false;
        int[] numbers = null;
        do {
            System.out.print(prompt);

            String userInput = scanner.nextLine();
            try {
                numbers = getNumbers(userInput);
                isGoodInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println(INCORRECT_INPUT_MESSAGE + ex.getMessage());
            }
        } while (!isGoodInput);

        return numbers;
    }

    private int[] getNumbers(String input) {

        validateByNullOrEmpty(input);

        String inputWithoutSpaces = input.replaceAll("\\s", REPLACEMENT_SYMBOL);

        String[] numbersStringArray = inputWithoutSpaces.split(SEPARATOR);

        int[] numbers = convertToIntArray(numbersStringArray);

        return numbers;
    }

    private int[] convertToIntArray(String[] input) {
        int arrayLength = input.length;
        int[] result = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            String number = input[i];

            validateIfDigit(number);

            result[i] = Integer.parseInt(number);
        }
        return result;
    }

    private void validateIfDigit(String input) {
        if (!input.matches(DIGITS_REGEX)) {
            throw new IllegalArgumentException(IS_INPUT_NUMBER_MESSAGE);
        }
    }

    private void validateByNullOrEmpty(String input) {
        if (input == null)
            throw new IllegalArgumentException(INPUT_NULL_MESSAGE);
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_EMPTY_MESSAGE);
        }
    }
}
