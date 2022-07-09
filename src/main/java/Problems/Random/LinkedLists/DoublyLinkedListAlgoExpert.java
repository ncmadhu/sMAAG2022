package Problems.Random.LinkedLists;

public class DoublyLinkedListAlgoExpert {
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public Node head;
    public Node tail;

    public void setHead(Node node) {
        // Write your code here.
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void setTail(Node node) {
        // Write your code here.
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        if (node == head || node == null) this.setHead(nodeToInsert);
        else {
            node.prev.next = nodeToInsert;
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;
            node.prev = nodeToInsert;
        }
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        if (node == tail|| node == null) this.setTail(nodeToInsert);
        else {
            node.next.prev = nodeToInsert;
            nodeToInsert.next = node.next;
            nodeToInsert.prev = node;
            node.next = nodeToInsert;
        }
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        int count = 1;
        Node curr = head;
        while (curr != null && count < position) {
            curr = curr.next;
            count++;
        }
        if (curr != null) this.insertBefore(curr, nodeToInsert);
        else if (curr == null) this.setTail(nodeToInsert);
    }

    public void removeHeadOrTailNode(Node node) {
        if (node == tail) {
            tail = node.prev;
            node.prev.next = null;
        }
        if (node == head) {
            head = node.next;
            node.next.prev = null;
        }
    }

    public void removeNodesWithValue(int value) {
        Node curr = head;
        while (curr != null && curr.value != value) {
            curr = curr.next;
        }
        this.remove(curr);
    }

    public void remove(Node node) {
        if (node == null) return;
        if (node == head || node == tail) this.removeHeadOrTailNode(node);
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public boolean containsNodeWithValue(int value) {
        // Write your code here.
        Node curr = head;
        while (curr != null) {
            if (curr.value == value) return true;
            curr = curr.next;
        }
        return false;
    }

    public void printList() {
        Node curr = head;
        while (curr.next != null) {
            System.out.print(curr.value + " -> ");
                curr = curr.next;
        }
        System.out.println(curr.value + " -> null");
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
