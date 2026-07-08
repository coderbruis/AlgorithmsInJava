package com.bruis.algorithminjava.algorithm.leetcode.linkedList;

/**
 * @Author : haiyang.luo
 * @Date : 2026/7/8 16:22
 * @Description :
 */
public class LC_detectCycle_142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 环相遇
            if (slow == fast) {
                ListNode p1 = head;
                ListNode p2 = fast;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }
}
