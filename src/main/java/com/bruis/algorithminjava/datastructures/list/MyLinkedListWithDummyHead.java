package com.bruis.algorithminjava.datastructures.list;

import java.util.Objects;

/**
 * @Author : haiyang.luo
 * @Date : 2026/6/26 16:28
 * @Description :
 */
public class MyLinkedListWithDummyHead<E> {

    private Node dummyHead;
    private int size;

    public MyLinkedListWithDummyHead() {
        dummyHead = new Node();
        size = 0;
    }

    // ========================= 获取 =========================

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (null != cur) {
            if (Objects.equals(cur.getE(), e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        // 需要注意，从索引第一位开始遍历，所以需要：dummyHead.next
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // ========================= 获取 =========================

    // ========================= 添加 =========================

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    // ========================= 添加 =========================

    // ========================= 修改 =========================

    public void set(E e, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.setE(e);
    }

    // ========================= 修改 =========================

    // ========================= 删除 =========================

    public E removeElement(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.getE();
    }

    public void removeElement(E e) {
        Node prev = dummyHead;
        while (null != prev.next) {
            if (Objects.equals(prev.next.getE(), e)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next == null) {
            return;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
    }

    public E removeFirst() {
        return removeElement(0);
    }

    public E removeLast() {
        return removeElement(size - 1);
    }

    // ========================= 删除 =========================

    public void printList() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.e).append(" -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        MyLinkedListWithDummyHead<Integer> linkedList = new MyLinkedListWithDummyHead<Integer>();
        Integer[] values = {23, 14, 7, 68, 45, 91, 32, 10, 56, 80};

        for (Integer value : values) {
            linkedList.addLast(value);
        }

        System.out.println(linkedList.get(9));
        linkedList.set(99, 9);

        linkedList.printList();
    }

    private class Node {
        public E e;
        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public void setE(E e) {
            this.e = e;
        }

        public E getE() {
            return e;
        }
    }
}
