package com.interviewbit.amazone.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /*
    Runtime: 67 ms, faster than 88.58% of Java online submissions for LRU Cache.
    Memory Usage: 116.5 MB, less than 89.29% of Java online submissions for LRU Cache.
     */
    private final Map<Integer, Node> cache = new HashMap<>();
    private int capacity;

    private Node head = new Node(0, 0);
    private Node tail = new Node(0, 0);

    private class Node {
        private Node prev;
        private Node next;
        private int value;
        private int key;

        public Node(int value, int key) {
            this.value = value;
            this.key = key;
        }
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        Node node = cache.get(key);
        delete(node);
        Node newNode = new Node(node.value, key);
        insert(newNode);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            delete(node);
        } else if (cache.size() == capacity) {
            delete(tail.prev);
        }
        Node node1 = new Node(value, key);
        insert(node1);
    }

    private void insert(Node node) {
        cache.put(node.key, node);
        Node nextHead = head.next;
        nextHead.prev = node;
        node.next = nextHead;

        head.next = node;
        node.prev = head;
    }

    private void delete(Node node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}
