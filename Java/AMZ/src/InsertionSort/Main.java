package InsertionSort;

public class Main {
//    public static void main(String[] args) {
//        int[] cards = {7, 3, 10, 5, 2};
//        System.out.println("Original hand cards");
//        printArray(cards);
//        insertionSort(cards);
//        printArray(cards);
//    }
//    public static void printArray(int[] arr) {
//        for(int i : arr) {
//            System.out.print(i +  " ");
//        }
//        System.out.println();
//    }
//    public static void insertionSort(int[] arr) {
//        for(int i = 1; i < arr.length; i++) {
//            int current = arr[i];
//            int j = i - 1;
//
//            while(j >= 0 && arr[j] > current) {
//                arr[j + 1] = arr[j];
//                j--;
//            }
//            arr[j + 1] = current;
//        }
//    }
    public static void main(String[] args) {
        String[] names = {"Zara", "Mia", "Anna", "Sophia", "Ben"};
        String[] names2 = {"Augusta", "Ria", "Jodee", "Sophia", "James"};
        insertionSort(names);
        insertionSortDecending(names2);
        System.out.println("Sorted names: ");
        for(String name: names) {
            System.out.print(name+ " ");
        }
        System.out.println();
        System.out.println("Descending names: ");
        for(String name: names2) {
            System.out.print(name+ " ");
        }
    }
    public static void insertionSort(String[] arr) {
        for(int i = 1; i < arr.length; i++) {
            String current = arr[i];
            int counter = i - 1;
            while (counter >=0  && arr[counter].compareTo(current) >  0) {
                arr[counter + 1] = arr[counter];
                counter--;
            }
            arr[counter+1] = current;
        }
    }
    public static void insertionSortDecending(String[] arr) {
        for(int i = 1; i < arr.length; i++) {
            String current = arr[i];
            int counter = i - 1;
            while(counter >= 0 && arr[counter].compareTo(current) < 1) {
                arr[counter + 1] = arr[counter];
                counter--;
            }
            arr[counter+1] = current;
        }
    }
}
