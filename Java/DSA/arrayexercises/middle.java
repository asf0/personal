public class middle {
    public static int[] getMiddleElements(int[] arr) {
        int[] result = new int[arr.length - 2];
        for (int i = 1; i < arr.length - 1; i++) {
            result[i - 1] = arr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] result = getMiddleElements(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
