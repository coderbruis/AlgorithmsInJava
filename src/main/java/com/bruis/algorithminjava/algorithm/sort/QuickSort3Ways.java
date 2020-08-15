package com.bruis.algorithminjava.algorithm.sort;

/**
 *
 * 三路快排
 *
 * @author LuoHaiYang
 */
public class QuickSort3Ways {

    private static void sort(int[] arr, int left, int right) {
        if (right - left <= 15) {
            InsertionSort.sort(arr);
            return;
        }
        // 增加随机值，防止快排退化为O(n^2)
        swap(arr,left, (int)Math.random()*(right - left - 1) + left);

        int p = arr[left];

        // [p...................................................right]
        //  p
        //            lt
        //               i
        //                                                  gt
        // arr[left+1...lt] < p   arr[lt+1...i) = p    arr[gt...right] > p
        int lt = left, gt = right + 1, i = left + 1;

        while ( i < gt) {
            if (arr[i] < p) {
                swap(arr, lt+1, i);
                i++;
                lt++;
            } else if (arr[i] > p) {
                swap(arr, i, gt-1);
                gt--;
            } else {// arr[i] == v
                i++;
            }
        }
        swap(arr, left, lt);
        // 继续对[left,lt]进行排序
        sort(arr, left, lt-1);
        // 继续对[gt, right]进行排序
        sort(arr, gt, right);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0,  n-1);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
