/**
 * LeetCode: https://leetcode.com/problems/reverse-linked-list-ii
 * Problem: Reverse a sublist of a singly-linked list from position startIndex
 * to endIndex (0-based),
 * reversing the nodes in-place without using extra space.
 *
 * Approach:
 * - Use a dummy node to standardize handling of edge cases where the reversal
 * starts at head.
 * - Traverse to the node just before startIndex (previousNode).
 * - Reverse the sublist using the classic "front-insertion" technique:
 * repeatedly remove the node after currentNode and insert it immediately after
 * previousNode.
 * - Return dummy.next as the new head.
 *
 * Time Complexity: O(n) – single traversal and pointer manipulation.
 * Space Complexity: O(1) – in-place reversal.
 */

class Node {
    int val;
    Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public Node reverseBetween(Node head, int startIndex, int endIndex) {

        // If list empty or range invalid, return original head
        if (head == null)
            return null;

        // Dummy node to simplify head-handling cases
        Node dummyNode = new Node(0);
        dummyNode.next = head;

        // Step 1: Move previousNode to (startIndex - 1)
        Node previousNode = dummyNode;
        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        // First node inside the range to reverse
        Node currentNode = previousNode.next;

        // Step 2: Reverse (endIndex - startIndex) links
        // We repeatedly take `nodeToMove` (the node after currentNode)
        // and insert it immediately after previousNode
        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next; // Node to reposition
            currentNode.next = nodeToMove.next; // Remove nodeToMove from its current position
            nodeToMove.next = previousNode.next; // Insert nodeToMove after previousNode
            previousNode.next = nodeToMove; // Update previousNode's next pointer
        }

        // New head of the updated list
        return dummyNode.next;
    }
}
