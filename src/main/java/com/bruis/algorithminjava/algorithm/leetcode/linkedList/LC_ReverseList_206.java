package com.bruis.algorithminjava.algorithm.leetcode.linkedList;

/**
 * LeetCode: 206 翻转链表
 *
 * 1. 用栈，顺序入栈，逆序出栈。
 * 2. 顺序遍历链表，然后头插法到新的节点
 *
 * @Author : haiyang.luo
 * @Date : 2026/7/5 22:29
 * @Description :
 */
public class LC_ReverseList_206 {

    /**
     * a->b->c->null
     *   cur
     * c->b->a->null
     */
    public ListNode reverseList(ListNode listNode) {

        // newCur -> null
        ListNode newCur = new ListNode();
        ListNode cur = listNode;
        while (cur != null) {

            ListNode tmpCur = cur;
            cur = cur.next;
            tmpCur.next = newCur.next;
            newCur.next = tmpCur;
        }
        return newCur.next;
    }

    /**
     * a->b->c->null
     *
     *  a -> null
     * prev
     *
     */
    public ListNode reverseList2(ListNode head) {

        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            // b->c->null
            // 1. 保存后继节点
            ListNode tmp = cur.next;
            // 2. 当前节点反向指向前驱
            cur.next = prev;
            // 3. prev 后移
            prev = cur;
            // 4. cur 后移
            cur = tmp;
        }
        return prev;
    }
}
