package Problems.Random.LinkedLists;

import java.security.PublicKey;

public class LinkedListUtils {

    public static <T> SinglyLinkedList insertNodesNTimes(int n) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            sll.insertAtEnd(i);
        }
        return sll;
    }

    public static SinglyLinkedList<Integer> generateListFromArray(int[] arr) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            sll.insertAtEnd(arr[i]);
        }
        return sll;
    }

    public static <T> void loopToNthNode(SinglyLinkedList<T> sll, int n) {
        if (sll.isEmpty()) return;
        int count = 1;
        SinglyLinkedList<T>.Node curr = sll.headNode;
        SinglyLinkedList<T>.Node loopStart = null;
        while (curr != null && curr.nextNode != null) {
            if (count == n) loopStart = curr;
            count += 1;
            curr = curr.nextNode;
        }
        curr.nextNode = loopStart;
    }

    public static <T> DoublyLinkedList generateDoublyLinkedListFromArray(int[] arr) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            dll.insertAtTail(arr[i]);
        }
        return dll;
    }

}
