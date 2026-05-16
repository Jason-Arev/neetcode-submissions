class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
class Deque {
    private Node headPointer;
    private Node tailPointer;

    public Deque() {
        this.headPointer = new Node(0);
        this.tailPointer = new Node(0);

        this.headPointer.next = this.tailPointer;
        this.tailPointer.prev = this.headPointer;
    }

    public boolean isEmpty() {
        return this.headPointer.next == this.tailPointer;
    }

    public void append(int value) { //adds new node before the tail and after the other values
        Node newNode = new Node(value);
        newNode.prev = this.tailPointer.prev;
        newNode.next = this.tailPointer;
        this.tailPointer.prev.next = newNode; //sets the new node without replacing the pointer
        this.tailPointer.prev = newNode; //ensures newNode is before the tail without replacing it
    }

    public void appendleft(int value) { //adds to the beginning of the queue without replacing the head
    Node newNode = new Node(value);
    newNode.next = this.headPointer.next;
    newNode.prev = this.headPointer;
    this.headPointer.next.prev = newNode;
    this.headPointer.next = newNode;         //same logic as appened but for the head    
    }

    public int pop() { //removes the last value and returns it
        if (isEmpty()) {
            return -1;
        }
        Node targetNode = this.tailPointer.prev; //targets last value
        Node prevNode = targetNode.prev; //saves the node before last node
        int value = targetNode.value; //saves the value of target node to return later

        this.tailPointer.prev = prevNode; //saved node becomes the new last node
        prevNode.next = this.tailPointer;  //connects the saved node to the tail

        return value; //returns target node value
    }

    public int popleft() {
        if (isEmpty()) {
            return -1;
        }
        Node targetNode = this.headPointer.next; //targets first value
        Node nextNode = targetNode.next; //saves the node after 1st node
        int value = targetNode.value; //saves the value of target node to return later

        this.headPointer.next = nextNode; //saved node becomes the new 1st node
        nextNode.prev = this.headPointer;  //connects the saved node to the head

        return value; //returns target node value
    }
}
