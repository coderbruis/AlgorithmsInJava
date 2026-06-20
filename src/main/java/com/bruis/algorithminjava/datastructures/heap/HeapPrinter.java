package com.bruis.algorithminjava.datastructures.heap;

/**
 * 打印二叉堆
 * @Author : haiyang.luo
 * @Date : 2026/6/20 21:23
 * @Description :
 */
public class HeapPrinter {

    public static void printHeap(int[] heap) {
        if (heap == null || heap.length == 0) {
            System.out.println("(empty)");
            return;
        }

        int n = heap.length;
        int height = (int) (Math.log(n) / Math.log(2)) + 1;
        int maxWidth = (int) Math.pow(2, height) * 4;

        int index = 0;

        for (int level = 0; level < height; level++) {
            int levelCount = (int) Math.pow(2, level);
            int spaces = maxWidth / (int) Math.pow(2, level + 1);

            printSpaces(spaces);

            for (int i = 0; i < levelCount && index < n; i++) {
                System.out.printf("%2d", heap[index++]);
                printSpaces(spaces * 2 - 2);
            }

            System.out.println();
            System.out.println();
        }
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int[] heap = {100, 10, 12, 60, 70, 50, 40, 10, 20, 30};

        printHeap(heap);
    }
}
