class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagram = new HashMap<>();
        for (String s : strs) {
            String key = sortString(s);
            anagram.putIfAbsent(key, new ArrayList<>());
            anagram.get(key).add(s);
        }
        return new ArrayList<>(anagram.values());
    }

    private String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
