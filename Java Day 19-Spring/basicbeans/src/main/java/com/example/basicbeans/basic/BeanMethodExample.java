package com.example.basicbeans.basic;

import java.net.spi.InetAddressResolverProvider;

/**
 * Demonstrates creating and using a {@link BasicBean} directly, without
 * asking Spring to create it.
 */
public class BeanMethodExample {

    /**
     * Program entry point: creates a bean with a sample name and prints its
     * greeting to the console.
     *
     * @param args command-line arguments (not used by this example)
     */
    static void main(String[] args) {
        BasicBean bean = new BasicBean("Spring World");


        System.out.println(bean.greet());
    }
}
