package com.bruis.algorithminjava.datastructures.list;

import com.bruis.algorithminjava.datastructures.stack.Stack;

/**
 *
 * 栈：先进后出，LIFO，Last In First Out
 *
 * @Author : haiyang.luo
 * @Date : 2026/6/26 19:41
 * @Description :
 */
public class MyLinkedListStack<E> implements Stack<E> {

    private MyLinkedListWithDummyHead<E> list;

    public MyLinkedListStack() {
        list = new MyLinkedListWithDummyHead<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }
}
