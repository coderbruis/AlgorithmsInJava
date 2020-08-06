package com.bruis.algorithminjava.algorithm;

import java.util.Stack;

/**
 * @author LuoHaiYang
 *
 * @Date 2020.05.13
 *
 * url: https://leetcode-cn.com/problems/min-stack/
 *
 *
 */
public class MinStack {

    /**
     * 问题：
     * 1. 用什么基础数据结构来存储数据？  普遍解法都是通过已有数据结构stack来解决
     * 2. 如何自己实现一个栈结构？
     */

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            int top = minStack.peek();
            //小于的时候才入栈
            if (x <= top) {
                minStack.push(x);
            }
        }else{
            minStack.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();

        int top = minStack.peek();
        //等于的时候再出栈
        if (pop == top) {
            minStack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
