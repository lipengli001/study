package com.study.leetcode;

/**
 *
 */
public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode listNode1 = l1;
        for (int i = 0; i < 5; i++) {
            listNode1.next = new ListNode(i + 2);
            listNode1 = listNode1.next;
        }
        /*ListNode l2 = new ListNode(1);
        ListNode listNode2 = l2;
        for (int i = 0; i < 2; i++) {
            listNode2.next = new ListNode(i + 2);
            listNode2 = listNode2.next;
        }
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        System.out.println(listNode);*/
    }

    /**
     * 搜索插入位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length + 1;
    }

    /**
     * 两数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
