package com.bruis.algorithminjava.algorithm.sort;

/**
 * @Author : haiyang.luo
 * @Date : 2026/6/18 12:32
 * @Description :
 */
public class Test {
    public static void main(String[] args) {

    }

    private void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        doQuickSort(arr, 0, arr.length - 1);
    }

    // arr[l+1...i-1] < v,  arr[j...r] > v
    // a, b, f, d, e, c, g, h
    //             i
    //          j
    private void doQuickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        doQuickSort(arr, l, p -1);
        doQuickSort(arr, p + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int v = arr[l], i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (j >= l + 1 && arr[j] > v) j--;
            if (i > j) break;
            swap(arr, i++, j--);
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
