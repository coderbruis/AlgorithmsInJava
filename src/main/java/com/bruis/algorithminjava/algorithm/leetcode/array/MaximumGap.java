package com.bruis.algorithminjava.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 最大间距
 *
 * url：https://leetcode-cn.com/problems/maximum-gap/
 *
 * @author LuoHaiYang
 */
public class MaximumGap {

    /**
     * 基于桶排序
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public int maximumGapOptimize2(int[] nums) {
        if (nums.length < 2) return 0;
        int len = nums.length;

        // 找出最大值和最小值 为了方便后面确定桶的数量
        int max = -1, min = Integer.MAX_VALUE;
        for (int i  = 0; i < len; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        // 排除nums全部为一样的数字，nums = [1,1,1,1,1,1];
        if (max - min == 0) return 0;
        // 用于存放每个桶的最大值
        int[] bucketMin = new int[len - 1];
        // 用于存放每个桶的最小值
        int[] bucketMax = new int[len - 1];
        Arrays.fill(bucketMax, -1);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        // 确定桶的间距
        int interval = (int)Math.ceil((double)(max - min) / (len - 1));
        for (int i = 0; i < len; i++) {
            // 找到每一个值所对应桶的索引
            int index = (nums[i] - min) / interval;
            if (nums[i] == min || nums[i] == max) continue;
            // 更新每个桶的数据
            bucketMax[index] = Math.max(bucketMax[index], nums[i]);
            bucketMin[index] = Math.min(bucketMin[index], nums[i]);
        }

        // maxGap 表示桶之间最大的差距
        int maxGap = 0;
        // preMax 表示前一个桶的最大值
        int preMax = min;
        for (int i = 0; i < len - 1; i++) {
            // 表示某一个桶为空
            // 但凡某一个桶不为空，都会在前面的数据中更新掉bucketMax的值
            if (bucketMax[i] == -1) continue;
            maxGap = Math.max(bucketMin[i] - preMax, maxGap);
            preMax = bucketMax[i];
        }
        // [1,10000000]
        maxGap = Math.max(maxGap, max - preMax);
        return maxGap;
    }

    /**
     * 基数排序：
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public int maximumGapOptimize(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        long exp = 1;
        int[] buf = new int[n];
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (maxVal >= exp) {
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buf, 0, nums, 0, n);
            exp *= 10;
        }

        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        // 排序
        quickSort(nums);
        int n = nums.length;

        int max = nums[1] - nums[0];

        for (int i = 2; i < n; i++) {
            max = max(max, nums[i] - nums[i-1]);
        }
        return max;
    }

    private void quickSort(int[] nums) {
        int n = nums.length;
        quickSort3ways(nums, 0, n-1);
    }

    private void quickSort3ways(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = nums[left];
        int i = left + 1, lt = left, gt = right + 1;

        while (i < gt) {
            if (nums[i] < p) {
                swap(nums, i, lt + 1);
                i++;
                lt++;
            } else if (nums[i] > p) {
                swap(nums, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        swap(nums, left, lt);
        quickSort3ways(nums, left, lt - 1);
        quickSort3ways(nums, gt, right);
    }

    private int max(int i, int j) {
        return Math.max(i, j);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = {3,6,9,1,20,15,11,30,31};
        MaximumGap maximumGap = new MaximumGap();
//        System.out.println(maximumGap.maximumGap(test));
        System.out.println(maximumGap.maximumGapOptimize2(test));
    }
}
