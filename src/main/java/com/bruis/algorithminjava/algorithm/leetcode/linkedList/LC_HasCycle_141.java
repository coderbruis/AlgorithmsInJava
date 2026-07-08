package com.bruis.algorithminjava.algorithm.leetcode.linkedList;

/**
 * @Author : haiyang.luo
 * @Date : 2026/7/7 16:00
 * @Description :
 */
public class LC_HasCycle_141 {

    /**
     * 只要是带环的，都用快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
