package MergeSort;

import BubbleSort.BubbleSortPerformance;

import java.util.Arrays;
import java.util.Random;

public class mainYoutube {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[1000000000];

        for (int i =0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }

        long startTime = System.currentTimeMillis();
        mergeSort(numbers);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort a large dataset is " + (endTime-startTime) + " ms");

//        System.out.println("Before sorted: ");
//        //printArray(numbers);
//        mergeSort(numbers);
//        System.out.println("After: ");
        //printArray(numbers);
    }
    public static void printArray(int[] arr) {
        Arrays.stream(arr).mapToObj(j -> j + " ").forEach(System.out::print);
        System.out.println();
    }

    public static void mergeSort(int[] arr){
        int inputLength = arr.length;

        if (inputLength < 2) {
            return;
        }
        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = arr[i];
        }
        for(int i = midIndex; i < inputLength; i++) {
            rightHalf[i -midIndex] = arr[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(arr, leftHalf, rightHalf);

    }

    private static void merge(int[] arr, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                arr[k] = leftHalf[i];
                i++;
            } else {
                arr[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            arr[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            arr[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
