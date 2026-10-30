package com.example.basicbeans.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Defines beans used to demonstrate Spring's singleton and prototype scopes.
 */
@Configuration
public class ScopeConfiguration {

    /**
     * Registers a singleton bean. Singleton is Spring's default scope, so
     * repeated lookups return the same object from the application context.
     */
    @Bean
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }

    /**
     * Registers a prototype bean. Spring creates a new object for each lookup.
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }
}
