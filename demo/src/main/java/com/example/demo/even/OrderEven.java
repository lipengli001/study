package com.example.demo.even;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 *
 */
//@Component
public class OrderEven extends ApplicationContextEvent {

    public OrderEven (ApplicationContext source) {
        super(source);
    }

}
