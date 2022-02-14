package dev.yudin.arraysorter;

public class ArraySorter implements Sorter {
    private static final int MIN_LENGTH_OF_ARRAY = 2;
    private static final int DIVIDER = 2;
    private static final String INPUT_NULL_MESSAGE = "Input is null";

    @Override
    public void mergeSort(int[] inputArray) {
        if (inputArray == null) {
            throw new IllegalArgumentException(INPUT_NULL_MESSAGE);
        }

        int inputLength = inputArray.length;

        if (inputLength < MIN_LENGTH_OF_ARRAY) {
            return;
        }
        int middlePointer = inputLength / DIVIDER;
        int[] leftHalfArray = new int[middlePointer];
        int[] rightHalfArray = new int[inputLength - middlePointer];

        for (int i = 0; i < middlePointer; i++) {
            leftHalfArray[i] = inputArray[i];
        }
        for (int i = middlePointer; i < inputLength; i++) {
            rightHalfArray[i - middlePointer] = inputArray[i];
        }
        mergeSort(leftHalfArray);
        mergeSort(rightHalfArray);

        merge(inputArray, leftHalfArray, rightHalfArray);
    }

    private void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {

        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int leftArrayPointer = 0;
        int rightArrayPointer = 0;
        int mergedArrayPointer = 0;

        while (leftArrayPointer < leftSize && rightArrayPointer < rightSize) {
            if (leftHalf[leftArrayPointer] <= rightHalf[rightArrayPointer]) {
                inputArray[mergedArrayPointer] = leftHalf[leftArrayPointer];
                leftArrayPointer++;
            } else {
                inputArray[mergedArrayPointer] = rightHalf[rightArrayPointer];
                rightArrayPointer++;
            }
            mergedArrayPointer++;
        }
        while (leftArrayPointer < leftSize) {
            inputArray[mergedArrayPointer] = leftHalf[leftArrayPointer];
            leftArrayPointer++;
            mergedArrayPointer++;
        }
        while (rightArrayPointer < rightSize) {
            inputArray[mergedArrayPointer] = rightHalf[rightArrayPointer];
            rightArrayPointer++;
            mergedArrayPointer++;
        }
    }
}
