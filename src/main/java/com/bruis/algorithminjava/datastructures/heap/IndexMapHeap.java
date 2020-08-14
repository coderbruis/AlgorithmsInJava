package com.bruis.algorithminjava.datastructures.heap;

/**
 *
 * 索引堆
 *
 * @author LuoHaiYang
 */
public class IndexMapHeap {
    /**
     * 存储数据的数组
     */
    private int[] arr;
    /**
     * index元素值就是arr的索引
     */
    private int[] index;
    /**
     * 数组存储容量大小
     */
    private int count;
    /**
     * 容量
     */
    private int capacity;

    public IndexMapHeap(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        // 让索引从0开始
        arr = new int[capacity + 1];
        // 让索引从0开始
        index = new int[capacity + 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }


    /**
     * 插入新元素
     * @param i
     * @param item
     */
    public void insert(int i, int item) {
        if (i + 1 > capacity) {
            throw new IllegalArgumentException("容量已满, 插入失败");
        }

        count++;
        i++;
        arr[i] = item;
        index[i] = i;
        shiftUp(i);
    }

    /**
     * 获取最大索引堆中所以为i的元素
     * @param i
     * @return
     */
    public int getItem(int i) {
        if (i < 0 && i + 1 > capacity) {
            throw new IllegalArgumentException("错误！索引越界.");
        }
        return arr[i+1];
    }

    /**
     * 获取索引堆中堆顶的元素（注意堆中元素是arr的索引，即index数组的元素）
     * @return
     */
    public int getMaxIndex() {
        if (count < 1) {
            throw new IllegalArgumentException("异常！堆中没有元素!");
        }
        // 由于索引堆中元素也是从1开始，所以需要-1，从0开始。
        return index[1] - 1;
    }

    /**
     * 获取最大索引堆中堆顶元素的值，即索引堆中存储的最大数据
     * @return
     */
    public int extractMax() {
        if (count < 1) {
            throw new IllegalArgumentException("错误！索引堆中不存在元素");
        }
        int ret = arr[index[1]];
        // 取出堆顶元素数据后，需要把最大元素和index末尾元素进行替换，然后做下沉操作
        swap(index, 1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    /**
     * 获取最大索引堆中堆顶的索引
     * @return
     */
    public int extractMaxIndex() {
        if (count < 1) {
            throw new IllegalArgumentException("错误！索引堆中不存在元素");
        }
        int ret = index[1] - 1;
        swap(index, 1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    // ============================= 上浮操作 =============================

    /**
     * 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
     * @param k
     */
    private void shiftUp(int k) {
        // 堆顶元素则直接跳过
        while (k > 1 && arr[index[k/2]] < arr[index[k]]) {
            swap(index, k/2, k);
            k /= 2;
        }
    }

    // ============================= 下沉操作 =============================

    /**
     * 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
     *
     * 由于是由1开始计算索引，所以左子树为 2*k
     *
     * @param k
     */
    private void shiftDown(int k) {
        // 如果左子树所以 <= 元素总数
        while ( 2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && arr[index[j+1]] > arr[index[j]]) {
                j++;
            }
            if (arr[index[k]] >= arr[index[j]]) {
                break;
            }
            // 更换索引值
            swap(index, k, j);
            k = j;
        }
    }

    // ============================= 更新堆元素优先级 =============================

    /**
     *
     *
     *
     * @param i
     * @param item
     */
    public void change(int i, int item) {
        i++;
        // 将所有堆中索引为i的元素修改为item
        arr[i] = item;

        // 由于直接在i位置修改为新元素;
        // 所以需要查找出 index[j] = i的位置，即arr[index[j]] = item;
        // 然后上浮和下沉（先后顺序不影响）
        for (int j = 1; j <= count; j++) {
            if (index[j] == i) {
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }
    }

    private void swap(int[] arr, int i, int k) {
        int tmp = arr[i];
        arr[i] = arr[k];
        arr[k] = tmp;
    }
}
