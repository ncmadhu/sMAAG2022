package Problems.Random.LinkedLists;

import Problems.Problem;

public class ReArrangeLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running ReArrange Linked List");
        int[][] input = new int[][]{{3,0,5,2,1,4}, {3},
                                    {0,2,1,3,5,4}, {3},
                                    {0,1,2,3,3,3,3,4,5,6,7,8,9}, {3},
                                    {0,3,2,1,4,5,3,-1,-2,3,6,7,3,2,-9000}, {3},
                                    {0,3,2,1,4,5,3,-1,-2,3,6,7,3,2,-9000}, {2}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            SinglyLinkedList<Integer> sll = LinkedListUtils.generateListFromArray(input[i]);
            System.out.println("K: " + input[i+1][0]);
            System.out.println("Input: ");
            sll.printList();
            this.reArrangeLinkedList(sll,input[i+1][0]);
            System.out.println("Re Arranged: ");
            sll.printList();
        }
    }

    private void reArrangeLinkedList(SinglyLinkedList<Integer> sll, int k) {
        if (sll == null) return;
        SinglyLinkedList<Integer>.Node lesserHead = null;
        SinglyLinkedList<Integer>.Node lesserTail = null;
        SinglyLinkedList<Integer>.Node equalHead = null;
        SinglyLinkedList<Integer>.Node equalTail = null;
        SinglyLinkedList<Integer>.Node greaterHead = null;
        SinglyLinkedList<Integer>.Node greaterTail = null;
        SinglyLinkedList<Integer>.Node curr = sll.headNode;
        while (curr != null) {
            if (curr.data < k) {
                if (lesserHead == null) {
                    lesserHead = curr;
                } else {
                    lesserTail.nextNode = curr;
                }
                lesserTail = curr;
            } else if (curr.data > k) {
                if (greaterHead == null) {
                    greaterHead = curr;
                } else {
                    greaterTail.nextNode = curr;
                }
                greaterTail = curr;

            } else {
                if (equalHead == null) {
                    equalHead = curr;
                } else {
                    equalTail.nextNode = curr;
                }
                equalTail = curr;
            }
            curr = curr.nextNode;
        }
        if (greaterTail != null) {
            greaterTail.nextNode = null;
        }
        SinglyLinkedList<Integer>.Node tail = lesserTail;
        if (tail != null) {
            tail.nextNode = equalHead;
        }
        if (equalTail != null) {
            tail = equalTail;
        }
        if (tail != null) {
            tail.nextNode = greaterHead;
        }
        if (lesserHead != null) sll.headNode = lesserHead;
        else if (equalHead != null) sll.headNode = equalHead;
        else sll.headNode = greaterHead;
    }
}
