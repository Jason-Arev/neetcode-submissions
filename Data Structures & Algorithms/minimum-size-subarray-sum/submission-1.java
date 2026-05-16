class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int total = 0;
        final int INF = Integer.MAX_VALUE;
        int length = INF;

        for (int r = 0; r < nums.length; r++) {
            total += nums[r];
            while (total >= target) {
                length = Math.min(r - l + 1, length);
                total -= nums[l];
                l++;
            }
        }
        return length == INF ? 0 : length;
    }
}