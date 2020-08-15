package com.bruis.algorithminjava.algorithm.sort;

/**
 *
 * 双路快排
 *
 * @author LuoHaiYang
 */
public class QuickSort2Ways {

    private static int partition(int[] arr, int left, int right) {

        swap(arr, left, (int)Math.random()*(right - left + 1) + left);

        int p = arr[left], i = left + 1, j = right;

        while(true) {

            while(i <= right && arr[i] < p) {
                i++;
            }

            while(j >= 0 && arr[j] > p) {
                j--;
            }

            if (i > j) {
                break;
            }

            swap(arr, i++, j--);
        }
        swap(arr, left, j);
        return j;
    }

    private static void sort(int[] arr, int left, int right) {
        if (right - left <= 15) {
            InsertionSort.sort(arr);
            return;
        }

        int p = partition(arr, left, right);
        sort(arr, left, p - 1);
        sort(arr, p + 1, right);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
