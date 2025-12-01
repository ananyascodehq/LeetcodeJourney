/**
 * Doubly Linked List — Reverse Entire List
 *
 * Problem:
 * Given the head of a doubly linked list (each node has 'next' and 'prev'),
 * reverse the list in-place so that the traversal order becomes opposite.
 * You must reverse the node pointers (not values) and must use O(1) extra space.
 *
 * Approach:
 * Iterate through the list using a pointer 'current'. For each node,
 * swap its next and prev pointers:
 *      temp = current.prev
 *      current.prev = current.next
 *      current.next = temp
 *
 * After swapping, move current to current.prev because that pointer now
 * represents the original 'next' node before reversal.
 *
 * When current becomes null, all nodes are reversed. Finally, swap the
 * head and tail references of the list to finalize the reversal.
 */

class Node {
    int value;
    Node next;
    Node prev;

    Node() { }

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

    void reverse() {

        // Edge case: empty list or single-node list
        if (head == null || head.next == null) return;

        Node current = head;
        Node temp = null;

        // Flip next and prev pointers for each node
        while (current != null) {

            temp = current.prev;     // store prev temporarily
            current.prev = current.next;
            current.next = temp;

            current = current.prev;  // move to original next node
        }

        // temp.prev is the new head after full reversal
        if (temp != null) {
            head = temp.prev;
        }

        // Swap head and tail references
        Node swap = head;
        head = tail;
        tail = swap;
    }
}
