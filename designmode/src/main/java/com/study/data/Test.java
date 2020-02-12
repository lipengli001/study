package com.study.data;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test<E> {

    transient int size = 0;

    /**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     * (first.prev == null && first.item != null)
     */
    transient Test.Node<E> first;

    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     * (last.next == null && last.item != null)
     */
    transient Test.Node<E> last;

    private static class Node<E> {

        E item;

        Test.Node<E> next;

        Test.Node<E> prev;

        Node (Test.Node<E> prev, E element, Test.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

    }

    Test.Node<E> node (int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Test.Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Test.Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public static boolean flag = true;

    public static void main (String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>(1000);
        LinkedList<String> list1 = new LinkedList<>();
        list1.addFirst("1");
        list1.addFirst("2");
        list1.addFirst("3");
        list1.get(2);
        /*List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String s = "";
            for (int j = 0; j < 100; j++) {
                s+= UUID.randomUUID();
            }
            list.add(s);
        }
        System.out.println(list);*/

        /*Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        new Thread(new MyThread("1", obj3, obj1)).start();

        Thread.sleep(100);

        new Thread(new MyThread("2", obj1, obj2)).start();

        Thread.sleep(100);

        new Thread(new MyThread("3", obj2, obj3)).start();*/
        a:
        {
            if (flag) {
                break a;
            }
            System.out.println(flag);
        }
        System.out.println(flag);
    }

}
