package Problems.Random.LinkedLists;

import Problems.Problem;

import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find Union And Intersection Of Linked List");
        int[][] input = new int[][]{{7, 14, 21, 22}, {14, 15, 16}, {15, 22, 8}, {7, 14, 22}, {14,15,16}, {16, 15}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            SinglyLinkedList<Integer> sll1 = LinkedListUtils.generateListFromArray(input[i]);
            System.out.print("List 1: ");
            sll1.printList();
            SinglyLinkedList<Integer> sll2 = LinkedListUtils.generateListFromArray(input[i + 1]);
            System.out.print("List 2: ");
            sll2.printList();
            SinglyLinkedList<Integer> intersection;
            intersection = this.intersection(sll1,sll2);
            System.out.print("Intersection: ");
            intersection.printList();
            SinglyLinkedList<Integer> union;
            union = this.union(sll1,sll2);
            System.out.print("Union: ");
            union.printList();
        }
    }

    private SinglyLinkedList<Integer> union(SinglyLinkedList<Integer> sll1, SinglyLinkedList<Integer> sll2) {
        SinglyLinkedList<Integer> union = new SinglyLinkedList<>();
        if (sll1 == null && sll2 == null) return union;
        if (sll2 == null) return sll1;
        if (sll1 == null) return sll2;
        Set<Integer> alreadyPresent = new HashSet<>();
        SinglyLinkedList<Integer>.Node curr = sll1.headNode;
        SinglyLinkedList<Integer>.Node prev = null;
        while (curr != null) {
            if (!alreadyPresent.contains(curr.data)) union.insertAtEnd(curr.data);
            alreadyPresent.add(curr.data);
            curr = curr.nextNode;
        }
        curr = sll2.headNode;
        while (curr != null) {
            if (!alreadyPresent.contains(curr.data)) union.insertAtEnd(curr.data);
            alreadyPresent.add(curr.data);
            curr = curr.nextNode;
        }
        return union;
    }

    private SinglyLinkedList<Integer> intersection(SinglyLinkedList<Integer> sll1, SinglyLinkedList<Integer> sll2) {
        SinglyLinkedList<Integer> intersection = new SinglyLinkedList<>();
        if (sll1 == null || sll2 == null) {
            return intersection;
        }
        Set<Integer> alreadyPresent = new HashSet<>();
        SinglyLinkedList<Integer>.Node curr = sll1.headNode;
        while (curr != null) {
            alreadyPresent.add(curr.data);
            curr = curr.nextNode;
        }
        curr = sll2.headNode;
        while (curr != null) {
            if (alreadyPresent.contains(curr.data)) {
                intersection.insertAtEnd(curr.data);
            }
            curr = curr.nextNode;
        }
        return intersection;
    }
}
