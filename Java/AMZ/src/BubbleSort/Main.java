package BubbleSort;

public class Main {
    public static void main(String[] args) {
        int[] data = generateArray(100);
        int[] largeData = generateArray(10000);

        long startTime = System.currentTimeMillis();
        BubbleSortPerformance.bubbleSort(data);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort a small dataset is " + (endTime-startTime) + " ms");

        long startTimeL = System.currentTimeMillis();
        BubbleSortPerformance.bubbleSort(largeData);
        long endTimeL = System.currentTimeMillis();
        System.out.println("Time taken to sort a large dataset is " + (endTimeL-startTimeL) + " ms");


    }

    public static int[] generateArray(int size) {
        int[] numbers = new int[size];
        for(int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 10000);
        }
        return numbers;
    }
//    public static void main(String[] args) {
//        int[] bookHeights = {12, 7, 19, 3, 15};
//        System.out.println("Before sorting");
//        printHeights(bookHeights);
//        System.out.println("after sorting");
//        bubbleSort(bookHeights);
//        printHeights(bookHeights);
//    }
//    public static void printHeights(int[] heights) {
//        for(int height: heights) {
//            System.out.print(height + "cm ");
//        }
//        System.out.println();
//    }
//    public static void bubbleSort(int[] bookHeights) {
//        int numberOfBooks = bookHeights.length;
//        boolean swapped;
//        for(int i = 0; i <numberOfBooks -1; i++) {
//            swapped = false;
//            for(int j = 0; j <numberOfBooks - 1 - i; j++) {
//                if(bookHeights[j] > bookHeights[j+1]) {
//                    int temp = bookHeights[j];
//                    bookHeights[j] = bookHeights[j+1];
//                    bookHeights[j+1] = temp;
//                    swapped = true;
//
//                }
//            }
//            if(!swapped) {
//                break;
//            }
//        }
//    }
//    public static void main(String[] args) {
//        int[] arr = {198, 184, 210, 176, 195};
//        System.out.println("Before sorting");
//        printHeights(arr);
//        System.out.println("After sorting");
//        bubbleSortDescending(arr);
//        printHeights(arr);
//
//    }
//
//    public static void bubbleSortDescending(int[] arr) {
//        int n = arr.length;
//        boolean swapped;
//        for(int i = 0; i <n -1; i++) {
//            swapped = false;
//            for(int j = 0; j <n - 1 - i; j++) {
//                if(arr[j] < arr[j+1]) {
//                    int temp = arr[j+1];
//                    arr[j+1] = arr[j];
//                    arr[j] = temp;
//                    swapped = true;
//                }
//            }
//            if(!swapped) {
//                break;
//            }
//        }
//    }
//
//        public static void printHeights(int[] heights) {
//        for(int height: heights) {
//            System.out.print(height + "cm ");
//        }
//        System.out.println();
//    }
}
