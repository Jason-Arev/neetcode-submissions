// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        int n = pairs.size();
        List<List<Pair>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int j = i - 1;

            while (j >= 0 && pairs.get(j).key > pairs.get(j + 1).key) {
                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(j + 1));
                pairs.set(j + 1, temp);
                j--;
            }

            List<Pair> cloneList = new ArrayList<>(pairs);
            result.add(cloneList);
        }
        return result;
    }
}
