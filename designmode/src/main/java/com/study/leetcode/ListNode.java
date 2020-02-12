package com.study.leetcode;

/**
 *
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode (int x) {
        val = x;
    }
    /*@Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(val);
        ListNode next = this.next;
        while (next != null) {
            stringBuilder.append(",");
            stringBuilder.append(next.val);
        }
        return stringBuilder.toString();
    }*/

}
