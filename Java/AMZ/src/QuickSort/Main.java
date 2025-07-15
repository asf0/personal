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
                swap(array, i, j);
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

        swap(arr, randomPivotIndex, high);

        return partition(arr, low, high);
    }

    public static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        if (arr[low] < arr[mid] && arr[mid] < arr[high]) {
            //the middle element is the medium value
            swap(arr, mid, high);
        } else if (arr[low] > arr[mid] && arr[low] < arr[high]) {
            //the low element is the medium value
            swap(arr,low, high);
        }
        // the high element is the meidum value
        return arr[high];
    }

    // method to swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }
}
