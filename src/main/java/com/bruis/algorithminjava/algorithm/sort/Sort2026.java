package com.bruis.algorithminjava.algorithm.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author : haiyang.luo
 * @Date : 2026/6/3 17:31
 * @Description :
 */
public class Sort2026 {

    public static void main(String[] args) {
        int[] arrays = new int[]{10,9,11,10,10,10,33,2,3,1,0,5};
        twoWayQuickSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    // 1. 选择排序，时间复杂度O(n^2)
    private static void selectionSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[j] < arrays[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = arrays[i];
                arrays[i] = arrays[minIndex];
                arrays[minIndex] = tmp;
            }
        }
    }

    // 2. 冒泡算法，时间复杂度O(n^2)
    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * a,b,c,d,e,f,g
     * ^ ^
     * 普通插入排序法
     * 时间最差复杂度: O(n^2)
     */
    private static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 不需要每次对比都交换元素
     *  a,b,c,d,e,f,g
     *    e
     *    ^
     * 时间最差复杂度: O(n^2)
     */
    private static void insertSortWithoutSwap(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int j;
            int e = arr[i];
            for(j = i; j > 0 && arr[j - 1] > e; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    /**
     * 归并排序
     *
     */
    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSortInner(arr, 0, arr.length - 1);
    }

    private static void mergeSortInner(int[] arr, int left, int right) {
        // 越界结束merge
        if (left >= right) {
            return;
        }
        // TODO 【优化】会数组溢出
        int mid = (left + right) / 2;
        // 这样数组一定不会溢出
//        int mid = left + (right - left) / 2;
        // 继续拆左侧元素
        mergeSortInner(arr, left, mid);
        // 继续拆右侧元素
        mergeSortInner(arr, mid + 1, right);

        // 走到此处，左右分半（左侧和右侧都是已经排好序了），mid就是左侧最大值；mid+1就是右侧最小值
        if (arr[mid] > arr[mid + 1]) {
            doMergeSort(arr, left, mid, right);
        }
    }

    private static void doMergeSort(int[] arr, int left, int mid, int right) {
        // 新开辟一个辅助数组：[left + 1 ... right]
        int[] aux = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            aux[i - left] = arr[i];
        }
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left] < aux[j - left]) { // 【TODO】优化：相等时永远左边优先，这样排序会稳定得多 aux[i - left] <= aux[j - left
                arr[k] = aux[i - left];
                i++;
            } else {
                arr[k] = aux[j - left];
                j++;
            }
        }
    }

    /**
     * 自底向上的归并排序算法
     *
     */
    private static void mergeSortByBottom(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        // size 表示当前要归并的子数组长度：1, 2, 4, 8...             => size就是数组大小，每次要merge左侧也右侧的数组[size, size]，这么好理解一点
        // 每轮merge的数组长度翻倍
        for (int size = 1; size < n; size += size) {
            // 跳到下一对待merge数组
            // left + size < n，保证右侧总有数据可以merge            => left + size 得到的就是右侧数组的第一个元素(mid+1)，这个元素(mid+1)必须得有才能进行merge
            for (int left = 0; left < n - size; left += size + size) {
                int mid = left + size - 1;                     // => mid = left + size - 1，所以上面left + size = mid + 1 < n
                // for的结束条件只能保证mid + 1 有值，但是不保证right边界不越界，所以得和n-1进行最小值比较
                int right = Math.min(left + size + size - 1, n - 1);

                if (arr[mid] > arr[mid + 1]) {
                    doMergeSort(arr, left, mid, right);
                }
            }
        }
    }

    // ============================ 普通快排 ============================

    private void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        doQuickSort(arr, 0, arr.length - 1);
    }

    private void doQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        doQuickSort(arr, left, p - 1);
        doQuickSort(arr, p + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int p = arr[left];
        int j = left;
        // arr[left] arr[left+1...j] < p, p < arr[j+1...i];
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < p) {
                swap(arr, ++j, i);
            }
        }
        swap(arr, left, j);
        return j;
    }

    /**
     * 取随机数，尽量将有序的数组打散
     * 生成[a,b]之间随机数，公式为：a + new Random().nextInt(b - a + 1)
     */
    private int partitionWithPivot(int[] arr, int left, int right) {
        int pivot = left + new Random().nextInt(right - left + 1);
        swap(arr, left, pivot);
        int p = arr[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < p) {
                swap(arr, ++j, i);
            }
        }
        swap(arr, left, j);
        return j;
    }

    // 问题分析：如果是对接近有序的数组进行排序，普通快排最坏情况下会退化成O(N^2)
    // ============================ 普通快排 ============================

    // ============================ 2路快排 ============================
    private static void twoWayQuickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        doTwoWayQuickSort(arr, 0, arr.length - 1);
    }

    private static void doTwoWayQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = twoWayPartition(arr, left, right);
        doTwoWayQuickSort(arr, left, p - 1);
        doTwoWayQuickSort(arr, p + 1, right);
    }

    /**
     * 循环过程中：
     * arr[left + 1...i - 1] <= p
     * arr[j + 1...right] >= p
     * <p>
     * 最后 swap(arr, left, j) 后：
     * arr[left...j - 1] <= p
     * arr[j] == p
     * arr[j + 1...right] >= p
     */
    private static int twoWayPartition(int[] arr, int left, int right) {
        // 加随机数，避免partition极度不均匀
        int pivot = left + new Random().nextInt(right - left + 1);
        swap(arr, left, pivot);
        int p = arr[left], i = left + 1, j = right;
        while(true) {
            while(i <= right && arr[i] < p) {
                i++;
            }
            // p = arr[left]了，没必要比较j 和 left
            while(j >= left + 1 && arr[j] > p) {
                j--;
            }
            if (i > j) break;
            swap(arr, i++, j--);
        }
        swap(arr, left, j);
        return j;
    }
    // ============================ 2路快排 ============================

    // ============================ 3路快排 ============================
    private void threeWayQuickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        doThreeWayQuickSort(arr, 0, arr.length - 1);
    }


    /**
     * 1) arr[l+1...lt]         < p(arr[l])
     * 2) arr[lt+1...i-1]       = p(arr[l])
     * 3) arr[gt...r]           > p(arr[l])
     * <p>
     *   [a, b, c, d, e, f, g, h, i, j, k]
     *    l
     *          lt
     *             i
     *                               gt r
     * while循环结束
     *   [a, b, c, d, e, f, g, h, i, j, k]
     *    l
     *          lt
     *                      i
     *                      gt          r
     */
    private void doThreeWayQuickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        // 不要每次递归都new Random()
//        int pivot = left + new Random().nextInt(right - left + 1);
        int pivot = ThreadLocalRandom.current().nextInt(left, right + 1);
        swap(arr, pivot, left);
        int p = arr[left], lt = left, i = left + 1, gt = right + 1;
        while (i < gt) {
            if (arr[i] < p) {
                // lt区域扩大，i得递增
                swap(arr, ++lt, i++);
            } else if (arr[i] > p) {
                // gt区域扩大
                swap(arr, --gt, i);
            } else {
                i++;
            }
        }
        swap(arr, left, lt);
        // lt -> gt - 1 区间都是相等的值了
        doThreeWayQuickSort(arr, left, lt - 1);
        doThreeWayQuickSort(arr, gt, right);
    }
    // ============================ 3路快排 ============================

    // TODO 归并排序变种题==> 查找逆序对

    // TODO 快速排序变种题==> 查找第n位数


    public static void swap(int[] arr, int sourceIndex, int targetIndex) {
        int temp = arr[sourceIndex];
        arr[sourceIndex] = arr[targetIndex];
        arr[targetIndex] = temp;
    }
}
