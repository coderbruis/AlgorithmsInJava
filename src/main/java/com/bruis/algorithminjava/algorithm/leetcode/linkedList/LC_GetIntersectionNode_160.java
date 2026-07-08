package com.bruis.algorithminjava.algorithm.leetcode.linkedList;

/**
 * @Author : haiyang.luo
 * @Date : 2026/7/6 07:39
 * @Description :
 */
public class LC_GetIntersectionNode_160 {

    /**
     * 解题思路：换头继续便利，找到公共相交部分
     *
     * A: a1 -> a2 -> c1 -> c2 -> null
     * B: b1 -> b2 -> b3 -> c1 -> c2 -> null
     *
     * 公共部分：c1->c2
     *
     * 相交主要是为了让：
     * A: A独有 + 公共 + B独有
     * B: B独有 + 公共 + A独有
     * 所以A和B迟早会走到公共部分
     *
     * A: a1 -> a2 -> c1 -> c2 -> null -> b1 -> b2 -> b3 -> c1 -> c2 -> null
     * B: b1 -> b2 -> b3 -> c1 -> c2 -> null -> a1 -> a2 -> c1 -> c2 -> null
     *
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA == null ? pB : pA.next;
            pB = pB == null ? pA : pB.next;
        }
        return pA;
    }
}
