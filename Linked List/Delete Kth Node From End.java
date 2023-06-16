/****************************************************************
 * 
 * Following is the class structure of the Node class:
 * 
 * class Node {
 * public int data;
 * public Node next;
 * public Node prev;
 * 
 * Node()
 * {
 * this.data = 0;
 * this.next = null;
 * this.prev = null;
 * }
 * 
 * Node(int data)
 * {
 * this.data = data;
 * this.next = null;
 * this.prev = null;
 * }
 * 
 * Node(int data, Node next)
 * {
 * this.data = data;
 * this.next = next;
 * this.prev = next;
 * }
 * };
 * 
 *****************************************************************/

public class Solution {
    public static Node removeKthNode(Node head, int K) {
        // Write your code here.
        Node ducky = new Node();
        ducky.next = head;

        Node fast = ducky;
        Node slow = ducky;

        for (int i = 1; i <= K; i++)
            fast = fast.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return ducky.next;
    }
}