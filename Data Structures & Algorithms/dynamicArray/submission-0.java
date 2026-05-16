class DynamicArray {
private int capacity;
private int length;
private int[] arr;

//Constructor for dynamic array
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0; //initial length size
        this.arr = new int[this.capacity]; //takes in capacity to change arr size capacity
    }

    //getter for i-th index
    public int get(int i) {
        return arr[i];
    }

    //insert value n at i-th index
    public void set(int i, int n) {
        arr[i] = n;
    }

    //Inserts n in the last position of the array
    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        arr[length] = n;
        length++;
    }

    //removes the last element of the array
    public int popback() {
        if (length > 0) {
            //soft delete last element
            length--;
        }
        return arr[length]; //returns the value at the length index
    }

    private void resize() {
        capacity *= 2; //doubles capacity to fit new values
        int[] newArr = new int[capacity]; //creates new array with double capacity
        for (int i = 0; i < length; i++) { //adds old arr values to new arr values
            newArr[i] = arr[i];
        }
        arr = newArr; //updates the initial array to become the new array
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
