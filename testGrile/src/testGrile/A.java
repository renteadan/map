package testGrile;

public class A {
  private int a;

  A() {
    a = 10;
  }

  class B {
    private int a;
    B() {
      a = 15;
    }

    int test() {
      return A.this.a;
    }
    int test2() {
      return a;
    }
  }
}
