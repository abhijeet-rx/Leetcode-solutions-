// Problem: Middle of the Linked List
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/middle-of-the-linked-list/
// Solved on: 2026-09-05T16:53:36.950Z

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
            if(fast!=null){
            fast = fast.next;

            }
        }
       return slow;
        
    }
}