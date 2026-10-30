package com.example.basicbeans.basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Compares the objects Spring returns for singleton and prototype beans.
 */
public class BeanScopeExample {
    public static void main(String[] args) {
        // Load the configuration that declares both bean scopes.
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(ScopeConfiguration.class)) {
            // Both lookups return the same object because singleton is the default scope.
            SingletonBean singleton1 = context.getBean(SingletonBean.class);
            SingletonBean singleton2 = context.getBean(SingletonBean.class);

            // Each lookup creates a separate object because this bean uses prototype scope.
            PrototypeBean firstPrototype = context.getBean(PrototypeBean.class);
            PrototypeBean secondPrototype = context.getBean(PrototypeBean.class);

            // The == comparison checks whether each pair refers to the same object.
            System.out.println("Singleton objects are the same: " + (singleton1 == singleton2)
                    + "\nFirst: " + singleton1 + "\nSecond: " + singleton2);
            System.out.println("Prototype objects are the same: " + (firstPrototype == secondPrototype)
                    + "\nFirst: " + firstPrototype + "\nSecond: " + secondPrototype);
        }
    }
}
