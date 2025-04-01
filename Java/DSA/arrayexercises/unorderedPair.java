package arrayexercises;

public class unorderedPair {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        unorderedPair up = new unorderedPair();
        up.printUnorderedPairs(array);
    }
    void printUnorderedPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                System.out.println("(" + array[i] + ", " + array[j] + ")");
            }
        }
    }
}
