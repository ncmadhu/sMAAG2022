package Problems.Random.LinkedLists;

import Problems.Problem;

public class MiddleOfLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find Middle Of Linked List");
        int[] input = new int[]{10,5};
        this.execute(input);
    }

    private void execute(int[] input) {
        for (int i = 0; i < input.length; i++) {
            SinglyLinkedList<Integer> sll = LinkedListUtils.insertNodesNTimes(input[i]);
            sll.printList();
            System.out.println("Middle Of List is: " + this.findMiddleOfLinkedList(sll));
        }
    }

    private int findMiddleOfLinkedList(SinglyLinkedList<Integer> sll) {
        if (sll.isEmpty()) return -1;
        SinglyLinkedList<Integer>.Node slow = sll.headNode;
        SinglyLinkedList<Integer>.Node fast = sll.headNode;
        while (slow != null && fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        return slow.data;
    }
}
