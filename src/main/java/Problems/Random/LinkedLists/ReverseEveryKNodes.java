package Problems.Random.LinkedLists;

import Problems.Problem;

public class ReverseEveryKNodes extends Problem {
    @Override
    public void run() {
        System.out.println("Running Reverse Every K Nodes");
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
            this.reverseEveryKNodes(sll, input[i][1]);
            sll.printList();
        }
    }

    private <T> void reverseEveryKNodes(SinglyLinkedList<T> sll, int k) {
        if (sll.isEmpty() || k <= 1) return;
        SinglyLinkedList<T>.Node newHead = null;
        SinglyLinkedList<T>.Node prevTail = null;
        SinglyLinkedList<T>.Node curr = sll.headNode;
        while (curr != null) {
            // Point the node to null temporarily so that reverse start node will point next node to null
            // Reverse start node will become prevTail and its next node will be set in the next iteration
            SinglyLinkedList<T>.Node prev = null;
            // The reverse starting node will become the tail after reversing. Hence, it is set as currTail
            SinglyLinkedList<T>.Node currTail = curr;
            int n = k;
            while (n > 0 && curr != null) {
                SinglyLinkedList<T>.Node temp = curr.nextNode;
                curr.nextNode = prev;
                prev = curr;
                curr = temp;
                n--;
            }
            if (newHead == null) newHead = prev; // Reset the head node once
            // Point the next node of reverse start node which we set null above
            if (prevTail != null) prevTail.nextNode = prev;
            prevTail = currTail; // Reset the prevTail
        }
        sll.headNode = newHead;
    }
}
