package Problems.Random.LinkedLists;

import Problems.Problem;

public class ReverseAlternateKNodes extends Problem {
    @Override
    public void run() {
        System.out.println("Running Reverse Alternate K Nodes");
        int[][] input = new int[][]{{5,2}, {6,3}, {5,1}, {5,0}, {10,11}, {8,3}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            SinglyLinkedList<Integer> sll = LinkedListUtils.insertNodesNTimes(input[i][0]);
            System.out.println("Input List: ");
            sll.printList();
            System.out.println("K: " + input[i][1]);
            System.out.println("Output: ");
            this.reverseAlternateKNodes(sll, input[i][1]);
            sll.printList();
        }
    }

    private <T> void reverseAlternateKNodes(SinglyLinkedList<T> sll, int k) {
        if (sll.isEmpty() || k <= 1) return;
        SinglyLinkedList<T>.Node newHead = null;
        SinglyLinkedList<T>.Node prevTail = null;
        SinglyLinkedList<T>.Node curr = sll.headNode;
        int n;

        while (curr != null) {
            SinglyLinkedList<T>.Node currTail = curr;
            SinglyLinkedList<T>.Node prev = null;
            n = k;
            while (n > 0 && curr != null) {
                SinglyLinkedList<T>.Node temp = curr.nextNode;
                curr.nextNode = prev;
                prev = curr;
                curr = temp;
                n--;
            }
            if (newHead == null) newHead = prev;
            if (prevTail != null) prevTail.nextNode = prev;
            prevTail = currTail;
            prevTail.nextNode = curr;
            n = k;
            while (n > 0 && curr != null) {
                prev = curr;
                curr = curr.nextNode;
                n--;
            }
            prevTail = prev;
        }
        sll.headNode = newHead;
    }
}
