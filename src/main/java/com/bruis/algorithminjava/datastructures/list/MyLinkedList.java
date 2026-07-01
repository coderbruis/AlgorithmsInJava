package com.bruis.algorithminjava.datastructures.list;

import java.util.Objects;

/**
 * @Author : haiyang.luo
 * @Date : 2026/6/26 16:06
 * @Description :
 */
public class MyLinkedList<E> {

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // 往链表头添加节点
    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    // a->b->c->d->e
    // 0  1  2  3  4
    //       ^
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node node = new Node(e);
            // node -> c
            node.next = prev.next;
            // b -> node            => b -> node -> c
            prev.next = node;
//            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    // 往链表尾部添加节点
    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public boolean contains(E e) {
        Node cur = head;
        while (cur != null) {
            if (Objects.equals(cur.e, e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        Node delNode;
        if (index == 0) {
            delNode = head;
            head = head.next;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            delNode = prev.next;
            prev.next = delNode.next;
        }

        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        if (isEmpty()) {
            return;
        }

        if (Objects.equals(head.e, e)) {
            removeFirst();
            return;
        }

        Node prev = head;
        while (prev.next != null) {
            if (Objects.equals(prev.next.e, e)) {
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                size--;
                return;
            }
            prev = prev.next;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            res.append(cur.e).append(" -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    private class Node {

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }
}
