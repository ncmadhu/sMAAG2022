package Problems.Random.LinkedLists;

import java.security.PublicKey;

public class LinkedListUtils {

    public static <T> SinglyLinkedList insertNodesNTimes(int n) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            sll.insertAtEnd(i);
        }
        return sll;
    }
}
