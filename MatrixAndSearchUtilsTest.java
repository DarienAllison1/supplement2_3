import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for the MatrixAndSearchUtils class.
 * This class tests the static methods for binary search, determinant calculation,
 * and matrix multiplication.
 */
public class MatrixAndSearchUtilsTest {

    /**
     * Tests the binarySearch method.
     * Verifies the index of a target in a sorted array and checks behavior for a target not present in the array.
     */
    @Test
    public void testBinarySearch() {
        int[] arr = {1, 3, 5, 7, 9};
        // Test case: target is present in the array
        assertEquals(2, MatrixAndSearchUtils.binarySearch(arr, 5));
        // Test case: target is not present in the array
        assertEquals(-1, MatrixAndSearchUtils.binarySearch(arr, 4));
    }

    /**
     * Tests the determinant method.
     * Verifies the determinant calculation for square matrices of sizes 1x1, 2x2, and 3x3.
     */
    @Test
    public void testDeterminant() {
        // Test case: 1x1 matrix
        int[][] matrix1 = {{4}};
        assertEquals(4, MatrixAndSearchUtils.determinant(matrix1));

        // Test case: 2x2 matrix
        int[][] matrix2 = {
            {3, 8},
            {4, 6}
        };
        assertEquals(-14, MatrixAndSearchUtils.determinant(matrix2));

        // Test case: 3x3 matrix
        int[][] matrix3 = {
            {6, 1, 1},
            {4, -2, 5},
            {2, 8, 7}
        };
        assertEquals(-306, MatrixAndSearchUtils.determinant(matrix3));
    }

    /**
     * Tests the multiplyMatrices method.
     * Verifies the result of multiplying two matrices together.
     */
    @Test
    public void testMultiplyMatrices() {
        // Test case: multiplication of two matrices
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        int[][] b = {
            {2, 0},
            {1, 2}
        };
        int[][] expected = {
            {4, 4},
            {10, 8}
        };
        assertArrayEquals(expected, MatrixAndSearchUtils.multiplyMatrices(a, b));
    }
}
