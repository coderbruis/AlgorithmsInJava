package com.bruis.algorithminjava.datastructures.heap;

import java.util.Arrays;

/**
 * 索引堆里，只有indexes是堆化了的，而data和reverse数组都是普通的数组。
 *
 * @Author : haiyang.luo
 * @Date : 2026/6/26 00:15
 * @Description :
 */
public class IndexHeap {

    /**
     * 真实数据。对外使用0开始的索引，内部转换为1开始的索引。
     */
    private int[] data;
    // indexes进行了堆化!! data的索引,indexes[heapIndex]=dataIndex, data[dataIndex]=value
    private int[] indexes;
    // 索引数组的反向,reverse[dataIndex]=heapIndex
    private int[] reverse;
    private int count;
    private int capacity;

    public IndexHeap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than 0.");
        }
        this.capacity = capacity;
        this.data = new int[capacity + 1];
        this.indexes = new int[capacity + 1];
        this.reverse = new int[capacity + 1];
        this.count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public boolean contains(int i) {
        checkIndex(i);
        return reverse[i + 1] != 0;
    }

    public void insert(int i, int item) {
        checkIndex(i);
        if (count + 1 > capacity) {
            throw new IllegalStateException("out of the capacity.");
        }
        if (contains(i)) {
            throw new IllegalArgumentException("index already exists in heap.");
        }

        int dataIndex = i + 1;
        data[dataIndex] = item;
        indexes[++count] = dataIndex;
        reverse[dataIndex] = count;
        shiftUp(count);
    }

    public int getItem(int i) {
        if (!contains(i)) {
            throw new IllegalArgumentException("index does not exist in heap.");
        }
        return data[i + 1];
    }

    public int getMax() {
        checkNotEmpty();
        return data[indexes[1]];
    }

    public int getMaxIndex() {
        checkNotEmpty();
        return indexes[1] - 1;
    }

    public int extractMax() {
        checkNotEmpty();

        int ret = data[indexes[1]];
        swapIndexes(1, count);
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return ret;
    }

    /**
     * 删除堆中最大值，并返回该最大值对应的外部原始索引。
     * 外部用户索引从0开始，索引堆内部索引从1开始。
     *
     * @return 最大值对应的外部原始索引
     */
    public int extractMaxDataIndex() {
        checkNotEmpty();

        int ret = indexes[1] - 1;
        swapIndexes(1, count);
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return ret;
    }

    public void change(int i, int item) {
        if (!contains(i)) {
            throw new IllegalArgumentException("index does not exist in heap.");
        }

        int dataIndex = i + 1;
        data[dataIndex] = item;
        int heapIndex = reverse[dataIndex];
        shiftUp(heapIndex);
        // 要调用reverse重新取一遍heapIndex，在shiftUp中reverse变了
        heapIndex = reverse[dataIndex];
        // 为什么上浮了之后，还要下沉？因为 change(i, item) 可能是把值改大，也可能是把值改小。先试着上浮
        // 再从当前位置试着下沉，这样无论值变大还是变小，都能恢复堆性质。
        shiftDown(heapIndex);
    }

    public int[] toArray() {
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = data[indexes[i + 1]];
        }
        return arr;
    }

    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]] < data[indexes[k]]) {
            swapIndexes(k, k / 2);
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j + 1]] > data[indexes[j]]) {
                j++;
            }
            if (data[indexes[k]] >= data[indexes[j]]) {
                break;
            }
            swapIndexes(k, j);
            k = j;
        }
    }

    private void swapIndexes(int i, int j) {
        int tmp = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = tmp;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= capacity) {
            throw new IllegalArgumentException("index is out of range.");
        }
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("heap is empty.");
        }
    }

    public static void demoChangeByOriginalIndex() {
        int[] scores = {62, 88, 71, 45, 93, 56};
        IndexHeap indexHeap = new IndexHeap(scores.length);
        for (int i = 0; i < scores.length; i++) {
            indexHeap.insert(i, scores[i]);
        }

        System.out.println("原始数据: " + Arrays.toString(scores));
        System.out.println("当前最大值: " + indexHeap.getMax() + ", 外部索引: " + indexHeap.getMaxIndex());

        indexHeap.change(3, 99);
        System.out.println("把外部索引3的值改成99后:");
        System.out.println("当前最大值: " + indexHeap.getMax() + ", 外部索引: " + indexHeap.getMaxIndex());

        indexHeap.change(3, 40);
        System.out.println("再把外部索引3的值改成40后:");
        System.out.println("当前最大值: " + indexHeap.getMax() + ", 外部索引: " + indexHeap.getMaxIndex());
    }

    public static void main(String[] args) {
        demoChangeByOriginalIndex();
    }
}
