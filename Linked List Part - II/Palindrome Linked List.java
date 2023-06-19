import java.util.*;
import java.io.*;

/****************************************************************
 * 
 * Following is the class structure of the LinkedListNode class:
 * 
 * class LinkedListNode<T> {
 * T data;
 * LinkedListNode<T> next;
 * 
 * public LinkedListNode(T data) {
 * this.data = data;
 * }
 * }
 * 
 *****************************************************************/

public class Solution {

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        // Write your code here!
        if (head == null || head.next == null)
            return true;
        LinkedListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedListNode temp = slow.next;
        slow.next = null;
        temp = reverseList(temp);
        while (head != null && temp != null) {
            if ((int) head.data != (int) temp.data)
                return false;
            head = head.next;
            temp = temp.next;
        }
        return true;
    }

    public static LinkedListNode reverseList(LinkedListNode<Integer> head) {
        LinkedListNode prev = null, next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}