class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int L = 0;
        int result = 0;

        for (int R = 0; R < s.length(); R++) {
            while (charSet.contains(s.charAt(R))) {
                charSet.remove(s.charAt(L));
                L++;
            }
            charSet.add(s.charAt(R));
            result = Math.max(result, R - L + 1);
        }
        return result;
    }   
}
