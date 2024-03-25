import com.sun.nio.sctp.PeerAddressChangeNotification;
import org.junit.jupiter.api.Test;

import java.util.*;


import static java.util.Collections.reverse;
import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    private int[] generateArrayOfRandom(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i : arr) {
            i = random.nextInt();
        }
        return arr;
    }
    private Integer[] generateArrayOfRandomI(int size) {
        Integer[] arr = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    private int[] generateArrayOfLargeNumbers(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i : arr) {
            i = random.nextInt() * 10000000;
        }
        return arr;
    }


    private int[] generateArrayOfDuplicates(int size) {
        int[] arr = new int[size];
        var random = new Random();
        int x = random.nextInt();
        for (int i : arr) {
            i = x;
        }
        return arr;
    }
    @Test
    void empty() {
        int[] arr = null;
        int[] output = InsertionSort.insertionSortIncreasing(arr);
        assertArrayEquals(output, null);
    }
    @Test
    void singleElement() {
        Random random = new Random();
        int value = random.nextInt();
        int[] arr = {value};
        int[] output = InsertionSort.insertionSortIncreasing(arr);
        assertArrayEquals(output, new int[]{value});
     }

    @Test
    void simple() {
        int[] arr = {4, 2, 3, 1};
        int[] sorted = {1, 2, 3, 4};
       int[] output = InsertionSort.insertionSortIncreasing(arr);
        assertArrayEquals(output, sorted);
    }
    @Test
    void largeArray() {
        int[] input = generateArrayOfRandom(1000000);
        int[] sorted = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            sorted[i] = input[i];
        }
        Arrays.sort(sorted);
        int[] output = InsertionSort.insertionSortIncreasing(input);
        assertArrayEquals(output, sorted);
    }

    @Test
    void largeNumbers() {
        int[] input = generateArrayOfLargeNumbers(100000);
        int[] sorted = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            sorted[i] = input[i];
        }
        Arrays.sort(sorted);
        int[] output = InsertionSort.insertionSortIncreasing(input);
        assertArrayEquals(output, sorted);
    }

    @Test
    void SortedReverse() {
        Integer[] arr = generateArrayOfRandomI(100000);

        int[] sorted = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        Arrays.sort(sorted);

        Arrays.sort(arr, Collections.reverseOrder());
        int[] input=Arrays.stream(arr).mapToInt(Integer::intValue).toArray();;

        int[] output = InsertionSort.insertionSortIncreasing(input);
        assertArrayEquals(output, sorted);
    }

    @Test
    void ArrayOfDuplicates() {
        int[] input = generateArrayOfDuplicates(100000);
        int[] backUp = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            backUp[i] = input[i];
        }
        int[] output = InsertionSort.insertionSortIncreasing(input);
        assertArrayEquals(backUp, output);
    }
    @Test
    void sorted() {
        int[] input = generateArrayOfRandom(100000);
        int[] sorted = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            sorted[i] = input[i];
        }
        Arrays.sort(sorted);
        Arrays.sort(input);
        int[] output = InsertionSort.insertionSortIncreasing(input);
        assertArrayEquals(output, sorted);
    }
    
}