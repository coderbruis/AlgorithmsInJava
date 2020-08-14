package com.bruis.algorithminjava.algorithm.sort;

import java.util.Arrays;

/**
 *
 * 归并排序（自底向上）
 *
 * @author LuoHaiYang
 */
public class MergeSortBU {
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] aux = Arrays.copyOfRange(arr, left, right + 1);

        int i = left, j = right + 1;
        for (int k = 0; k <= right; k++) {
            if (i > mid) {
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left] > aux[j - left]) {
                arr[k] = aux[j - left];
                j++;
            } else {
                arr[k] = aux[i - left];
                i++;
            }
        }
    }

    // [a, b, c, d, e, f, g, h, i]
    // [a,b]  [c,d] [e,f] [g,h]
    public static void sort(int[] arr) {
        int n = arr.length;

        for (int sz = 1; sz < n; sz *= 2) {
            for (int i = 0; i < n - sz; i += sz + sz) {
                merge(arr, i, i+sz-1, Math.min(i+sz+sz-1, n-1));
            }
        }
    }
}
