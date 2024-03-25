import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    public static int[] insertionSortIncreasing(int[] arr) {
        if (arr == null) {
            return null;
        }
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index] > key) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = key;
        }
        return arr;
    }
}
