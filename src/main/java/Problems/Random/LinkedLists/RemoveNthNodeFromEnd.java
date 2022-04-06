package Problems.Random.LinkedLists;

import Problems.Problem;

public class RemoveNthNodeFromEnd extends Problem {
    @Override
    public void run() {
        System.out.println("Running Remove Nth Node From The End");
        SinglyLinkedList<Integer> sll = LinkedListUtils.insertNodesNTimes(10);
        sll.printList();
        this.removeNthNodeFromEnd(sll, 5);
        sll.printList();
        this.removeNthNodeFromEnd(sll, 9);
        sll.printList();
    }

    private <T> void removeNthNodeFromEnd(SinglyLinkedList<T> list, int n) {
        int length = 0;
        SinglyLinkedList<T>.Node curr = list.headNode;
        while (curr != null) {
            length += 1;
            curr = curr.nextNode;
        }
        System.out.println("Length of the List is: " + length);
        if (n == length) {
            list.headNode = list.headNode.nextNode;
            return;
        }
        SinglyLinkedList<T>.Node prev = null;
        curr = list.headNode;
        int count = length;

        while (curr != null) {
            if (count == n) {
                prev.nextNode = curr.nextNode;
                break;
            }
            prev = curr;
            curr = curr.nextNode;
            count--;
        }
    }
}
