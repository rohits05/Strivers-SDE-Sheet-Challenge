/****************************************************************
 * 
 * Following is the class structure of the Node class:
 * 
 * class Node {
 * public int data;
 * public Node next;
 * 
 * Node()
 * {
 * this.data = 0;
 * this.next = null;
 * }
 * 
 * Node(int data)
 * {
 * this.data = data;
 * this.next = null;
 * }
 * 
 * Node(int data, Node next)
 * {
 * this.data = data;
 * this.next = next;
 * }
 * };
 * 
 *****************************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        // Write your code here.
        if (head == null || head.next == null || k == 0)
            return head;
        Node ducky = head;
        int len = 1;

        while (ducky.next != null) {
            len++;
            ducky = ducky.next;
        }

        ducky.next = head;
        k = len - k % len;
        // k = k % len;
        // k = len - k;

        while (k-- > 0)
            ducky = ducky.next;
        head = ducky.next;
        ducky.next = null;

        return head;
    }
}