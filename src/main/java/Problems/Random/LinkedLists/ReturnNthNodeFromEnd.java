package Problems.Random.LinkedLists;

import Problems.Problem;

public class ReturnNthNodeFromEnd extends Problem {
    @Override
    public void run() {
        System.out.println("Running Return Nth Node From End Of List");
        int[][] input = new int[][]{{1, 1}, {2,1}, {5, 5}, {5, 3}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            SinglyLinkedList<Integer> sll = LinkedListUtils.insertNodesNTimes(input[i][0]);
            System.out.print("Input: ");
            sll.printList();
            System.out.println("Nth (" + input[i][1] + ") Node From End: " + this.nthNodeFromEnd(sll, input[i][1]));
        }
    }

    private int nthNodeFromEnd(SinglyLinkedList<Integer> sll, int n) {
        if (sll.isEmpty()) return -1;
        int k = 1;
        SinglyLinkedList<Integer>.Node ahead = sll.headNode;
        SinglyLinkedList<Integer>.Node behind = sll.headNode;
        while (ahead != null && k <= n) {
            ahead = ahead.nextNode;
            k++;
        }
        while (ahead != null) {
            ahead = ahead.nextNode;
            behind = behind.nextNode;
        }
        return behind.data;
    }
}
