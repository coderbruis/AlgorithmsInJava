package com.bruis.algorithminjava.algorithm.sort;

/**
 *
 * 快速排序的优化
 *
 *
 * 对于近乎有序的数组，快速排序会退化为O(N^2)。
 *
 * @author LuoHaiYang
 */
public class QuickSort2 {

    /**
     * 对arr[left...right]部分进行partition操作
     * 返回p, 使得arr[left...p-1] < arr[p] ; arr[p+1...right] > arr[p]
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] arr, int left, int right) {

        int p = arr[left];

        // arr[left+1...j] < p;  arr[j+1...i) > p
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < p) {
                j++;
                swap(arr, j, i);
            }
            swap(arr, left, j);
        }
        return j;
    }

    private static void sort(int[] arr, int left, int right) {
/*
        if (left >= right) {
            return;
        }
*/

        // ===================================== 优化1 =====================================
        // 如果左右数值小于15，则通过插入排序来进行排序
        if (right - left <= 15) {
            InsertionSort.sort(arr);
            return;
        }

        int p = partition(arr, left, right);
        sort(arr, left, p-1);
        sort(arr, p+1, right);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
