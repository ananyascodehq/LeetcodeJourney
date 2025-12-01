/**
 * LeetCode — Palindrome Number https://leetcode.com/problems/palindrome-number/
 *      
 * Problem:
 *    Determine whether an integer is a palindrome without converting it to a string.
 *
 * Approach:
 *    - Reject negatives immediately (can't be palindromes).
 *    - If a number ends in 0 (but isn't 0), it's not a palindrome.
 *    - Reverse the integer digit-by-digit.
 *    - Compare reversed value with original.
 *
 * Time Complexity:  O(log₁₀ n)       // number of digits
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isPalindrome(int x) {

        // negative → not a palindrome
        if (x < 0) return false;

        // ending with 0 but not 0 → impossible palindrome
        if (x % 10 == 0 && x != 0) return false;

        int temp = x;      
        int dup = 0;       

        // construct reversed number
        while (temp != 0) {
            int y = temp % 10;     // extract last digit
            temp = temp / 10;      // drop it
            dup = dup * 10 + y;    // append to reversed
        }

        return dup == x;
    }
}
