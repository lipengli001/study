package com.review;

import java.util.stream.Stream;

public class Main {

    /**
     * stream 2066
     * 正常for
     */
    public static void main (String[] args) {
        System.out.println(isMatch("abbbbb", "*b"));

    }

    public static boolean isMatch (String s, String p) {
        /*int i = 0, j = 0;
        //*号上一个字符的索引
        int index = 0;
        char[] sArr = s.toCharArray();
        for (; i < sArr.length; i++) {
            char pChar = p.charAt(j);
            if (sArr[i] != pChar || pChar != '.') {
                return false;
            } else if () {

            } else {

            }
        }
        return true;*/
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true; // here's y axis should be i+1
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//如果是任意元素 或者是对于元素匹配
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                            /*
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                             */

                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void quickSort2 (int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        int ltemp = left;
        int rtemp = right;
        while (ltemp < rtemp) {
            while (ltemp < mid && arr[ltemp] < arr[mid]) {
                ltemp++;
            }
            while (rtemp > mid && arr[rtemp] > arr[mid]) {
                rtemp--;
            }
            if (ltemp < rtemp) {
                int temp = arr[rtemp];
                arr[rtemp] = arr[ltemp];
                arr[ltemp] = temp;
                ltemp++;
                rtemp--;
            }
        }
        if (left < rtemp) {
            quickSort2(arr, left, ltemp - 1);
        }
        if (right > ltemp) {
            quickSort2(arr, rtemp + 1, right);
        }
    }

    public static void quickSort (String[] arr, int left, int right) {
        int tleft, tright;
        tleft = left;
        tright = right;
        String f, t;
        //分界值
        f = arr[(left + right) / 2];
        while (tleft < tright) {
            while (arr[tleft].compareTo(f) < 0) {
                ++ tleft;
            }
            while (arr[tright].compareTo(f) > 0) {
                -- tright;
            }
            if (tleft <= tright) {
                t = arr[tleft];
                arr[tleft] = arr[tright];
                arr[tright] = t;
                -- tright;
                ++ tleft;
            }
        }
        if (tleft == tright) {
            tleft++;
        }

        if (left < tright) {
            quickSort(arr, left, tleft - 1);
        }

        if (right > tleft) {
            quickSort(arr, tright + 1, right);
        }

    }

    private static long test2 () {
        long sum = 0L;
        for (long i = 0; i <= 1000_0000L; i++) {
            sum += i;
        }
        return sum;
    }


    private static Long test1 () {
        return Stream.iterate(1L, i -> i + 1).limit(1000_0000L).parallel().reduce(0L, Long :: sum);
    }

}
