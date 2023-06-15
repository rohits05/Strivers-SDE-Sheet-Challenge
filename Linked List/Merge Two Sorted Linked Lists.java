import java.io.*;
import java.util.*;

/************************************************************
 * 
 * Following is the linked list node structure:
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
 ************************************************************/

public class Solution {
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        // Write your code here.
        if (first == null)
            return second;
        if (second == null)
            return first;

        if (first.data > second.data) {
            LinkedListNode<Integer> swap = first;
            first = second;
            second = swap;
        }

        LinkedListNode<Integer> res = first;
        while (first != null & second != null) {
            LinkedListNode dummy = null;

            while (first != null && first.data <= second.data) {
                dummy = first;
                first = first.next;
            }
            dummy.next = second;

            LinkedListNode<Integer> temp = first;
            first = second;
            second = temp;
        }

        return res;
    }
}
