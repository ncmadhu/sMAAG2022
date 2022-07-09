package Problems.Random.LinkedLists;

import Problems.Problem;

public class RotateLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Rotate Linked List");
        int[][] input = new int[][]{{1,2,3,4,5,6,7,8,9,10} , {2},
                                    {1,2,3,4,5,6,7,8,9,10} , {-2},
                                    {1,2,3,4,5,6,7,8,9,10} , {12},
                                    {1,2,3,4,5,6,7,8,9,10} , {-12},
                                    {1,2,3,4,5,6,7,8,9,10,11} , {2},
                                    {1,2,3,4,5,6,7,8,9,10,11} , {-2},
                                    {1,2,3,4,5}, {2},
                                    {1,2,3,4,5}, {-2},
                                    {1,2,3,4,5}, {1},
                                    {1,2,3,4,5}, {0},
                                    {1,2,3}, {3},
                                    {1,2,3}, {-3}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            SinglyLinkedList<Integer> sll = LinkedListUtils.generateListFromArray(input[i]);
            sll.printList();
            System.out.println("n : " + input[i+1][0]);
            this.rotateList(sll, input[i+1][0]);
            sll.printList();
        }
    }

    private void rotateList(SinglyLinkedList<Integer> sll, int k) {
        if (sll == null || k == 0) return;
        int size = 1;
        SinglyLinkedList<Integer>.Node curr = sll.headNode;
        while (curr.nextNode != null) {
            curr = curr.nextNode;
            size++;
        }
        if (Math.abs(k) > size) {
            k = k % size;
        }
        // < 0 counter clock wise
        if (k < 0) k = Math.abs(k);
        else k = size - k;
        if (k == 0) return;
        // Make the list circular
        curr.nextNode = sll.headNode;
        curr = sll.headNode;
        for (int i = 1; i < k; i++) {
            curr = curr.nextNode;
        }
        sll.headNode = curr.nextNode;
        curr.nextNode = null;
    }
}
