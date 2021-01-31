package testGrile;

public class Main {

    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        System.out.println(b.test2());
    }
}
