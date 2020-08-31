package com.bruis.algorithminjava.algorithm.leetcode.array;

/**
 * 167:
 *
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 *
 * 思路：指针碰撞
 *
 * @author LuoHaiYang
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        if (numbers.length < 2) {
            return numbers;
        }

        int left = 0, right = numbers.length - 1;

        while (left <= right) {

            int result = numbers[left] + numbers[right];

            if (result == target) {
                int[] res = {left + 1, right + 1};
                return res;
            } else if (result > target) {
                right --;
            } else {
                left ++;
            }
        }

        return numbers;
    }
}
