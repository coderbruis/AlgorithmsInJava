package com.bruis.algorithminjava.datastructures.list.lru;

/**
 * @Author : haiyang.luo
 * @Date : 2026/7/4 14:19
 * @Description :
 */
public class LocalLinkedList<K, V> {

    private LocalNode dummyHead;
    private LocalNode dummyTail;
    private int size;
    private int capacity;

    public LocalLinkedList(int capacity) {
        dummyHead = new LocalNode();
        dummyTail = new LocalNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.capacity = capacity;
    }

    /**
     * head <-> tail
     * head <-> node <-> tail
     * 还有一种就是链表中可能已经有节点了，所以不能直接用head和tail操作
     * @param node
     */
    public void addFirst(LocalNode node) {
        LocalNode first = dummyHead.next;

        dummyHead.next = node;
        first.prev = node;

        node.prev = dummyHead;
        node.next = first;
        size++;
    }

    public LocalNode addFirst(K key, V value) {
        LocalNode localNode = new LocalNode(key, value);
        addFirst(localNode);
        return localNode;
    }

    /**
     * head <-> node ... <-> delNode <-> tail
     *
     * @return
     */
    public LocalNode removeLast() {
        if (dummyHead.next == dummyTail) {
            throw new IllegalArgumentException("cache is empty.");
        }

        LocalNode delNode = dummyTail.prev;

        delNode.prev.next = dummyTail;
        dummyTail.prev = delNode.prev;

        delNode.next = null;
        delNode.prev = null;
        size--;
        return delNode;
    }

    /**
     * head <-> node <-> tail
     * @param node
     */
    public void removeNode(LocalNode node) {
        // 外层判断到map中一定包含这个node，所以链表中一定有这个node，所以用prev和next直接删除，时间复杂度为O(1)
        LocalNode delPrev = node.prev;

        delPrev.next = node.next;
        node.next.prev = delPrev;

        node.next = null;
        node.prev = null;
        size--;
    }

    /**
     * 移动到头部
     * @param node
     */
    public void moveToFirst(LocalNode node) {
        removeNode(node);
        addFirst(node);
    }

    public boolean listIsFull() {
        return size == capacity;
    }

    public class LocalNode {
        public V value;
        public K key;
        public LocalNode prev;
        public LocalNode next;

        public LocalNode() {}

        public LocalNode(K key, V value, LocalNode prev, LocalNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public LocalNode(K key, V value) {
            this(key, value, null, null);
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }
    }
}
