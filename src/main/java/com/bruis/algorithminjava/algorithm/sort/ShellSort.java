package com.bruis.algorithminjava.algorithm.sort;

/**
 *
 * 希尔排序
 *
 * @author LuoHaiYang
 */
public class ShellSort {
    public static void sort(int[] arr) {
        int n = arr.length;

        int h = 1;

        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int e = arr[i];
                int j = i;
                for (; j >= h && e < arr[j-h]; j -= h) {
                    arr[j] = arr[j-h];
                }
                arr[j] = e;
            }

            h /= 3;
        }
    }
}
