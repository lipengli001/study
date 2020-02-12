package com.study.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Test {

    public static void main (String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        stringCollection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);
        int[] arr = {4,6,9,1,5};
        Arrays.parallelSort(arr);
        ClassLoader classLoader = null;
    }

}
