package com.bruis.algorithminjava.datastructures.stack;


import com.bruis.algorithminjava.datastructures.array.MyArray;

/**
 * @author LuoHaiYang
 */
public class MyStack<E> implements Stack<E> {

    private MyArray<E> array;

    public MyStack(int capacity){
        array = new MyArray<>(capacity);
    }

    public MyStack(){
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
     * [a, b, c, d, ...,  z] <- addLast
     *
     * @param e
     */
    @Override
    public void push(E e) {
        // 由于栈是先进后出的数据结构，所以需要调用array的addLast
        array.addLast(e);
    }

    /**
     * [a, b, c, d, ...,  z] -> removeLast
     *
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
