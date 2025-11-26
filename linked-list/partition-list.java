/**
 * PARTITION LIST (LeetCode 86)
 * Leetcode: https://leetcode.com/problems/partition-list/description/
 *
 * Goal:
 *   Reorder the list so that all nodes with value < x come BEFORE all nodes
 *   with value >= x, while preserving original order within each group.
 *
 * Constraints:
 *   - Reuse existing nodes (O(1) extra space)
 *   - Stable partitioning (relative order must not change)
 *
 * Method:
 *   - Create two temporary lists:
 *        dummy1 → stores nodes < x
 *        dummy2 → stores nodes >= x
 *   - Traverse the original list once:
 *        If value < x → attach node to dummy1 list
 *        Else         → attach node to dummy2 list
 *   - Finally join dummy1 list with dummy2 list
 *   - Terminate dummy2 list with null to avoid cycles
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
}
class Solution {
    ListNode partition(ListNode head, int x) {
        // dummy1 holds all nodes < x
        // dummy2 holds all nodes >= x
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        // pointers to build each list
        ListNode beforeptr = dummy1;
        ListNode afterptr = dummy2;

        // Scan original list
        while (head != null) {

            if (head.val < x) {
                // attach node to "before" list
                beforeptr.next = head;
                beforeptr = beforeptr.next;

            } else {
                // attach node to "after" list
                afterptr.next = head;
                afterptr = afterptr.next;
            }

            // move to next node
            head = head.next;
        }

        // terminate the after-list
        afterptr.next = null;

        // connect both lists
        beforeptr.next = dummy2.next;

        // return start of the partitioned list
        return dummy1.next;
    }
}

