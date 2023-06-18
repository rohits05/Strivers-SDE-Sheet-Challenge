import java.io.*;
import java.util.*;

/****************************************************************
 * 
 * Following is the class structure of the Node class:
 * 
 * class Node
 * {
 * public:
 * int data;
 * Node *next;
 * Node(int data)
 * {
 * this->data = data;
 * this->next = NULL;
 * }
 * };
 * 
 *****************************************************************/

public class Solution {
    public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
        // Write your code here.
        if (n < 1 || head == null || head.next == null)
            return head;
        Node prev = null;
        Node curr = head;
        Node nex = curr.next;

        int len = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        for (int i = 0; i < n; i++) {
            Node last = prev;
            Node newEnd = curr;
            int k = 0;
            if (b[i] == 0)
                continue;
            if (b[i] < len) {
                k = b[i];
                len -= b[i];
            } else {
                k = len;
                len -= k;
            }

            for (int j = 0; curr != null && j < k; j++) {
                curr.next = prev;
                prev = curr;
                curr = nex;
                if (nex != null) {
                    nex = nex.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = curr;
            prev = newEnd;
            if (len == 0)
                break;
        }
        return head;
    }
}