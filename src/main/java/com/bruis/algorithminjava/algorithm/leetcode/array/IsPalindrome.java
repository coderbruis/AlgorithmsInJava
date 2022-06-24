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
    public boolean isPalindrome(String str) {
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
