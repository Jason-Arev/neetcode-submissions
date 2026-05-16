class Solution {
    public void sortColors(int[] nums) {
        // Create a fixed-size array to count occurrences of 0s, 1s, and 2s
        int[] colors = {0, 0, 0};

        // First pass: Count how many of each color we have
        for (int num : nums) {
            colors[num] += 1; // Increment count at index 0, 1, or 2 based on num
        }

        // Second pass: Overwrite nums array in sorted order using the counts
        int i = 0; // Pointer for inserting back into original array
        for (int n = 0; n < colors.length; n++) { // Go through 0, 1, 2
            for (int j = 0; j < colors[n]; j++) { // Repeat n for however many times it appeared
                nums[i] = n; // Place the value n back into nums
                i++; // Move to next index
            }
        }
    }
}
