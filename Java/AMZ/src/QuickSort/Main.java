package QuickSort;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {300, 150, 400, 200, 500, 100, 450, 250};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for(int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = randomPartition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int randomPartition(int[] arr, int low, int high) {
        // Random object for generating random pivot index

        Random rand = new Random();
        // generate a random pivot index between low and high
        int randomPivotIndex = low + rand.nextInt(high - low + 1);

        // swap the randomly chosen pivot with the last element

        int temp = arr[randomPivotIndex];
        arr[randomPivotIndex] = arr[high];
        arr[high] = temp;

        return partition(arr, low, high);


    }
}
