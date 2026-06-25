package com.bruis.algorithminjava.datastructures.heap;

/**
 * @Author : haiyang.luo
 * @Date : 2026/6/20 21:00
 * @Description :
 */
public class MaxHeapHeapify {

    private int[] data;
    private int count;

    public MaxHeapHeapify() {}

    public MaxHeapHeapify(int[] arr) {
        data = new int[arr.length + 1];
        count = arr.length;
        for (int i = 0; i < count; i++) {
            data[i+1] = arr[i];
        }
        heapify();
    }

    public int extractMax() {
        if (count == 0) {
            throw new IllegalStateException("count == 0");
        }
        int max = data[1];
        swap(1, count);
        count--;
        shiftDown(1);
        return max;
    }



    private void heapify() {
        for (int i = count/2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    // 将指定参数位置进行下层操作
    private void shiftDown(int a) {
        // 探讨下，2 * a <= count有啥差别
        while (2 * a <= count) {
            int b = 2 * a;
            if (2 * a + 1 <= count && data[b] < data[b+1]) {
                b += 1;
            }
            if (data[b] <= data[a]) break;
            swap(a, b);
            a = b;
        }
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
        MaxHeapHeapify maxHeap = new MaxHeapHeapify(heap);
        HeapPrinter.printHeap(maxHeap.toArray());
    }
}
