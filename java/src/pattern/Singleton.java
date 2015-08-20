/**
 * File: pattern/Singleton.java
 ************************************************************************
 * A class of which only one single instance can exist.
 * 
 * Requirements:
 *   - one, only one instance of object can exist;
 *   - lazy initialization, (i.e. calling static functions of object
 *     will not initialize an instance; 
 *   - global access
 *   
 * Example:
 * The President of the United States, there can only be one active president.  
 * 
 * For Java, it is preferable to use Enum to achieve singleton
 * 
 ************************************************************************
 * {@link https://sourcemaking.com/design_patterns/singleton }
 */
package pattern;

public class Singleton {
    
    // private constructor
    private Singleton() { }
    
    public static Singleton getInstance() {
        // return the instance held by nested static class
        return SingletonHolder.instance;
    }
    
    /** 
     * Use static nested class to achieve lazy initialization 
     * load nested class only when {@link Singleton#getInstance()} is called.
     */ 
    private static class SingletonHolder {
        // static constructor to make sure only instance exists
        private static final Singleton instance = new Singleton();
    }

}
