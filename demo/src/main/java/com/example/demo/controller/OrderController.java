package com.example.demo.controller;

import com.example.demo.even.OrderEven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    ApplicationContext applicationContext;

    public void saveOrder () {
        System.out.println("1:创建订单");
        applicationContext.publishEvent(new OrderEven(applicationContext));
    }

    public static void main (String[] args) {
        String s = " ";
        int res = 0;
        //List<Character> list = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            /*if (list.contains(s.charAt(j))) {
                res = Math.max(res, j - i);
                i = j;
                list.clear();
            } else {
                list.add(s.charAt(j));
            }*/
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            res = Math.max(res, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        System.out.println(res);
    }

}
