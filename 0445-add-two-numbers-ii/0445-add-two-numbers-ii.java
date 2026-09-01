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

    private ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode current = head;

    while (current != null) {
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }

    return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode DummyNode = new ListNode(-1);
        ListNode current = DummyNode;

        int carry = 0;

        while(t1 != null || t2 != null) {
            int sum = carry;

            if (t1 != null) {
                sum += t1.val;
            }

            if (t2 != null) {       
                sum += t2.val;
            }

            ListNode newNode = new ListNode(sum % 10);

            carry = sum / 10;
            newNode.next = current.next;
            current.next = newNode;

            if (t1 != null) {
                t1 = t1.next;
            }

            if (t2 != null) {       
                t2 = t2.next;
            }
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = current.next;
            current.next = newNode;
        }
        return DummyNode.next;
    }
}