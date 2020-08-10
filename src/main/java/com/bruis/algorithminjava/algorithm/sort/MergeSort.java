package com.bruis.algorithminjava.algorithm.sort;

import java.util.Arrays;

/**
 *
 * 归并排序
 *
 * @author LuoHaiYang
 */
public class MergeSort {

    /**
     *
     * 将arr[left...mid]和arr[mid+1...right]两部分进行归并
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] aux = Arrays.copyOfRange(arr, left, right + 1);

        // i表示左边；j表示右边；
        int i = left, j = mid + 1;
        // 从左left遍历到右right, 左闭又开
        for (int k = left; k <= right; k++) {
            // 如果左边指针大于mid，则表示左半边数据已经归并完毕
            if (i > mid) {
                // j-left计算出相对aux的位置
                arr[k] = aux[j-left];
                j++;
            } else if (j > right) {
                // j大于right值，则表示右半边数据已经归并完毕
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

    /**
     *
     * 对[left, right]范围进行排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n-1);
    }
}
