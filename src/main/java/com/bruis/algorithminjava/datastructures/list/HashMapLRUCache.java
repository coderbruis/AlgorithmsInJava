package com.bruis.algorithminjava.datastructures.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于 HashMap + 双向链表实现的 LRU 缓存。
 *
 * HashMap 用于 O(1) 定位节点，双向链表用于 O(1) 刷新访问顺序和淘汰尾部节点。
 *
 * @Author : haiyang.luo
 * @Date : 2026/6/30 10:30
 * @Description :
 */
public class HashMapLRUCache<K, V> {

    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final Node<K, V> dummyHead;
    private final Node<K, V> dummyTail;

    public HashMapLRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.dummyHead = new Node<>();
        this.dummyTail = new Node<>();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int getSize() {
        return map.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }

        moveToFirst(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToFirst(node);
            return;
        }

        if (map.size() == capacity) {
            Node<K, V> removedNode = removeLast();
            map.remove(removedNode.key);
        }

        Node<K, V> newNode = new Node<>(key, value);
        addFirst(newNode);
        map.put(key, newNode);
    }

    public V remove(K key) {
        Node<K, V> node = map.remove(key);
        if (node == null) {
            return null;
        }

        removeNode(node);
        return node.value;
    }

    private void moveToFirst(Node<K, V> node) {
        removeNode(node);
        addFirst(node);
    }

    /*
        dummyHead <-> node <-> A <-> B

        node.prev = dummyHead                   相当于  dummyHead <- node
        node.next = dummyHead.next              相当于  node -> A
        这样，链表就成了：dummyHead <- node -> A

        dummyHead.next.prev = node              相当于  node <- A
        dummyHead.next = node                   相当于  dummyHead -> node
        这样，链表就成了：dummyHead -> node <- A

        最终上面四步合在一起就是：dummyHead <-> node <-> A
     */
    private void addFirst(Node<K, V> node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    /*
        A <-> node <-> B

        node.prev.next = node.next              相当于：A -> B，断掉了 node -> B
        node.next.prev = node.prev              相当于：A <- B，断掉了 A <- node

        node.prev = null
        node.next = null

        最终结果：A <-> B
     */
    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private Node<K, V> removeLast() {
        Node<K, V> lastNode = dummyTail.prev;
        removeNode(lastNode);
        return lastNode;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node<K, V> cur = dummyHead.next;
        while (cur != dummyTail) {
            res.append(cur.key).append("=").append(cur.value).append(" -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        HashMapLRUCache<Integer, String> lruCache = new HashMapLRUCache<>(3);

        lruCache.put(1, "A");
        lruCache.put(2, "B");
        lruCache.put(3, "C");
        System.out.println(lruCache);

        lruCache.get(1);
        System.out.println(lruCache);

        lruCache.put(4, "D");
        System.out.println(lruCache);

        lruCache.put(1, "A1");
        System.out.println(lruCache);
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> prev;
        private Node<K, V> next;

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
