package com.bruis.algorithminjava.datastructures.list.lru;


import java.util.HashMap;

/**
 * @Author : haiyang.luo
 * @Date : 2026/7/4 14:46
 * @Description :
 */
public class LocalLRUCache<K, V> {

    private LocalLinkedList<K, V> linkedList;
    private HashMap<K, LocalLinkedList<K, V>.LocalNode> map;

    public LocalLRUCache(int capacity) {
        linkedList = new LocalLinkedList<>(capacity);
        map = new HashMap<>();
    }

    public LocalLRUCache() {
        this(10);
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        LocalLinkedList<K, V>.LocalNode localNode = map.get(key);
        linkedList.moveToFirst(localNode);
        return localNode.getValue();
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            LocalLinkedList<K, V>.LocalNode localNode = map.get(key);
            localNode.setValue(value);
            linkedList.moveToFirst(localNode);
        } else {
            if (linkedList.listIsFull()) {
                LocalLinkedList<K, V>.LocalNode localNode = linkedList.removeLast();
                map.remove(localNode.getKey());
            }
            LocalLinkedList<K, V>.LocalNode localNode = linkedList.addFirst(key, value);
            map.put(key, localNode);
        }
    }
}
