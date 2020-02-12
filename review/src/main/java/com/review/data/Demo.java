package com.review.data;

import java.util.List;
import java.util.function.Function;

public class Demo {

    public static void main (String[] args) {

        ListNode<Integer> listNode1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(5);
        ListNode<Integer> node4 = new ListNode<>(8);
        listNode1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode<Integer> listNode2 = new ListNode<>(7);
        listNode2 = new ListNode<>(4, listNode2);
        listNode2 = new ListNode<>(3, listNode2);
        listNode2 = new ListNode<>(1, listNode2);
        //System.out.println(listNode); 
        //System.out.println(deleteDumplication(listNode));
        //System.out.println(isMatch2("abcd", "ab.*"));
        //int[] arr = {1, 2, 3, 4, 5, 6};
        //MyFunction myFunction = new MyFunction();
        //reorder(arr, myFunction);
        //for (int i : arr) {
        //    System.out.println(i);
        //}
        //System.out.println(findKhTotail(node1, 8));
        //meetingNode(node1);
        //ListNode<Integer> listNode = reverseList(node1);
        ListNode<Integer> merge = merge(listNode1, listNode2);
        System.out.println(merge);
    }

    public static boolean isPopOrder() {
        return true;
    }

    public static ListNode<Integer> merge (ListNode<Integer> node1, ListNode<Integer> node2) {
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        }
        ListNode<Integer> mergeNode = null;
        if (node1.val < node2.val) {
            mergeNode = node1;
            mergeNode.next = merge(node1.next, node2);
        } else {
            mergeNode = node2;
            mergeNode.next = merge(node1, node2.next);
        }
        return mergeNode;
    }

    public static ListNode<Integer> reverseList (ListNode<Integer> head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next == null) {
                return pre;
            }
        }
        return null;
    }

    public static void add (List<Integer> list) {
        list.add(3);
    }

    public static ListNode<Integer> meetingNode (ListNode<Integer> head) {
        ListNode first = head;
        ListNode second = head;
        while (first != null && first.next != null) {
            first = first.next;
            first = first.next;
            second = second.next;
            if (first == null) {
                return null;
            }
            if (first == second) {
                while (true) {
                    second = second.next;
                    head = head.next;
                    if (head == second) {
                        return head;
                    }
                }
            }
        }
        return null;
    }

    public static ListNode<Integer> findKhTotail (ListNode<Integer> head, int k) {
        if (head == null || head.val == null || k == 0) {
            return null;
        }
        ListNode<Integer> first = head;
        ListNode<Integer> second = head;
        for (int i = 0; i < k - 1; i++) {
            if (first.next != null) {
                first = first.next;
            } else {
                return null;
            }
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static void reorder (int[] arr, Function<Integer, Boolean> fun) {
        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            while (begin < end && fun.apply(arr[begin])) {
                begin++;
            }
            while (begin < end && ! fun.apply(arr[end])) {
                end--;
            }
            if (begin < end) {
                int temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp;
            }
        }
    }

    static class MyFunction implements Function<Integer, Boolean> {

        @Override
        public Boolean apply (Integer i) {
            return i % 3 != 0;
        }

    }

    public static boolean isMatch (String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean firstMatch = (! text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern)));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static boolean isMatch2 (String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        //设置底部为匹配
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean firstMatch = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    private static ListNode deleteDumplication (ListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headHead = new ListNode(0);
        ListNode pre = headHead;
        headHead.next = head;
        while (head != null && head.next != null) {
            if (head.val != head.next.val) {
                pre = head;
                head = head.next;
            } else {
                while (head != null && head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                if (head == null) {
                    pre.next = null;
                } else {
                    pre.next = head.next;
                    head = head.next;
                }
            }
        }
        return headHead.next;
    }

    static class ListNode<T> {

        T val;

        ListNode<T> next;

        public ListNode () {
        }

        public ListNode (T val) {
            this(val, null);
        }

        public ListNode (T val, ListNode<T> next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString () {
            StringBuilder stringBuilder = new StringBuilder("Head->");
            ListNode<T> next = this;
            while (next != null) {
                stringBuilder.append(next.val).append("->");
                next = next.next;
            }
            stringBuilder.append("null");
            return stringBuilder.toString();
        }

    }

}
