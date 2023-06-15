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
 * Node(int data)
 * {
 * this.data = data;
 * this.next = null;
 * }
 * Node(int data, Node next)
 * {
 * this.data = data;
 * this.next = next;
 * }
 * }
 * 
 *****************************************************************/

public class Solution {
    public static Node findMiddle(Node head) {
        // Write your code here.
        if (head == null || head.next == null)
            return head;
        Node oneJump = head, twoJump = head;

        while (twoJump != null && twoJump.next != null) {
            oneJump = oneJump.next;
            twoJump = twoJump.next.next;
        }

        return oneJump;
    }
}