package com.bruis.algorithminjava.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author LuoHaiYang
 *
 * url: https://leetcode-cn.com/problems/3sum/
 *
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {3, 0, -2, -1, 1, 2};
        threeSum(nums);
    }

    /**
     * nums = [-1, 0, 1, 2, -1, -4]
     * <p>
     * a + b + c = 0
     * <p>
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        /**
         *
         * 解法一
         * 1. 如何解决元素重复问题？
         *    答：解决重复的关键就是对素组进行排序；
         *
         *      结果对索引没有要求，为什么不先进行排序呢？？
         *      ① 对结果进行排序；
         *          排序后固定一个数nums[i]，再使用左右指针指向nums[i]后面的“两端”，值分别为nums[L]和nums[R]，计算三个数的sum判断是否满足为0
         *             - 如果满足则添加进结果集
         *             - 由于排序的原因，所以如果nums[i]的值大于0，则三者之和必不=0
         *
         *
         *
         */
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        //合法性判断
        if (nums == null || len < 3) {
            return ans;
        }
        //如果手撕算法不能使用工具类进行排序，则要可以使用QuickSort来进行排序；
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++; // 去重
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--; // 去重
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        //return ans;
        //========================================================= 结题方法分割线 ===============================================================

        /**
         *
         */
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue) {
                minValue = v;
            }
            if (v > maxValue) {
                maxValue = v;
            }
            if (v > 0) {
                posSize++;
            } else if (v < 0) {
                negSize++;
            } else {
                zeroSize++;
            }
        }
        if (zeroSize >= 3) {
            res.add(Arrays.asList(0, 0, 0));
        }
        if (negSize == 0 || posSize == 0) {
            return res;
        }
        if (minValue * 2 + maxValue > 0) {
            maxValue = -minValue * 2;
        } else if (maxValue * 2 + minValue < 0) {
            minValue = -maxValue * 2;
        }

        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0) {
                        poses[posSize++] = v;
                    } else if (v < 0) {
                        negs[negSize++] = v;
                    }
                }
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            int minp = (-nv) >>> 1;
            while (basej < posSize && poses[basej] < minp) {
                basej++;
            }
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                int cv = 0 - nv - pv;
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1) {
                            res.add(Arrays.asList(nv, nv, pv));
                        }
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1) {
                            res.add(Arrays.asList(nv, pv, pv));
                        }
                    } else {
                        if (map[cv - minValue] > 0) {
                            res.add(Arrays.asList(nv, cv, pv));
                        }
                    }
                } else if (cv < nv) {
                    break;
                }
            }
        }
        return res;
    }
}