package com.bruis.algorithminjava.datastructures.queue;

/**
 * @author LuoHaiYang
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    // 进队
    void enqueue(E e);
    // 移除队列
    E dequeue();
    // 获取队列首个元素
    E getFront();
}
