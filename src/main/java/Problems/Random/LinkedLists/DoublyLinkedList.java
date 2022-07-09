package Problems.Random.LinkedLists;

public class DoublyLinkedList<T> {
    //Node inner class of DLL
    public class Node {
        public T data;
        public Node prevNode;
        public Node nextNode;
    }

    //member variables
    public Node headNode;
    public Node tailNode;
    public int size;

    //constructor
    public DoublyLinkedList() {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        if (headNode == null && tailNode == null) {
            return true;
        } else {
            return false;
        }
    }

    //getter for headNode
    public Node getHeadNode() {
        return headNode;
    }

    //getter for tailNode
    public Node getTailNode() {
        return tailNode;
    }

    //getter for size
    public int getSize() {
        return size;
    }

    //insert at start of the list
    public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.prevNode = null; // inserting at the start, Hence no previous node
        if (headNode != null) {
            newNode.nextNode = this.headNode;
            headNode.prevNode = newNode;
        } else {
            newNode.nextNode = null;
            this.tailNode = newNode; // updating tailNode
        }
        this.headNode = newNode; // updating headNode
        size++;
    }

    //insert at end of the list
    public void insertAtTail(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null; // since inserting at the end there is no nextNode
        if (isEmpty()) {
            insertAtHead(data);
        } else {
            tailNode.nextNode = newNode;
            newNode.prevNode = tailNode;
            tailNode = newNode;
            size++;
        }
    }

    //delete at head
    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }
        headNode = headNode.nextNode;
        if (headNode == null) {
            tailNode = null;
        } else {
            headNode.prevNode = null;
        }
        size--;
    }

    //delete at end
    public void deleteAtTail() {
        if (isEmpty()) {
            return;
        }
        tailNode = tailNode.prevNode;
        if (tailNode == null) {
            headNode = null;
        } else {
            tailNode.nextNode = null;
        }
        size--;
    }

    // delete by value
    public void deleteByValue(T data) {
        if (isEmpty()) return;

        //Start from headNode
        Node currNode = this.getHeadNode();

        if (currNode.data == data)  {
            this.deleteAtHead();
            return;
        }

        while (currNode != null) {
            if (data.equals(currNode.data)) {
                // Alter next node pointer
                currNode.prevNode.nextNode = currNode.nextNode;
                if (currNode.nextNode != null) {
                    // Alter previous node pointer
                    currNode.nextNode.prevNode = currNode.prevNode;
                }
            }
            currNode = currNode.nextNode;
        }
    }

    //print list
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        Node node = this.headNode;
        while (node != null) {
            System.out.print(node.data.toString() + " <--> ");
            node = node.nextNode;
        }
        System.out.println("NULL");
    }
}
