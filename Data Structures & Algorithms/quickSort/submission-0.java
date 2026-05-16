// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSortHelper(pairs, 0, pairs.size() - 1); 
        return pairs;
    }

    private void quickSortHelper(List<Pair> arr, int s, int e) { //start and end of the arrays
        if (e - s + 1 <= 1) {
            return;
        }

        Pair pivot = arr.get(e); //pivot is the last element
        int left = s; //pointer for the left side

        //Partition: elements that are smaller than the pivot to the left
        for (int i = s; i < e; i++) {
            if (arr.get(i).key < pivot.key) { 
                Pair temp = arr.get(left); //saves the left pointer
                arr.set(left, arr.get(i)); 
                arr.set(i, temp);
                left++; //increment left pointer to next index if it is less than the pivot
            }
        }

        //Move pivot in-between left & right sides
        arr.set(e, arr.get(left)); //end becomes the left pointer value
        arr.set(left, pivot); // left pointer now becomes the pivot

        //Quick sort both sides

        //left
        quickSortHelper(arr, s, left - 1); //start is s and end is pivot - 1

        //right
        quickSortHelper(arr, left + 1, e); // start is left pointer + 1 and e is the end
    }
}
