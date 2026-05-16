public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get number of rows and columns in the matrix
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        // Binary search over the rows
        int top = 0, bot = ROWS - 1;
        while (top <= bot) {
            // Find the middle row
            int row = (top + bot) / 2;

            // If target is greater than the last element in this row,
            // it must be in a row *below* this one
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            }
            // If target is less than the first element in this row,
            // it must be in a row *above* this one
            else if (target < matrix[row][0]) {
                bot = row - 1;
            }
            // Otherwise, the target must be in this row
            else {
                break;
            }
        }

        // If we exited the loop without finding a valid row
        if (!(top <= bot)) {
            return false; // target doesn't fit in any row's range
        }

        // Now do binary search within the found row
        int row = (top + bot) / 2;
        int l = 0, r = COLS - 1;
        while (l <= r) {
            // Midpoint of the row
            int m = (l + r) / 2;

            // Standard binary search logic on the row
            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true; // Found the target
            }
        }

        // Target not found in the identified row
        return false;
    }
}
