final public class Singleton {

    private final int value;

    private static volatile Singleton instance;

    public static Singleton getInstance() {
        Singleton instanceHelper = instance;
        if (instanceHelper == null) {
            synchronized (Singleton.class) {
                if (instanceHelper == null) {
                    instance = instanceHelper = new Singleton();
                }
            }
        }
        return instanceHelper;
    }

    private Singleton() {
        value = 5;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().getValue());
    }
}
