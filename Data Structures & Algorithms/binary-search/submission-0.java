class Solution {
    public int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        int mid;

        while (L <= R) {
            mid = (L + R) / 2;
            if (target > nums[mid]) {
                L = mid + 1;
            } else if (target < nums[mid]) {
                R = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
