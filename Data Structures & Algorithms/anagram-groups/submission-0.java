class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagram = new HashMap<>(); //create map for finding same chars in a string
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            anagram.putIfAbsent(sortedS, new ArrayList<>());
            anagram.get(sortedS).add(s); //add string to the list with the same chars
        }
        return new ArrayList<>(anagram.values());
    }
}
