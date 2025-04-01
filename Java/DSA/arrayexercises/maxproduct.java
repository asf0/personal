/**
 * Max Product of Two Integers
How to find maximum product of two integers in the array where all elements are positive.
Example
int[] intArray = {10,20,30,40,50};
maxProduct(intArray) // (40,50)
 */
public class maxproduct {
    public static void main(String[] args) {
        int[] intArray = {10,20,30,40,50};
        System.out.println(maxProduct(intArray));
    }
    public static String maxProduct(int[] intArray) {
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < intArray.length; i ++) {
            if (intArray[i] > max1) {
                max2 = max1;
                max1 = intArray[i];
            } else if (intArray[i] > max2) {
                max2 = intArray[i];
            }
        }
        return "(" + max1 + "," + max2 + ")";
    }

}
