package com.bruis.algorithminjava.datastructures.stack;

/**
 * @author LuoHaiYang
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    // 移除元素
    E pop();
    E peek();
}
