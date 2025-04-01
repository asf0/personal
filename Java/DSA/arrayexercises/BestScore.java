public class BestScore {
    /**
     * Best Score
        Given an array, write a function to get first, second best scores from the array and return it in new array.
        Array may contain duplicates.
        Example
        myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0}
        firstSecond(myArray) // {90, 87}
     */
    public static int[] findTopTwoScores(int[] array){
        // TODO
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++){
            if (array[i] > max1) {
                max2 = max1;
                max1 = array[i];
            } else if (array[i] > max2) {
                max2 = array[i];
            }
        }
        return new int[]{max1, max2};
      }
    public static void main(String[] args) {
        int[] myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0};
        int[] result = findTopTwoScores(myArray);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
