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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        ListNode before = null;
        int pos = 1;

        if (left == right) {
            return head;
        }

        while (pos < left) {
            before = temp;
            temp = temp.next;
            pos++;
        }
        ListNode curr = temp;
        ListNode prev = null;
        int times = right - left + 1;
        
        while (times != 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            times--;
        }
        temp.next = curr;
        
        if (before == null) {
            head = prev;
        } else {
            before.next = prev;
        }
        
        return head;
        
    }
}