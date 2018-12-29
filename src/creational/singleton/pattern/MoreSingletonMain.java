package creational.singleton.pattern;

//Thsese examples are taken from GeeksForGeeks :
//link : http://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 1. Eager Initialization :
 */
class Singleton1 {

    //public static instance will be created at the time of loading the class by JVM.
    public static Singleton1 instance = new Singleton1();

    private Singleton1() {
        //private constructor to prevent creating instance by calling new Singleton();
    }
}
//Pros :  1. very simple to implement,
//        2. No need to implement getInstance() method, instance can be accessed directly.
//cons :  1. May lead to resource wastage, Because instance will always be created, whether it is required or not .
//        2. CPU time is also wasted in creation of object even if it not required.
//        3. Exception handling is not possible .

/**
 * 2. Using static block : this is also a sub part of eager initialization .
 */
class Singleton2 {

    public static Singleton2 instance;

    private Singleton2() {
        //making constructor private
    }

    //static block to initialise instance
    {
        instance = new Singleton2();
    }
}
//Pros: 1. very simple to implement .
//      2. No need to implement getInstance() method, instance can be accessed directly.
//      3. Exception handling is possible.
//Coms: 1. May lead to reasource wastage, because instance will always be created even if it is not required .
//      2. CPU time is also wasted in creation of instance if it is not required .

/**
 * 3. Lazy Intitialization : Object is created only if it is needed .
 */
class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

//Pros :  1. Object is created only if it is needed, so saving the resources and CPU time .
//        2. Exception handling is also possible in this method .
//Cons :  1. Everytime null check is required .
//        2. In multithreaded environment, it may break singleton property .

/**
 * 4. Thread Safe Singleton : singleton property is maintained even if in multithreaded environment .
 */
class Singleton4 {

    public static Singleton4 instance;

    private Singleton4() {
    }

    synchronized public static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
//Pros :  1. Lazy initialization is possible
//        2. It is thread-safe
//Cons :  1. Since getInstance is synchronised it create performance issue
//          as multiple threads can access this method simultaneously.

/**
 * 5. Lazy initialization with double check locking : overcome of syncronisation problem in previous example
 */
class Singleton5 {

    private static Singleton5 instance;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}

//Pros :  1. Lazy initialization is possible .
//        2. thread-safe 3. Performance increased as the synchronization is overcome .
//Cons :  1. First time it can effect performance

/**
 * 6. Bill pugh singleton implementation : Proor to java 5, memory model had a lot of issues and above method caused failure in certain multithreaded envoronment, so Bill Pugh suggessted a concept of inner static class to  use for singleton
 */
class Singleton6 {

    private Singleton6() {
    }

    private static class BillPughSingleton {

        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return BillPughSingleton.INSTANCE;
    }
}

//when the singleton class is loaded, inner class is not loaded and hence doesn't create object when loading the class. Inner class is created only when getInstance method is invocked, so this is lazy initialization not early initialization and no need of synchronized keyword.

//It is most widely used approach as it doesn't use synchronization .

public class MoreSingletonMain {

    public static void main(String[] args)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton6 singleton6 = Singleton6.getInstance();
        System.out.println("Thid Bill Pugh Singleton object hash code is : " + singleton6);
        //Singleton6 singleton61 = Singleton6.getInstance();

        Constructor[] constructors = Singleton6.class.getDeclaredConstructors();
        System.out.println(constructors);
        for (Constructor constructor1 : constructors) {
            constructor1.setAccessible(true);
            Singleton6 singleton61 = (Singleton6) constructor1.newInstance();

            break;
            //singleton61.B
        }

    }
}

//Forget lazy initialization, it's too problematic. This is the simplest solution:

//I agree with @Dan Dayer, this is example it is lazy initialization.
// If there were other methods on the class,
// then it might be...depends on which static method gets called first.
// (Imagine a public static void doSomething() in class A being called first--A is instanced, but not used.)
class A {

    private static final A INSTANCE = new A();

    private A() {
    }

    public static A getInstance() {
        return INSTANCE;
    }
}



