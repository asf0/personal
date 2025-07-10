package MergeSort;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        mergeSort(numbers, 0, numbers.length -1);
        System.out.println("SortedArray");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

    }
    public static void mergeSort(int[]numbers, int left, int right) {
        if (numbers == null || numbers.length <=1) {
            return;
        }
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(numbers, left, middle);
            mergeSort(numbers, middle + 1, right);
            merge(numbers, left, middle, right);
        }
    }

    public static void merge(int[] numbers, int left, int middle, int right) {
        int sizeOfLeftArray = middle - left + 1;
        int sizeOfRightArray = right - middle;
        int[] leftArray = new int[sizeOfLeftArray];
        int[] rightArray = new int[sizeOfRightArray];

        for (int index = 0; index < sizeOfLeftArray; index ++) {
            leftArray[index] = numbers[left + index];
        }

        for (int index = 0; index < sizeOfRightArray; index++) {
            rightArray[index] = numbers[middle + 1 + index];
        }

        int indexOfLeftArray = 0;
        int indexOfRightArray = 0;
        int indexOfMergedArray = left;

        while (indexOfLeftArray < sizeOfLeftArray && indexOfRightArray < sizeOfRightArray) {
            if (leftArray[indexOfLeftArray] <= rightArray[indexOfRightArray]) {
                numbers[indexOfMergedArray] = leftArray[indexOfLeftArray];
                indexOfLeftArray++;
            } else {
                numbers[indexOfMergedArray] = rightArray[indexOfRightArray];
                indexOfRightArray++;

            }
            indexOfMergedArray++;
        }
        while (indexOfLeftArray < sizeOfLeftArray) {
            numbers[indexOfMergedArray] = leftArray[indexOfLeftArray];
            indexOfLeftArray++;
            indexOfMergedArray++;
        }

        // ✨ FIX: Copy remaining elements of rightArray[], if any
        while (indexOfRightArray < sizeOfRightArray) {
            numbers[indexOfMergedArray] = rightArray[indexOfRightArray];
            indexOfRightArray++;
            indexOfMergedArray++;
        }
    }
}
