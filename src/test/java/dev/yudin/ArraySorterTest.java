package dev.yudin;

import dev.yudin.arraysorter.ArraySorter;
import dev.yudin.arraysorter.Sorter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArraySorterTest {

    Sorter sorter = new ArraySorter();

    @Test
    void mergeSort_ShouldSortArrayInAscendingOrder_WhenInputIsNumbersArray() {

        int[] array = {3, 2, 1, 0};

        sorter.mergeSort(array);

        String expected = "[0, 1, 2, 3]";
        String actual = Arrays.toString(array);

        assertEquals(expected, actual);
    }

    @Test
    void mergeSort_ShouldSortArrayInAscendingOrder_WhenInputIsNumbersArray2() {

        int[] array = {11, -1, 15, 0, 17};

        sorter.mergeSort(array);

        String expected = "[-1, 0, 11, 15, 17]";
        String actual = Arrays.toString(array);

        assertEquals(expected, actual);
    }

    @Test
    void mergeSort_ShouldSortArrayInAscendingOrder_WhenInputIsNumbersArrayWithSizeOne() {

        int[] array = {11};

        sorter.mergeSort(array);

        String expected = "[11]";
        String actual = Arrays.toString(array);

        assertEquals(expected, actual);
    }

    @Test
    void mergeSort_ShouldThrowIllegalArgumentException_WhenInputIsNull() {

        int[] array = null;

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> sorter.mergeSort(array));
    }
}
