package Problems.Random.LinkedLists;

import Problems.Problem;

public class ReverseBetweenTheNodes extends Problem {
    @Override
    public void run() {
        System.out.println("Running Reverse The Nodes Between");
        SinglyLinkedList<Integer> sll = LinkedListUtils.insertNodesNTimes(10);
        this.reAttempt(sll, 5, 10);
        sll.printList();
        sll = LinkedListUtils.insertNodesNTimes(10);
        this.reAttempt(sll, 1, 5);
        sll.printList();
        sll = LinkedListUtils.insertNodesNTimes(10);
        this.reAttempt(sll, 1, 2);
        sll.printList();
    }

    private <T> void reAttempt(SinglyLinkedList<T> list, int start, int end) {
        if (list == null) return;
        if (end - start < 2) return;
        SinglyLinkedList<T>.Node curr = list.headNode;
        SinglyLinkedList<T>.Node prev = null;
        int count = 1;
        while (count <= start && curr != null) {
            prev = curr;
            curr = curr.nextNode;
            count++;
        }
        SinglyLinkedList<T>.Node revStartPrev = prev;
        SinglyLinkedList<T>.Node revStart = curr;
        while (count < end && curr != null) {
            SinglyLinkedList<T>.Node temp = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = temp;
            count++;
        }
        revStartPrev.nextNode = prev;
        revStart.nextNode = curr;
    }

    private <T> void reverseBetweenTheNodes(SinglyLinkedList<T> list, int start, int end) {
        if (list == null) return;
        int count = 0;
        SinglyLinkedList<T>.Node curr = list.headNode;
        SinglyLinkedList<T>.Node prev = null;
        while (curr != null) {
            count += 1;
            if (count == start) {
                SinglyLinkedList<T>.Node reverseStart = curr;
                SinglyLinkedList<T>.Node reversePrev = prev;
                while (count <= end && curr != null) {
                    SinglyLinkedList<T>.Node temp = curr.nextNode;
                    curr.nextNode = prev;
                    prev = curr;
                    curr = temp;
                    count++;
                }
                if (reversePrev != null)  {
                    reversePrev.nextNode = prev;
                } else {
                    // update headNode
                    list.headNode = prev;
                }
                reverseStart.nextNode = curr;
                break;
            }
            prev = curr;
            curr = curr.nextNode;
        }
    }
}
