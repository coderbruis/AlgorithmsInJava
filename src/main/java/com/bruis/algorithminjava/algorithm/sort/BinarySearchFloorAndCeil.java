package com.bruis.algorithminjava.algorithm.sort;

/**
 * @Author : haiyang.luo
 * @Date : 2026/6/30 11:04
 * @Description :
 */
public class BinarySearchFloorAndCeil {
    /*
       功能定义:
       floor(v): 返回≤v的最大元素（不存在时返回最近小值）
       ceil(v): 返回≥v的最小元素（不存在时返回最近大值）
       特殊处理: 当v=42不存在时，floor返回41，ceil返回43

       存在多个v时，floor(v)返回v的第一个索引，ceil(v)返回v的最后一个索引
     */

    public int floor(int[] arr, int v) {
        int lowerBound = lowerBound(arr, v);
        if (lowerBound < arr.length && arr[lowerBound] == v) {
            return lowerBound;
        }
        if (lowerBound - 1 >= 0) {
            return lowerBound - 1;
        }
        return -1;
    }

    public int ceil(int[] arr, int v) {
        int upperBound = upperBound(arr, v);
        if (upperBound - 1 >= 0 && arr[upperBound - 1] == v) {
            return upperBound - 1;
        }
        if (upperBound < arr.length) {
            return upperBound;
        }
        return -1;
    }

    private int lowerBound(int[] arr, int v) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= v) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int upperBound(int[] arr, int v) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= v) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
