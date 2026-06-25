package com.bruis.algorithminjava.datastructures.heap;

/**
 * @Author : haiyang.luo
 * @Date : 2026/6/25 19:16
 * @Description :
 */
public class MaxHeap {

    private int[] data;
    // 堆中的元素
    private int count;
    // 最大堆容量
    private int capacity;

    public MaxHeap() {}

    public MaxHeap(int capacity) {
        data = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    private void shiftUp(int a) {
        while (a > 1 && data[a] > data[a/2]) {
            swap(a, a/2);
            a /= 2;
        }
    }

    public void insert(int value) {
        if (count + 1 > capacity) {
            throw new IllegalStateException("out of the capacity.");
        }
        data[++count] = value;
        shiftUp(count);
    }

    private void swap(int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    public int[] toArray() {
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = data[i + 1];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] heap = {100, 10, 12, 60, 70, 50, 40, 10, 20, 30};
        MaxHeap maxHeap = new MaxHeap(heap.length);
        for (int i = 0; i < heap.length; i++) {
            maxHeap.insert(heap[i]);
        }
        HeapPrinter.printHeap(maxHeap.toArray());
    }
}
