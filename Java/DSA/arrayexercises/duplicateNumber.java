import java.util.Arrays;
public class duplicateNumber {
    /**
    * Duplicate Number
    * Write a function which takes integer array as a parameter and returns a new integer array with unique elements. (remove duplicates)
    * Example
    * removeDuplicates({1, 1, 2, 2, 3, 4, 5})
    * Output : [1, 2, 3, 4, 5]
     */
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3, 4, 5};
        int[] result = removeDuplicates(array);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    public static int[] removeDuplicates(int[] arr) {
        int[] result = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                result[index++] = arr[i];
            }
        }
        return Arrays.copyOf(result, index);
      }
}
