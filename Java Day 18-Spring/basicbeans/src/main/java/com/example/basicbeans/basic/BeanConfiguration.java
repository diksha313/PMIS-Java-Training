package com.example.basicbeans.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Tells Spring how to create objects that should be available as beans.
 */
@Configuration
public class BeanConfiguration {

    /**
     * Creates a {@link BasicBean} and registers it in Spring's application
     * context so other Spring-managed code can use it.
     *
     * @return a bean configured to greet {@code World}
     */
    @Bean
    public BasicBean basicBean() {
        return new BasicBean("World");
    }
}
