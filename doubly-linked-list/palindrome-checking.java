/**
 * Palindrome Check — Doubly Linked List (for-loop version)
 *
 * Problem:
 * Given the head and tail of a doubly linked list, determine whether the
 * sequence of node values forms a palindrome. The check must be done in
 * O(n) time and O(1) space without modifying the list structure.
 *
 * Approach:
 * A doubly linked list supports bidirectional traversal, enabling a clean
 * two-pointer technique:
 *
 *   left  → starts at head
 *   right → starts at tail
 *
 * Compare values from both ends for exactly length/2 iterations:
 *
 *     if (left.value != right.value) → not a palindrome
 *
 * After each comparison:
 *     left  = left.next
 *     right = right.prev
 *
 * If all mirrored pairs match, the list is a palindrome.
 *
 * Time: O(n)
 * Space: O(1)
 */

class Node {
    int value;
    Node next;
    Node prev;

    Node(int value) {
        this.value = value;
    }

    Node(int value, Node next, Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList {

    Node head;
    Node tail;
    int length;

    public boolean isPalindrome() {

        if (head == null || head.next == null) return true;

        Node left = head;
        Node right = tail;

        // lengt/2 iterations is enough
        for (int i = 0; i < length / 2; i++) {

            if (left.value != right.value) {
                return false;       // mismatch → not palindrome
            }

            left = left.next;       // move forward
            right = right.prev;     // move backward
        }

        return true;                // all mirrored values matched
    }
}
