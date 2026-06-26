package com.bruis.algorithminjava.datastructures.heap;

import java.util.Random;

/**
 * @Author : haiyang.luo
 * @Date : 2026/6/25 23:30
 * @Description :
 */
public class HeapSort {

    // 随机数组大小
    private static final int DEFAULT_RANDOM_ARRAY_SIZE = 10;
    // 随机范围
    private static final int DEFAULT_RANDOM_BOUND = 100;

    private int[] data;

    public HeapSort() {}

    public static int[] generateRandomIntArray() {
        int[] array = new int[DEFAULT_RANDOM_ARRAY_SIZE];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(DEFAULT_RANDOM_BOUND);
        }
        return array;
    }

    // 时间复杂度o(nlogn)
    public static void heapSort(int[] arr) {
        MaxHeapHeapify maxHeapHeapify = new MaxHeapHeapify(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeapHeapify.extractMax();
        }
    }

    public static void main(String[] args) {
        int[] randomArray = generateRandomIntArray();
        heapSort(randomArray);
        for (int i = 1; i < randomArray.length; i++) {
            if (randomArray[i] < randomArray[i-1]) {
                System.out.println("false");
            }
        }
    }
}
