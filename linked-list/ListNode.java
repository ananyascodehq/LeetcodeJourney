// Leetcode: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
// Problem: Convert Binary Number in a Linked List to Integer
// approach: Traverse through the linked-list using cur, the final value is: for each node in the linked list, value = value*2 + bit value.

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int getDecimalValue(ListNode head) {
        int value = 0;
        ListNode cur = head;

        while (cur != null) {
            value = value * 2 + cur.val;
            cur = cur.next;
        }

        return value;
    }
}