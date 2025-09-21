class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    ListNode kthFromEnd(int k, ListNode head) {

        if (head == null || k <= 0)
            return null; // list does not exist or invalid k

        ListNode fast = head;
        ListNode slow = head;

        // initially fast is k nodes ahead of slow
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }

            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }
}