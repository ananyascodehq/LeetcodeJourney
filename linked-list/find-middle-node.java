//LeetCode: https://leetcode.com/problems/middle-of-the-linked-list/description/
//Problem: Find the middle element of the given linkedlist
//Approach: Fast and slow pointers that initially point to the header node. 
//          Fast traverses the list by two nodes and Slow traverses the list by one node.
//          Eventually Fast reaches the end of the list & breaks the loop.
//          and slow is returned.

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}