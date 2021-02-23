public class Counter {
    private static int value = 0;

    public int increment() {
       return ++value;
    }

    public static int getValue() {
        return value;
    }
}
