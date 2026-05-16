class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        l = len(nums)
        ans = [0] * (2 * l)
        for i, num in enumerate(nums):
            ans[i] = ans[i + l] = num
        return ans