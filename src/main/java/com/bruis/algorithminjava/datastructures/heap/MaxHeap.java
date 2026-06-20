package com.bruis.algorithminjava.datastructures.heap;

/**
 * @Author : haiyang.luo
 * @Date : 2026/6/20 21:00
 * @Description :
 */
public class MaxHeap {

    // 注意索引要从1开始
    private int[] data;

    // 堆中元素个数
    private int size;

    // 数组容量
    private int capacity;

    public MaxHeap() {}

    public int[] getData() {
        return data;
    }

    public MaxHeap(int size) {
        capacity = size + 1;
        data = new int[capacity];
    }

    // 将输入的数组转化为二叉堆
    // 核心思想：需要从最后一个非叶子树开始，
    // 为什么不能从堆顶开始递增执行下层操作呢？
    // 因为父节点调整时，需要依赖已经构建完成的子堆。这个思想其实和你学过的归并排序自底向上构建有序区间非常像，都是“先处理子问题，再处理父问题”。
    private void heapify() {
        for (int i = size/2; i > 0; i--) {
            shiftDown(i);
        }
    }

    /**
     * 添加一个元素i
     * @param i
     */
    public void insert(int i) {
        checkCapacity();
        data[++size] = i;
        shiftUp(size);
    }

    // 上浮操作
    private void shiftUp(int k) {
        while (k > 1 && data[k] > data[k/2]) {
            swap(k, k/2);
            k /= 2;
        }
    }

    // 下层操作
    private void shiftDown(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j + 1 <= size && data[j + 1] > data[j]) {
                j++;
            }
            if (data[k] >= data[j]) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    // ============================== 工具类 ==============================

    private void checkCapacity() {
        if (size + 1 >= capacity) {
            throw new IllegalStateException("Heap is full");
        }
    }

    private void swap(int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    public int[] toArray() {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = data[i + 1];
        }

        return arr;
    }

    // ============================== 工具类 ==============================

    public static void main(String[] args) {
        int[] heap = {100, 10, 12, 60, 70, 50, 40, 10, 20, 30};
        MaxHeap maxHeap = new MaxHeap(heap.length);
        for (int i = 0; i < heap.length; i++) {
            maxHeap.insert(heap[i]);
        }
        HeapPrinter.printHeap(maxHeap.toArray());
    }
}
