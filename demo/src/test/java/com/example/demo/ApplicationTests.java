package com.example.demo;

import com.example.demo.controller.OrderController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith (SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private OrderController orderController;

    @Test
    public void contextLoads () {
        orderController.saveOrder();
    }

}
