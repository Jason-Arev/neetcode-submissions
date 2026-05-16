class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        res.add("");
        String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "qprs", "tuv", "wxyz"
        };

        for (char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (String currStr : res) {
                for (char c : digitToChar[digit - '0'].toCharArray()) {
                    temp.add(currStr + c);
                }
            }
            res = temp;
        }
        return res;
    }
}
