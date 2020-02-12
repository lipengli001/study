package com.mall.common.jdk;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大函数式接口
 */
public class FunctionDemo {

    public static void main (String[] args) {
        //输入、输出型
        Function<String, Integer> function = s -> {
            return s.length();
        };
        System.out.println(function.apply("abc"));
        //断言型
        Predicate predicate = s -> {
            return s.equals("abc");
        };
        System.out.println(predicate.test("abc"));

        //消费型
        Consumer<String> consumer = s -> {
            System.out.println(s);
        };
        consumer.accept("abc");

        //供给型
        Supplier<String> supplier = () -> {
            return "abc";
        };
        System.out.println(supplier.get());
    }

}
