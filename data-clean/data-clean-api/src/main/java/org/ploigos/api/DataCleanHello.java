package org.ploigos.api;

/**
 * Sample API used by DataClean Component whose method signatures are read from Java source.
 */
public class DataCleanHello {

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
