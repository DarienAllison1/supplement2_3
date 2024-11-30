/**
 * A utility class that provides methods for binary search, determinant calculation,
 * and matrix multiplication.
 * 
 */
public class MatrixAndSearchUtils {

    /**
     * Performs binary search on a sorted array of integers.
     * 
     * @param arr the sorted array of integers
     * @param target the value to search for
     * @return the index of the target if found, or -1 if the target is not in the array
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Calculates the determinant of a square matrix.
     * 
     * @param matrix a 2D array representing the square matrix
     * @return the determinant of the matrix
     * @throws IllegalArgumentException if the matrix is not square
     */
    public static int determinant(int[][] matrix) {
        int n = matrix.length;
        for (int[] row : matrix) {
            if (row.length != n) throw new IllegalArgumentException("Matrix must be square");
        }

        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        int det = 0;
        for (int col = 0; col < n; col++) {
            det += Math.pow(-1, col) * matrix[0][col] * determinant(minor(matrix, 0, col));
        }
        return det;
    }

    /**
     * Multiplies two matrices and returns the resulting matrix.
     * 
     * @param a the first matrix
     * @param b the second matrix
     * @return the resulting matrix from multiplying {@code a} and {@code b}
     * @throws IllegalArgumentException if the number of columns in {@code a} does not equal the number of rows in {@code b}
     */
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        if (a[0].length != b.length)
            throw new IllegalArgumentException("Number of columns in A must equal number of rows in B");

        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    /**
     * Computes the minor of a matrix by removing the specified row and column.
     * 
     * @param matrix the original matrix
     * @param row the row to remove
     * @param col the column to remove
     * @return the minor of the matrix
     */
    private static int[][] minor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];
        for (int i = 0, mi = 0; i < n; i++) {
            if (i == row) continue;
            for (int j = 0, mj = 0; j < n; j++) {
                if (j == col) continue;
                minor[mi][mj++] = matrix[i][j];
            }
            mi++;
        }
        return minor;
    }

    /**
     * Main method to demonstrate the usage of the utility methods.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Example usage of binarySearch
        int[] arr = {2, 4, 6, 8, 10};
        int index = binarySearch(arr, 6);
        System.out.println("Index of 6: " + index); // Output: Index of 6: 2

        // Example usage of determinant
        int[][] matrix = {
            {5, 7},
            {3, 9}
        };
        int det = determinant(matrix);
        System.out.println("Determinant: " + det); // Output: Determinant: 24

        // Example usage of multiplyMatrices
        int[][] a = {
            {2, 3},
            {4, 5}
        };
        int[][] b = {
            {6, 7},
            {8, 9}
        };
        int[][] result = multiplyMatrices(a, b);
        System.out.println("Matrix multiplication result:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

