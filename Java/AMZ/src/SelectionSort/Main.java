package SelectionSort;

public class Main {
    public static void main(String[] args) {
        int[] coinSizes = {25,15,30,20,10};
        System.out.println("Initial coin sizes: ");
        printArray(coinSizes);

        selectionSort(coinSizes);

        System.out.println("Sorted coin sizes: ");
        printArray(coinSizes);
    }

    public static void printArray(int[] arr) {
        for(int i : arr){
            System.out.print(i + "mm ");
        }
        System.out.println();
    }
    public static void selectionSort(int[] arr) {

        for(int i = 0; i < arr.length -1; i++) {
            int minIndex = i;

            for(int j = i + 1; j < arr.length; j ++) {
                if (arr[j] > arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}