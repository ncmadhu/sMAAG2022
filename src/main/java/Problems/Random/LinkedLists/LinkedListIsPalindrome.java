package Problems.Random.LinkedLists;

import Problems.Problem;

public class LinkedListIsPalindrome extends Problem {
    @Override
    public void run() {
        System.out.println("Running Linked List Is Palindrome");
        int[][] input = new int[][]{{1,2,3,4,4,3,2,1}, {1,2,3,4,5,4,3,2,1},
                                    {1,2,3,4,5,6,7,8}, {1,2,3,4,5,6,7,8,9}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            SinglyLinkedList<Integer> sll = LinkedListUtils.generateListFromArray(input[i]);
            sll.printList();
            System.out.println("Is Palindrome: " + this.isPalindrome(sll));
        }
    }

    private boolean isPalindrome(SinglyLinkedList<Integer> sll) {
        if (sll == null) return false;
        SinglyLinkedList<Integer>.Node slow = sll.headNode;
        SinglyLinkedList<Integer>.Node fast = sll.headNode;
        while (fast.nextNode != null) {
            fast = fast.nextNode.nextNode;
            if (fast == null) break;
            slow = slow.nextNode;
        }
        SinglyLinkedList<Integer>.Node curr = slow.nextNode;
        SinglyLinkedList<Integer>.Node prev = null;
        while (curr != null) {
            SinglyLinkedList<Integer>.Node temp = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = temp;
        }
        curr = sll.headNode;
        SinglyLinkedList<Integer>.Node mid = prev;
        while (mid != null) {
            if (curr.data != mid.data) return false;
            curr = curr.nextNode;
            mid = mid.nextNode;
        }
        return true;
    }
}
