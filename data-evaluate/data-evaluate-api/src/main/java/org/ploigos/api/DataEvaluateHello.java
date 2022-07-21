package org.ploigos.api;

/**
 * Sample API used by DataEvaluate Component whose method signatures are read from Java source.
 */
public class DataEvaluateHello {

    public String sayHi() {
        return "Hello!";
    }

    public String greetMe(String name) {
        return "Hello " + name;
    }

    public String greetUs(String name1, String name2) {
            return "Hello " + name1 + ", " + name2;
    }
}
