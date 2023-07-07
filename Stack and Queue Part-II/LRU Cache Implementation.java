import java.util.*;
import java.io.*;

public class LRUCache {
    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap();
    int cap;

    LRUCache(int capacity) {
        // Write your code here
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // Write your code here
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        // Write your code here
        if (map.containsKey(key))
            remove(map.get(key));
        if (map.size() == cap)
            remove(tail.prev);

        insert(new Node(key, value));
    }

    class Node {
        Node prev, next;
        int key, value;

        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
}
