package com.bruis.algorithminjava.datastructures.list;

import java.util.Objects;

/**
 * 基于 MyLinkedList 实现的 LRU 缓存。淘汰最久未使用的数据。
 *
 * 链表头部保存最近使用的元素，链表尾部保存最久未使用的元素。
 *
 * @Author : haiyang.luo
 * @Date : 2026/6/30 10:00
 * @Description :
 */
public class MyLinkedListLRUCache<K, V> {

    private final int capacity;
    private final MyLinkedList<CacheEntry<K, V>> cache;

    public MyLinkedListLRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        this.capacity = capacity;
        this.cache = new MyLinkedList<>();
    }

    public int getSize() {
        return cache.getSize();
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return cache.isEmpty();
    }

    public boolean containsKey(K key) {
        return findIndex(key) != -1;
    }

    public V get(K key) {
        int index = findIndex(key);
        if (index == -1) {
            return null;
        }

        CacheEntry<K, V> entry = moveToFirst(index);
        return entry.getValue();
    }

    public void put(K key, V value) {
        int index = findIndex(key);
        if (index != -1) {
            CacheEntry<K, V> entry = cache.remove(index);
            entry.setValue(value);
            cache.addFirst(entry);
            return;
        }

        if (cache.getSize() == capacity) {
            cache.removeLast();
        }
        cache.addFirst(new CacheEntry<>(key, value));
    }

    public V remove(K key) {
        int index = findIndex(key);
        if (index == -1) {
            return null;
        }
        return cache.remove(index).getValue();
    }

    private CacheEntry<K, V> moveToFirst(int index) {
        CacheEntry<K, V> entry = cache.remove(index);
        cache.addFirst(entry);
        return entry;
    }

    private int findIndex(K key) {
        for (int i = 0; i < cache.getSize(); i++) {
            if (Objects.equals(cache.get(i).getKey(), key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return cache.toString();
    }

    public static void main(String[] args) {
        MyLinkedListLRUCache<Integer, String> lruCache = new MyLinkedListLRUCache<>(3);

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

    private static class CacheEntry<K, V> {
        private final K key;
        private V value;

        public CacheEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}
