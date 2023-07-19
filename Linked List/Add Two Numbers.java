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
class Solution { // Always getting an unknown error at the Coding Ninjas site for the Java solution only. So, I've performed it on Leetcode.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        int carry = 0;
        
        while(l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val; // tnc
            int val2 = l2 == null ? 0 : l2.val;
            
            int sum = val1 + val2 + carry;
            head.next = new ListNode(sum % 10); // opt
            carry = sum / 10;
            head = head.next;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(carry > 0) head.next = new ListNode(carry); // fwd carry
        return dummyHead.next;
    }
}
