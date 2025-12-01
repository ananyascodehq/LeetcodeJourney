/**
 * LeetCode 24 — Swap Nodes in Pairs
 *
 * Problem:
 * Given the head of a singly linked list, swap every two adjacent nodes
 * and return the modified list. You must swap nodes themselves (not just values)
 * and must do it using O(1) extra space.
 *
 * Approach:
 * Use a dummy node to simplify pointer handling when the head changes.
 * Iterate pair-by-pair using a 'prev' pointer that always points to the node
 * before the pair being swapped.
 *
 * For each pair (first, second):
 *   prev.next = second
 *   first.next = second.next
 *   second.next = first
 * After swapping, move prev to 'first' (which is now the end of the swapped pair).
 *
 * Stop when fewer than 2 nodes remain.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() { }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    ListNode swapPairs(ListNode head) {

        // Dummy node ensures seamless handling of head swaps
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        // Continue while at least 2 nodes remain to swap
        while (prev.next != null && prev.next.next != null) {

            ListNode first = prev.next;        // node1
            ListNode second = first.next;      // node2

            // Swap the pair
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move prev to the end of the swapped pair
            prev = first;
        }

        return dummy.next; // new head after all swaps
    }
}
