package com.bruis.algorithminjava.datastructures.list;

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
        head = new Node(e);
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







    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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
