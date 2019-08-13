package com.java.com;

import org.junit.Test;

public class CustomerSystemTest {

    @Test
    public void test1() {
        // test Customer
        Customer customer = new Customer("西河风", true, 30, "138 2666 1333", "xihef@qq.com");

        System.out.println(customer);
    }

}
