/**
 * Remove Duplicates from an Unsorted Singly Linked List
 *
 * Problem:
 * Given the head of an unsorted singly linked list, remove all duplicate
 * values such that only the first occurrence of each value is preserved.
 * The operation must be done in-place using O(1) extra space.
 *
 * Approach:
 * Use a classic two-pointer method:
 *  - 'current' iterates through each node one by one.
 *  - For each 'current', a 'runner' pointer scans all subsequent nodes.
 *
 * Whenever runner.next has the same value as current:
 *      runner.next = runner.next.next   // skip duplicate
 *
 * Otherwise:
 *      runner = runner.next             // move runner forward
 *
 * This ensures all duplicates after each 'current' node are removed.
 * Time complexity is O(n²). Space is O(1).
 */

class Solution {

    private Node head;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void removeDuplicates() {

        Node current = head;   // pointer for each element

        // Outer loop: pick each node one by one
        while (current != null) {

            Node runner = current;   // scans ahead of current

            // Inner loop: remove all duplicates of current.value
            while (runner.next != null) {

                // Duplicate found → skip the node
                if (current.value == runner.next.value) {
                    runner.next = runner.next.next;
                } 
                // If not duplicate → move runner forward
                else {
                    runner = runner.next;
                }
            }

            // Move to next distinct element
            current = current.next;
        }
    }
}
