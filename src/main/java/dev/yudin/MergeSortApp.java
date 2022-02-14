package dev.yudin;

import dev.yudin.dialogue.ArraySorterDialogue;
import dev.yudin.dialogue.Dialogue;

import java.util.Scanner;

public class MergeSortApp {
    public static void main(String[] args) {

        Dialogue arraySortDialogue = new ArraySorterDialogue();

        try (Scanner scanner = new Scanner(System.in)) {

            try {
                arraySortDialogue.start(scanner);
            } catch (IllegalArgumentException exception) {
                System.err.println(exception.getMessage());
            }
        }
    }
}
