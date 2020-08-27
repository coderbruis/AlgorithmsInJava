package com.bruis.algorithminjava.algorithm.leetcode.array;

import java.util.*;

/**
 *
 * 前K个高频元素
 *
 * url：https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author LuoHaiYang
 */
public class TopKFrequentElements {

    /**
     *
     * 桶排序
     *
     */
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        if (nums == null || nums.length < 2) {
            return nums;
        }
        Map<Integer, Integer> count = new LinkedHashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            } else {
                count.put(nums[i], 1);
            }
        }

        List<Integer>[] list = new List[nums.length];
        for (int key : count.keySet()) {
            // 让频率作为下标
            int i = count.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            // key表示的是元素
            list[i].add(key);
        }

        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) {
                continue;
            }
            res.addAll(list[i]);

        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        //int[] test = {1,1,1,2,2,3};
        int[] test = {3,0,1,0};
        topKFrequentElements.topKFrequent(test,1);

    }
}
