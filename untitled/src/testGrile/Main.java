package testGrile;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    static private Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        gcdMain();
        divisorMain();
        primeMain();
        scan.close();
    }

    public static void gcdMain() {
        int a = readNr("Enter first number: ");
        int b = readNr("Enter second number: ");
        int res = gcd(a, b);
        System.out.println("G.C.D = " + res);
    }

    public static void divisorMain() {
        int num = readNr("Give divisors for: ");
        Vector<Integer> result = divisors(num);
        for(int i: result) {
            System.out.println("Divisor:" + i);
        }
    }

    public static void primeMain() {
        int num;
        Vector<Integer> result;
        num = readNr("How many numbers do you want to read?: ");
        result = readNumbers(num);
        for(int i:result) {
            if(isPrime(i))
                System.out.println(i + " is prime");
            else
                System.out.println(i + " is not prime");
        }
    }

    public static int readNr(String message) {
        System.out.print(message);
        return Integer.parseInt(scan.next());
    }

    public static Vector<Integer> readNumbers(int nr) {
        Vector<Integer> numbers = new Vector<>();
        while(nr > 0) {
            int num = readNr("Enter any number: ");
            numbers.add(num);
            nr--;
        }
        return numbers;
    }

    public static Vector<Integer> divisors(int num) {
        Vector<Integer> nr = new Vector<>();
        if(num < 0) {
            return nr;
        }
        int i=2;
        nr.add(1);
        if(num == 1)
            return nr;
        while((num/2) >= i) {
            if(num%i==0) {
                nr.add(i);
            }
            i++;
        }
        nr.add(num);
        return nr;
    }

    public static int gcd(int a, int b) {
        while(a != b)
        {
            if(a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

    public static boolean isPrime(int nr) {
        return divisors(nr).size() == 2;
    }


}
