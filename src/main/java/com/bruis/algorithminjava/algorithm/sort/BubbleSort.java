package com.bruis.algorithminjava.algorithm.sort;

/**
 * @author LuoHaiYang
 */
public class BubbleSort {

    // 方式1
    public static void sort(int[] arr) {
        int n = arr.length;
        boolean swapped = false;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                    swapped = true;
                }
            }
        } while(swapped);
    }

    // 方式2
    public static void sort2(int[] arr) {
        int n = arr.length;

        if (n <= 1) {
            return;
        }

        // 使用newn来进行优化
        int newn;

        do {
            newn = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                    // 记录当前排序最后一次交换的位置，在此之后的元素在下一轮扫描中均不考虑
                    newn = i;
                }
            }
            n = newn;
        } while (newn > 0);

    }

    // 方式3
    public static void sort3(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean flag = false;

            // n - i - 1 表示每轮排序都会有一个最大元素冒泡到最大位置，因而每轮排序都会少一个遍历的元素
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            // 此轮排序没有数据交换，则退出排序
            if (!flag) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}