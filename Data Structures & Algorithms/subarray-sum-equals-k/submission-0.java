class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, curSum = 0;
        Map<Integer, Integer> prefSums = new HashMap<>();
        prefSums.put(0,1);

        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;
            res += prefSums.getOrDefault(diff, 0);
            prefSums.put(curSum, prefSums.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }
}