import singleton.Singleton;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Singleton db = Singleton.getInstance();

        System.out.println(db);
    }
}
