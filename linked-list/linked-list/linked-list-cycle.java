//LeetCode: https://leetcode.com/problems/linked-list-cycle/
//Problem: Determine if the given linked has a loop
//Approach: Fast and slow pointers that initially point to the header node. 
//          Fast traverses the list by two nodes and Slow traverses the list by one node.
//          Eventually Fast reaches the end of the list & breaks the loop => does not have a loop.
//          if fast and slow point to the same node => has a loop.

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // move 1 step
            fast = fast.next.next; // move 2 steps

            if (slow == fast) {
                return true; // cycle detected
            }
        }

        return false; // no cycle
    }
}
