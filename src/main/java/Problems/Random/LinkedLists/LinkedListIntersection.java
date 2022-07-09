package Problems.Random.LinkedLists;

import Problems.Problem;

public class LinkedListIntersection extends Problem {
    @Override
    public void run() {
        System.out.println("Running Linked List Intersection");
        int[][] input = new int[][]{{1,2,3,4,5,6,7,8}, {5,6,7,8},
                                    {1}, {2}, {1,2,3,4}, {5,6,7,8}, {1}, {0,1}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i+2) {
            SinglyLinkedList<Integer> sll1 = LinkedListUtils.generateListFromArray(input[i]);
            System.out.println("List 1: ");
            sll1.printList();
            SinglyLinkedList<Integer> sll2 = LinkedListUtils.generateListFromArray(input[i+1]);
            System.out.println("List 2: ");
            sll2.printList();
            System.out.println("Intersecting At: " + this.getIntersection(sll1, sll2));
        }
    }

    private int getLength(SinglyLinkedList<Integer>.Node curr) {
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.nextNode;
        }
        return count;
    }

    private int getIntersection(SinglyLinkedList<Integer> sll1, SinglyLinkedList<Integer> sll2) {
        if (sll1.headNode == null || sll2.headNode == null) return -1;
        SinglyLinkedList<Integer>.Node curr1 = sll1.headNode;
        SinglyLinkedList<Integer>.Node curr2 = sll2.headNode;
        int len1 = this.getLength(curr1);
        int len2 = this.getLength(curr2);
        int diff = Math.abs(len1 - len2);
        if (len2 > len1) {
            SinglyLinkedList<Integer>.Node temp = curr1;
            curr1 = curr2;
            curr2 = temp;
        }
        while (diff > 0) {
            curr1 = curr1.nextNode;
            diff--;
        }
        while (curr1 != null) {
            if (curr1.data == curr2.data) return curr1.data;
            curr1 = curr1.nextNode;
            curr2 = curr2.nextNode;
        }
        return -1;
    }
}
