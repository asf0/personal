package BinarySearch;

public class Main {
//    public static void main(String[] args) {
//        int[] arr = {5, 15, 25, 35, 45, 55, 65, 75, 85, 95};
//        int target = 75;
//
//        int index = binarySearch(arr, target);
//
//        if (index != -1) {
//            System.out.println("Element found at index " +index);
//        } else {
//            System.out.println("Element not found");
//        }
//    }
//    public static int binarySearch(int[] arr, int target) {
//        int left = 0;
//        int right = arr.length - 1;
//        while (left <= right) {
//            int middle = left + (right - left) / 2;
//            if (arr[middle] == target) {
//                return middle;
//            }
//            if (arr[middle] > target) {
//                right = middle - 1;
//            } else {
//                left = middle + 1;
//            }
//        }
//        return -1;
//    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 30, 40, 50};
        int target = 20;
        boolean multiple = hasMultipleOccurrences(arr, target);
        System.out.println("Has Multiple Occurrences: " + multiple);
    }

    public static boolean hasMultipleOccurrences(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if(arr[mid] == target) {
                if (mid >0 && arr[mid -1] == target || mid < arr.length -1 && arr[mid + 1] == target) {
                    return true;
                } else {
                    return false;
                }
            }
            if(arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;

    }
}
