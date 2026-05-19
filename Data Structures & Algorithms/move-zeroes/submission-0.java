class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int l = 0;

        for (int r = 0; r < length; r++) {
            if (nums[r] != 0) {
                nums[l++] = nums[r];
            }
        }
        while (l < length) {
            nums[l++] = 0;
        }
    }
}