package creational.singleton.pattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ensures that only one class of that particualr object is ever created <p>
 * Used in libraries :
 * Runtime # getRuntime()
 * Desktop # getDesktop()
 */


class Singleton {

    private static Singleton singleton;

    static {
        try {
            singleton = new Singleton();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private Singleton() throws InstantiationException {
        if (Singleton.singleton != null) {
            throw new InstantiationException("Creating of this object is not allowed...");
        }
    }

    public static Singleton getSingleton() {
        return singleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return singleton;
    }

    protected Object readResolve() {
        return singleton;
    }

    public static void printMessage() {
        System.out.println("Hello, I am singleton object...");
    }


}

public class SingletonMain {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton1 = Singleton.getSingleton();
        System.out.println(singleton + "  " + singleton1);

        Constructor<Singleton> declaredConstructor = null;
        declaredConstructor = Singleton.class.getDeclaredConstructor();

        declaredConstructor.setAccessible(true);
        Singleton singleton2 = declaredConstructor.newInstance();

        System.out.println(singleton2);


    }
}