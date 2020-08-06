package com.bruis.algorithminjava.datastructures;

/**
 * @author LuoHaiYang
 */
public class MyQueue<E> implements Queue<E> {

    private MyArray<E> array;

    public MyQueue(int capacity) {
        array = new MyArray<>(capacity);
    }

    public MyQueue() {
        array = new MyArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * head              tail
     * [a, b, c, d, ...,  z] <- addLast
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     *                head              tail
     * removeFirst <- [a, b, c, d, ...,  z] <- addLast
     *
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
