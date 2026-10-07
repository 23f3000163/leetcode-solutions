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
    static void reverse(ListNode left, int times) {
        ListNode curr = left;
        ListNode prev = null;

        while (times != 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            times--;
        }
        return;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode left = head;
        ListNode right;
        ListNode prevLeft = null;
        ListNode result = null;

        int times = 2;
        
        while (true) {
            right = left;

            for (int i = 0; i < (times - 1); i++) {
                if (right == null) {
                    break;
                }
                right = right.next;
            }

            if (right != null) {
                ListNode nextLeft = right.next;
                reverse(left, times);

                if (prevLeft != null) {
                    prevLeft.next = right;
                }
                prevLeft = left;

                if (result == null) {
                    result = right;
                }
                left = nextLeft;
            } 
            else {
                if (prevLeft != null) {
                    prevLeft.next = left;
                }
                if (result == null) {
                    result = left;
                }    
                break;
            }
        }
        return result;
    }
}