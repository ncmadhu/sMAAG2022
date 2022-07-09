package Problems.Random.LinkedLists;

import Problems.Problem;

public class TestDoublyLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Doubly Linked List Test");
        DoublyLinkedListAlgoExpert dll = new DoublyLinkedListAlgoExpert();
        DoublyLinkedListAlgoExpert.Node nodeTwo = new DoublyLinkedListAlgoExpert.Node(2);
        dll.setHead(nodeTwo);
        this.printCurrentState(dll);
        DoublyLinkedListAlgoExpert.Node nodeOne = new DoublyLinkedListAlgoExpert.Node(1);
        dll.setHead(nodeOne);
        this.printCurrentState(dll);
        DoublyLinkedListAlgoExpert.Node nodeFour = new DoublyLinkedListAlgoExpert.Node(4);
        dll.insertAfter(nodeTwo, nodeFour);
        this.printCurrentState(dll);
        DoublyLinkedListAlgoExpert.Node nodeThree = new DoublyLinkedListAlgoExpert.Node(3);
        dll.insertBefore(nodeFour, nodeThree);
        this.printCurrentState(dll);
        DoublyLinkedListAlgoExpert.Node nodeFive = new DoublyLinkedListAlgoExpert.Node(5);
        dll.insertAtPosition(4, nodeFive);
        this.printCurrentState(dll);
        dll.removeNodesWithValue(1);
        this.printCurrentState(dll);
        dll.removeNodesWithValue(5);
        this.printCurrentState(dll);
        dll.remove(nodeThree);
        this.printCurrentState(dll);
        System.out.println("2 : " + dll.containsNodeWithValue(2));
        System.out.println("3 : " + dll.containsNodeWithValue(3));
    }
    public void printCurrentState(DoublyLinkedListAlgoExpert dll) {
        dll.printList();
        System.out.println("Head: " + dll.getHead().value);
        System.out.println("Tail: " + dll.getTail().value);
    }
}
