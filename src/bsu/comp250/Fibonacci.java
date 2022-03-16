package bsu.comp250;

public class Fibonacci {
    public static long[] fibArray;

    public static void main(String[] args) {
        int n = 45;
        fibArray = new long[n+1];
        fibArray[0] = 0;
        fibArray[1] = 1;

        double fibStart = System.nanoTime();
        long answer = fib(n);
        double fibEnd = System.nanoTime();
        double fibTime = (fibEnd - fibStart) / 1000000000;
        System.out.printf("Term %d in the sequence (no memoization) is: %d. It took %f seconds.\n", n, answer, fibTime);

        double fibMemoStart = System.nanoTime();
        long answer2 = fibMemo(n);
        double fibMemoEnd = System.nanoTime();
        double fibMemoTime = (fibMemoEnd - fibMemoStart) / 1000000000;
        System.out.printf("Term %d in the sequence (memoization) is: %d. It took %f seconds.\n", n, answer2, fibMemoTime);

        double fibLoopStart = System.nanoTime();
        long answer3 = fibLoop(n);
        double fibLoopEnd = System.nanoTime();
        double fibLoopTime = (fibLoopEnd - fibLoopStart) / 1000000000;
        System.out.printf("Term %d in the sequence (loop) is: %d. It took %f seconds.\n", n, answer3, fibLoopTime);

        System.out.printf("The memoization approach was %f times faster for fibonacci number %d.\n", (fibTime/fibMemoTime), n);
    }

    public static long fib(int n) {
        if (n < 2)
            return n;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static long fibMemo(int n) {
        if (n < 2)
            return n;
        else if (fibArray[n] != 0)
            return fibArray[n];
        else {
            long value = fibMemo(n - 1) + fibMemo(n - 2);
            fibArray[n] = value;
            return value;
        }
    }

    public static long fibLoop(int n) {
        long num1 = 0, num2 = 1;
        for(int i = 1; i < n; ++i) {
            long sumOfPrev = num1 + num2;
            num1 = num2;
            num2 = sumOfPrev;
        }
        return num2;
    }
}