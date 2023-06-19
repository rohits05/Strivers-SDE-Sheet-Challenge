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
    public static Node firstNode(Node head) {
        // Write your code here.
        if (head == null || head.next == null)
            return null;

        Node oneJump = head, twoJump = head;
        Node entry = head;

        while (twoJump.next != null && twoJump.next.next != null) {
            oneJump = oneJump.next;
            twoJump = twoJump.next.next;

            if (oneJump == twoJump) { // Got That Collision point
                while (oneJump != entry) {
                    oneJump = oneJump.next;
                    entry = entry.next;
                }
                return entry;
            }
        }

        return null;
    }
}