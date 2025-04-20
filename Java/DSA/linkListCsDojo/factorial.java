package linkListCsDojo;

import java.math.BigInteger;

public class factorial {
    public static void main(String[] args) {
//        System.out.println(factorial(5));
//        System.out.println(factorial(0));
//        System.out.println(factorial(1));
//        System.out.println(factorial(4));
//        System.out.println(fibonacci(4));
//        System.out.println(fibonacci(2));
//        System.out.println(fibonacci(6));
        int n = 10;
        BigInteger[] arr = new BigInteger[n+1];
        System.out.println(fib(n, arr));
    }

    public static long factorial(int n) {
        if (n <= 1) {
            return 1L;
        }
        return n * factorial(n -1);
    }

    public static int fibonacci(int n) {
        if (n >= 3) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        } else {
            return 1;
        }
    }

    public static BigInteger fib(int n, BigInteger[] arr) {
        BigInteger result;
        if (arr[n] != null) {
            return arr[n];
        }
        if(n == 1 || n == 2) {
            return BigInteger.ONE;
        } else {
//            arr[n] = fib(n - 1, arr).add(fib(n - 2, arr));
//
//            return arr[n];
            System.out.println("fib(" + n + ") = fib(" + (n-1) + ") + fib(" + (n-2) + ")");
            BigInteger a = fib(n - 1, arr);
            BigInteger b = fib(n - 2, arr);
            result = a.add(b);
            // After computing, show the actual addition
            System.out.println("    = " + a + " + " + b + " = " + result);
            return result;
        }
    }

    public static int minimumCoins(int m, int coins) {
        if (m == 0) {
            return 0;
        } else {

        }
    }
}
