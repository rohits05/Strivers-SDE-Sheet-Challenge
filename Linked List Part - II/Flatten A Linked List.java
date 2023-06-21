/****************************************************************
 * 
 * Following is the class structure of the Node class:
 * 
 * class Node {
 * public int data;
 * public Node next;
 * public Node child;
 * 
 * Node()
 * {
 * this.data = 0;
 * this.next = null;
 * this.child = null;
 * }
 * Node(int data)
 * {
 * this.data = data;
 * this.next = null;
 * this.child = null;
 * }
 * Node(int data, Node next, Node child)
 * {
 * this.data = data;
 * this.next = next;
 * this.child = child;
 * }
 * }
 * 
 *****************************************************************/

public class Solution {
    public static Node merge(Node prev, Node curr) {
        Node newhead = new Node(0);
        Node h = newhead;
        while (prev != null && curr != null) {
            if (prev.data < curr.data) {
                h.child = prev;
                h = h.child;
                prev = prev.child;
            } else {
                h.child = curr;
                h = h.child;
                curr = curr.child;
            }
        }

        if (prev != null)
            h.child = prev;
        else
            h.child = curr;
        return newhead.child;
    }

    public static Node flattenLinkedList(Node head) {
        Node prev = null;
        Node h = head;
        while (h != null) {
            Node next = h.next;
            Node curr = h;
            prev = merge(prev, curr);
            // edge case
            prev.next = null;
            curr.next = null;
            h = next;
        }
        return prev;
    }
}