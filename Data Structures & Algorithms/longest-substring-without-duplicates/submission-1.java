class Solution {
    public int lengthOfLongestSubstring(String s) {
        //create new map to keep track of existing chars
        HashMap<Character, Integer> existing = new HashMap();
        // left and result set 0 as default
        int l = 0, res = 0;


        for (int r = 0; r < s.length(); r++) {
            // check if map contains the existing char
            if (existing.containsKey(s.charAt(r))) {
                // save the longest existing length of substring
                l = Math.max(existing.get(s.charAt(r)) + 1, l);
            }
            // else, add char to map
            existing.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
