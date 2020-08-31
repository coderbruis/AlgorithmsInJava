package com.bruis.algorithminjava.algorithm.leetcode.array;

/**
 *
 * 345
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 *
 * 反转字符串中的元音字母
 *
 * @author LuoHaiYang
 */
public class ReverseVowels {

    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();
        int n = arr.length, left = 0, right = n - 1;

        while (left <= right) {

            // 如果不是元音，则指针右移
            while (left < n && !isVowel(arr[left])) {
                left++;
            }

            while (right >= 0 && !isVowel(arr[right])) {
                right--;
            }

            if (left > right) {
                break;
            }

            // 字符调换
            swap(arr, left, right);
            left++;
            right--;
        }
        return new String(arr);
    }

    /**
     *
     * 1. 元音字母是？
     *
     */
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
