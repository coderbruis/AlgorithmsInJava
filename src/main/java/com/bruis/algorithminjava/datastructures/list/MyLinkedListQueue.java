package com.bruis.algorithminjava.datastructures.list;

import com.bruis.algorithminjava.datastructures.queue.Queue;

/**
 * 队列特性：先进先出，FIFO
 *
 * @Author : haiyang.luo
 * @Date : 2026/6/26 20:58
 * @Description :
 */
public class MyLinkedListQueue<E> implements Queue<E> {

    private Node head, tail;
    private int size;

    public MyLinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (null == tail) {
            tail = new Node(e);
            head = tail;
        } else {
            // head -> node
            //          ^
            //         (tail)

            // head -> node -> node2
            //                   ^
            //                 (tail)
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node delNode = head;
        head = head.next;
        delNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return delNode.getE();
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.getE();
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

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }
    }
}
