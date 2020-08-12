package com.bruis.algorithminjava.datastructures.heap;

import java.util.Random;

/**
 * @author LuoHaiYang
 */
public class MaxHeap {

    /**
     * 注意，由于数组元素默认值为0，所以堆中元素不可为0
     */
    private int[] data;

    /**
     * 记录数组中元素个数
     */
    private int size;

    /**
     * 数组容量（初始化大小）
     */
    private int capacity;

    public MaxHeap(int capacity) {
        data = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }
    public MaxHeap() {
        data = new int[10];
        capacity = 10;
        size = 0;
    }

    // ================================ heapify(二叉堆化) ========================

    public MaxHeap(int[] data) {
        int n = data.length;
        this.data = new int[n+1];
        capacity = n;

        for (int i = 0; i < n; i++) {
            this.data[i+1] = data[i];
        }
        size = n;

        // 这里需要注意，size / 2 得到的索引是二叉堆中最后一个非叶子节点。
        for (int i = size / 2; i > 0; i++) {
            siftDown(i);
        }
    }

    /**
     * 返回堆中真实存在元素个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 返回堆中是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回index索引其父亲节点
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回index索引的左子节点
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回index索引的右子节点
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // ================================ 上浮 siftUp ========================

    /**
     * 向堆中添加元素
     */
    public void add(int i) {
        // 注意size和capacity的关系，判断是否容量已经满了
        // 向数组最后一位添加新元素
        data[size] = i;
        siftUp(size++);
    }

    /**
     * 上浮过程
     * @param k
     */
    private void siftUp(int k) {
        // k 索引大于0，并且k索引元素值大于k父亲节点元素值
        while (k > 0 && data[parent(k)] < data[k]) {
            // k和parent(k)互换元素
            swap(data, k, parent(k));
            // 向上移动，让k为parent(k)再进行判断
            k = parent(k);
        }
    }

    // ================================ 下浮 siftDown ========================

    /**
     * 获取堆中最大元素
     * @return
     */
    public int findMax() {
        if (size == 0) {
            throw new IllegalArgumentException("Can't find Max value!");
        }
        return data[0];
    }

    /**
     * 取出堆中最大元素
     * @return
     */
    public int extractMax() {
        int max = findMax();
        swap(data, 0, size - 1);
        data[size - 1] = 0;
        siftDown(0);
        return max;
    }

    /**
     * 下沉操作
     * @param k
     */
    private void siftDown(int k) {
        // 左子节点比数组元素小，则表示有子节点
        while (leftChild(k) < size()) {
            int j = leftChild(k);
            // 如果k的有右子节点
            if (j + 1 < size() && data[j + 1] > data[j]) {
                // 所以让j为右子节点
                // j = rightChild(k); 同
                j++;
            }
            // 此时data[k] 比leftChild和rightChild中的最大值都要大
            if (data[k] > data[j]) {
                break;
            }
            // leftChild和rightChild都比data[k]大，在互换之后，继续下一轮判断
            swap(data, k, j);
            // 互换位置，继续下一轮判断
            k = j;
        }
    }

    // ================================ 替换操作 ========================

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int n = 100;
        MaxHeap maxHeap = new MaxHeap(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(1000));
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = maxHeap.extractMax();
        }
        // 测试是否是顺序的
        for (int j = 1; j < n; j++) {
            if (result[j-1] < result[j]) {
                throw new IllegalArgumentException("Error!");
            }
        }
    }
}
