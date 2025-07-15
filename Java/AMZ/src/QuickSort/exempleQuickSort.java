package QuickSort;

public class exempleQuickSort {
    public static void main(String[] args) {
        //int[] numbers = {38, 27, 43, 3, 9, 82, 10};
        String[] words = {"banana", "apple", "orange", "kiwi", "grape"};
        quickSort(words, 0, words.length - 1);

        System.out.print("Sorted numbers: ");
        for (String number : words) {
            System.out.print(number + " ");
        }
    }

    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi+ 1, high);
        }
    }

    public static int partition(String[] arr, int low, int high) {
        String pivot = arr[high]; // choose the last element as pivot
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
