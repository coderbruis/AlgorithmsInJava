package com.bruis.algorithminjava.algorithm.leetcode.linkedList;

/**
 * @Author : haiyang.luo
 * @Date : 2026/7/6 06:28
 * @Description :
 */
public class LC_IsPalindrome_234 {
    //  1 -> 2 -> 3 -> 2 -> 1
    // head
    //  1 -> 2 -> 3 -> 2 -> 1
    //           cur
    //               right
    //  1 -> 2 -> 2 -> 1
    //           cur
    //          right
    // 核心思路：
    // 1. 计算出mid位置，奇数：[0...mid-1]反转给prev，[mid+1..size) 复制给right，然后将prev和right比较
    //  如果是偶数：[0...mid-1]反转给prev，[mid...size) 复制给right，然后将prev和right比较
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        int mid, size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        mid = size / 2;
        cur = head;
        ListNode prev = null;
        // prev -> null
        for (int i = 0; i < mid; i++) {
            ListNode node = cur.next;
            cur.next = prev;
            prev = cur;
            cur = node;
        }
        ListNode right;
        if (size % 2 == 0) {
            right = cur;
        } else {
            right = cur.next;
        }

        for (int i = 0; i < mid; i++) {
            if (prev.val != right.val) {
                return false;
            }
            prev = prev.next;
            right = right.next;
        }
        return true;
    }


    // 思路2，通过快慢指针计算出mid，
}
