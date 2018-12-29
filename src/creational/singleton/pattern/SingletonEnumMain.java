package creational.singleton.pattern;

/**
 * ensures that only one class of that particualr object is ever created <p>
 * Used in libraries :
 * Runtime # getRuntime()
 * Desktop # getDesktop()
 */

enum SingletonEnum {
    SINGLE_USING_ENUM
}

public class SingletonEnumMain {
    public static void main(String[] args) {
        System.out.println(SingletonEnum.SINGLE_USING_ENUM);
    }
}
