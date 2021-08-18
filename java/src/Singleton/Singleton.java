package Singleton;

final public class Singleton {

    private static volatile Entity instance;

    public static Entity getInstance() {
        Entity instanceHelper = instance;
        if (instanceHelper == null) {
            synchronized (Singleton.class) {
                if (instanceHelper == null) {
                    instance = instanceHelper = new Entity(5);
                }
            }
        }
        return instanceHelper;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().value());
    }
}
