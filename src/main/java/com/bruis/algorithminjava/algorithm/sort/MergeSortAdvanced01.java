package com.bruis.algorithminjava.algorithm.sort;

import java.util.Arrays;

/**
 *
 * 归并排序优化版本1
 *
 * @author LuoHaiYang
 */
public class MergeSortAdvanced01 {

    public static void merge(int[] arr, int left, int mid, int right) {

        int[] aux = Arrays.copyOfRange(arr, left, right + 1);

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = aux[j-left];
                j++;
            } else if (j > right) {
                arr[k] = aux[i-left];
                i++;
            } else if (aux[i-left] < aux[j-left]) {
                arr[k] = aux[i-left];
                i++;
            } else {
                arr[k] = aux[j-left];
                j++;
            }
        }
    }

    public static void sort(int[] arr, int left, int right) {

        // 优化2: 对于小规模数组, 使用插入排序
        if (right - left <= 15) {
            InsertionSort.sort(arr);
            return;
        }

        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid] > arr[mid+1]) {
            merge(arr, left, mid, right);
        }
    }
    public static void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n-1);
    }
}
