import java.util.Arrays;

/**
 * Rotate Matrix
 * Given an image represented by an NxN matrix write a method to rotate the image by 90 degrees.
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
public class rotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotateMatrix obj = new rotateMatrix();
        obj.Matrix(matrix);
        System.out.println(Arrays.deepToString(matrix));
        // System.out.println("Before Rotation: ");
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix.length; j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // rotateMatrix obj = new rotateMatrix();
        // obj.Matrix(matrix);
        // System.out.println("After Rotation: ");
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix.length; j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
 
        
    }
    public void Matrix(int[][] matrix) {
        int n = matrix.length;
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        for (int i = 0; i < n/2; i++) {
            int first = i;
            int last = n -1 -i;
            for (int j = first; j < last; j++) {
                int offset = j - first;
                int top = matrix[first][j];
                matrix[first][j] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[j][last];
                matrix[j][last] = top;
            }
        }
        // int[][] a = new int[n][n];
        // for (int i =0; i < n; i++) {
        //     for (int j = n-1; j >= 0; j--) {
        //         a[i][n-1-j] = matrix[j][i];
        //     }
        // }
        // for (int i = 0; i < n; i++) {
        //     System.arraycopy(a[i], 0, matrix[i], 0, n);
        // }
    }
}

