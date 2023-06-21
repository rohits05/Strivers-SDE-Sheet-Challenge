import java.io.*;
import java.util.*;

/*************************************************************
 * 
 * Following is the LinkedListNode class structure
 * 
 * class LinkedListNode<T> {
 * T data;
 * LinkedListNode<T> next;
 * LinkedListNode<T> random;
 * 
 * public LinkedListNode(T data) {
 * this.data = data;
 * }
 * }
 * 
 *************************************************************/

public class Solution {
    public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
        // Write your code here.
        LinkedListNode<Integer> iter = head;
        LinkedListNode<Integer> front = head;
        // 1st Case
        while (iter != null) {
            front = iter.next;
            LinkedListNode copy = new LinkedListNode(iter.data);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }

        // 2nd Case
        iter = head;
        while (iter != null) {
            if (iter.random != null)
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }

        // 3rd Case
        iter = head;
        LinkedListNode pseudoHead = new LinkedListNode(0);
        LinkedListNode copy = pseudoHead;

        while (iter != null) {
            front = iter.next.next;
            copy.next = iter.next;
            copy = copy.next;
            iter.next = front;
            iter = front;
        }
        return pseudoHead.next; // head one
    }
}
