package com.bruis.algorithminjava.algorithm.leetcode.array;

/**
 *
 * 125
 *
 * 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/
 *
 *
 * @author LuoHaiYang
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s.equals("") || s == null) {
            return false;
        }
        String lowerCase = s.toLowerCase();
        char[] chars = lowerCase.toCharArray();

        int left = 0, right = chars.length - 1;

        // a 97  z 97+26=125

        while (left <= right) {
            while (chars[left] < 97 || chars[left] > 125) {
                left++;
            }
            while (chars[right] < 97 || chars[right] > 125) {
                right--;
            }
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome2(String str) {
        int head = 0, tail = str.length() - 1;
        char a, b;
        while(head < tail) {
            a = str.charAt(head);
            b = str.charAt(tail);
            if(!Character.isLetterOrDigit(a)) {
                head ++;
            } else if(!Character.isLetterOrDigit(b)) {
                tail --;
            } else {
                if(Character.toLowerCase(a) != Character.toLowerCase(b)) {
                    return false;
                }
                head ++;
                tail --;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        String test = "race a car";
        System.out.println(isPalindrome.isPalindrome(test));
    }
}
