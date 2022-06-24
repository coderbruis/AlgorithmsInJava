package com.bruis.algorithminjava.algorithm.sort;

/**
 * 此堆索引从0开始
 *
 * @Description
 * @Author luohaiyang
 * @Date 2022/4/20
 */
public class Heap {
    private int[] data;
    private int count;
    private int capacity;

    /**
     *
     *
     *
     *           a
                 1
             b       c
             2       3
          d    e   f   g
          4    5   6   7
         q w  r x
         8 9 10 11
     *
     *
     *
     *
     */

    /**
     * 初始化堆
     * @param capacity
     */
    public Heap(int capacity) {
        this.capacity = capacity;
        data = new int[capacity+1];
        count = 0;
    }

    public Heap(int[] data, int capacity) {
        this.data = data;
        heapify(capacity);
    }

    /**
     * 新增一个元素
     * @param value
     */
    public void insert(int value) {
        if (count + 1 > capacity) {
            // 抛异常
        }
        data[++count] = value;
        shiftUp(count);
    }

    /**
     * 获取堆顶值
     * @return
     */
    public int extractMax() {
        if (count < 1) {
            // 抛异常
        }
        int max = data[1];
        swap(1, count--);
        shiftDown(1);
        return max;
    }

    /**
     * 堆化
     */
    public void heapify(int k) {
        while (k/2 >= 1) {
            shiftDown(k/2);
            k--;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 上浮操作
     * @param k
     */
    private void shiftUp(int k) {
        while (k > 1 && data[k] > data[k/2]) {
            swap(k, k/2);
            k /= 2;
        }
    }

    /**
     * 下层操作
     * @param k
     */
    private void shiftDown(int k) {
        while (count >= k * 2) {
            int j = k * 2;
            if (j+1 <= count && data[j] < data[j+1]) j++;
            if (data[k] >= data[j]) break;
            swap(k, j);
            k = j;
        }
    }

    private void swap(int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }
}
