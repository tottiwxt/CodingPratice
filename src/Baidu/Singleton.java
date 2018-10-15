package Baidu;

public class Singleton {
    private static Singleton instance = new Singleton();
    public static int counter1;
    public static int counter2 = 0;

    private Singleton() {
        counter1++;
        counter2++;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        MyMain.main(args);
    }
}

class MyMain {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        System.out.println("counter1 == " + obj.counter1);
        System.out.println("counter2 == " + obj.counter2);
    }
}