package com.example.basicbeans.basic;

/**
 * A simple Java object that stores a name and uses it to create a greeting.
 *
 * <p>The {@code final} name is set once by the constructor and cannot be
 * changed later. This class has no getter or setter; its public behavior is
 * provided by {@link #greet()}.</p>
 */
public class BasicBean {
    /** Keeps the name that will appear in the greeting. */
    private final String name;

    /**
     * Saves the supplied name when a {@code BasicBean} object is created.
     *
     * @param name the text to include in greetings
     */
    public BasicBean(String name) {
        this.name = name;
    }

    /**
     * Builds a greeting by joining the saved name with the greeting text.
     *
     * @return a greeting such as {@code Hello, Spring World!}
     */
    public String greet() {
        return "Hello, " + name + "!";
    }
}
