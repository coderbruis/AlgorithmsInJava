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
     *
     *
     */
    public int[] topKFrequent(int[] nums, int k) {
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

        List<Integer> result = new ArrayList<>();

        Set<Map.Entry<Integer, Integer>> entries = count.entrySet();

        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > k) {
                result.add(entry.getKey());
            }
        }


        int[] res = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res.length > 0 ? res : nums;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        //int[] test = {1,1,1,2,2,3};
        int[] test = {3,0,1,0};
        topKFrequentElements.topKFrequent(test,1);

    }
}
