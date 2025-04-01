/**
 * Finding a Number in an Array
 * Write a program to to check if an array contains a number in Java.
 * int[] intArray = {1,2,3,4,5,6};
 * searchInArray(intArray, 6); // 5
 */
public class searchinarray {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6};
        System.out.println(searchInArray(intArray, 6));
    }
    public static int searchInArray(int[] intArray, int target) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == target) {
                return i;
            }
        }
        return -1; // Return -1 if the target is not found in the array
    }
}
