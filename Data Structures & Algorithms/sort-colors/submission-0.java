class Solution {
    public void sortColors(int[] nums) {
        int[] colors = {0, 0, 0};

        for (int num : nums) {
            colors[num] += 1;
        }

        int i = 0;
        for (int n = 0; n < colors.length; n++) {
            for (int j = 0; j < colors[n]; j++) {
                nums[i] = n;
                i++;
            }
        }
    }
}