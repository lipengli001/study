package com.example.demo.listener;

import com.example.demo.even.OrderEven;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class MsgListener implements ApplicationListener<OrderEven> {

    public void onApplicationEvent (OrderEven orderEven) {
        System.out.println("2:发短信");
    }

}
