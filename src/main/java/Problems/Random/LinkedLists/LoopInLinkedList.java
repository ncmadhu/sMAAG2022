package Problems.Random.LinkedLists;

import Problems.Problem;

public class LoopInLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Detect Loop Start In Linked List");
        int[] input =  new int[]{10, 5, 4, 2};
        this.execute(input);
    }

    private void execute(int[] input) {
        for (int i = 0; i < input.length; i = i+2) {
            SinglyLinkedList<Integer> sll = LinkedListUtils.insertNodesNTimes(input[i]);
            sll.printList();
            LinkedListUtils.loopToNthNode(sll, input[i+1]);
            System.out.println("Loop Start: " + this.getLoopStart(sll));
        }
    }

    private int getLoopStart(SinglyLinkedList<Integer> sll) {
        if (sll.isEmpty()) return -1;
        SinglyLinkedList<Integer>.Node slow = sll.headNode;
        SinglyLinkedList<Integer>.Node fast = sll.headNode;
        while (slow != null && fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
            if (slow == fast) break;
        }
        // Count the number of nodes in the loop
        int loopCount = 1;
        while (slow.nextNode != fast) {
            slow = slow.nextNode;
            loopCount++;
        }
        SinglyLinkedList<Integer>.Node p1 = sll.headNode;
        SinglyLinkedList<Integer>.Node p2 = sll.headNode;
        // Move one pointer to loopCount nodes ahead
        while (loopCount > 1 && p2 != null) {
            p2 = p2.nextNode;
            loopCount--;
        }
        while (p2.nextNode != p1) {
            p1 = p1.nextNode;
            p2 = p2.nextNode;
        }
        return p1.data;
    }
}
