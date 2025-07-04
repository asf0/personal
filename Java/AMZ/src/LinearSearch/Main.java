package LinearSearch;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {10, 20, 30, 40, 50};
//        int target = 30;
//
//        int index = linearSearch(arr, target);
//
//        if (index != -1) {
//            System.out.println("Element found at index: " +index);
//        } else {
//            System.out.println("Element not found");
//        }
        int[] arr = {10, 20, 30, 20, 50};
        int target = 20; // Value to search for

        int[] indices = findAllOccurrences(arr, target);
        System.out.print("Find All Occurrences: ");
        if (indices.length > 0) {
            for (int index : indices) {
                System.out.print(index + " ");
            }
        } else {
            System.out.print("No occurrences found.");
        }
        System.out.println();
    }
//    public static int linearSearch(int[] arr, int target) {
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == target) {
//                return i;
//            }
//        }
//        return -1;
//    }
    public static int[] findAllOccurrences(int[] arr, int target) {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                temp.add(i);
            }
        }
        int[] result = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}
