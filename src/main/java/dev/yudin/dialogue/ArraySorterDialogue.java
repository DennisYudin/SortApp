package dev.yudin.dialogue;

import dev.yudin.arraysorter.ArraySorter;
import dev.yudin.arraysorter.Sorter;
import dev.yudin.console.Console;

import java.util.Scanner;

public class ArraySorterDialogue implements Dialogue {
    private static final String GREETING_MESSAGE = "MergeSortApp machine greetings to you!";
    private static final String NOTES_MESSAGE = "Enter numbers for sort: ";
    private static final String REPEAT_MESSAGE = "Do you wanna to try again? [yes/no]";
    private static final String USER_ANSWER = "Answer: ";
    private static final String CONTINUE_ANSWER = "yes";

    private Console console = new Console();
    private Sorter sorter = new ArraySorter();

    @Override
    public void start(Scanner scanner) {
        String userAnswer;
        do {
            System.out.println(GREETING_MESSAGE);

            int[] numbers = console.readNumbers(NOTES_MESSAGE, scanner);

            sorter.mergeSort(numbers);

            printResult(numbers);

            userAnswer = tryAgain(scanner);
        } while (CONTINUE_ANSWER.equals(userAnswer));
    }

    private String tryAgain(Scanner scanner) {
        System.out.println(REPEAT_MESSAGE);
        System.out.print(USER_ANSWER);

        String answer = scanner.nextLine().toLowerCase();
        System.out.println();

        return answer;
    }

    static void printResult(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }
}
