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
    public static int findIntersection(Node firstHead, Node secondHead) {
        // Write your code here
        if (firstHead == null || secondHead == null)
            return 0;

        Node ducky1 = firstHead;
        Node ducky2 = secondHead;

        while (ducky1 != ducky2) {
            // reseting pointer to another's head
            ducky1 = ducky1 == null ? secondHead : ducky1.next;
            ducky2 = ducky2 == null ? firstHead : ducky2.next;
        }
        return ducky1.data;
    }
}