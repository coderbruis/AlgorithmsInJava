package com.bruis.algorithminjava.algorithm.sort;

import java.util.Random;

/**
 *
 * 借助辅助空间进行堆排序
 *
 * @author LuoHaiYang
 */
public class HeapSort01 {

    /**
     * 堆化完后并没有排序完成
     * @param arr
     */
    private static void heapify(int[] arr) {
        int n = arr.length;
        for (int i = n/2; i > 0; i--) {
            shiftDown(i, n, arr);
        }
    }

    /**
     * 获取最大堆中堆顶元素
     */
    private static int extractMax(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        swap(arr, 0, --n);
        // 让最后一个元素置0
        arr[n] = 0;
        shiftDown(0, n, arr);
        return max;
    }

    /**
     * 下沉操作
     * @param k
     */
    private static void shiftDown(int k, int n, int[] arr) {
        while (k * 2 + 1 < n) {
            // 左子树节点
            int j = k * 2 + 1;
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[k] >= arr[j]) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }

    /**
     * 上浮操作
     * @param k
     */
    private void shiftUp(int k, int[] arr) {
        while (k > 0 && arr[(k-1)/ 2] < arr[k]) {
            swap(arr, (k-1)/2, k);
            k = (k-1)/2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] sort(int[] arr) {
        int n = arr.length;
        heapify(arr);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = extractMax(arr);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 100;
        int[] test = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            test[i] = random.nextInt(1000);
        }

        sort(test);

        // 测试
        for (int i = 1; i < n; i++) {
            if (test[i-1] < test[i]) {
                System.out.println("Error!");
            }
        }

    }
}
