import java.util.*;
import java.io.*;

/****************************************************************
 * 
 * Following is the class structure of the Node class:
 * 
 * class LinkedListNode {
 * int data;
 * LinkedListNode next;
 * 
 * public LinkedListNode(int data) {
 * this.data = data;
 * }
 * }
 * 
 *****************************************************************/

public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        // Write your code here.
        LinkedListNode dummyHead = new LinkedListNode(0);
        LinkedListNode head = dummyHead;
        int carry = 0;

        while (head1 != null || head2 != null) {
            int val1 = head1 == null ? 0 : head1.data; // tnc
            int val2 = head2 == null ? 0 : head2.data;

            int sum = val1 + val2 + carry;
            head.next = new LinkedListNode(sum % 10); // opt
            carry = sum / 10;
            head = head.next;

            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;
        }

        if (carry > 0)
            head.next = new LinkedListNode(carry); // fwd carry
        return dummyHead.next;
    }
}