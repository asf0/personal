import java.util.HashMap;

/**
 * Permutation
Your are given two integer arrays. Write a program to check if they are permutation of each other.
*Example
*int[] array1 = {1,2,3,4,5};
*int[] array2 = {5,1,2,3,4};
*permutation(array1, array2)
*Output
* true
 */

public class permutation {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {5, 1, 2, 3, 4};
        System.out.println(isPermutation(array1, array2));
    }
    public static boolean isPermutation(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int element: array1) {
                map.put(element, map.getOrDefault(element, 0) + 1);
            }
            for(int element: array2) {
                int count = map.getOrDefault(element, 0);
                if (count == 0) {
                    return false;
                }
                map.put(element, count - 1);
            }  
            return true;
        }
}