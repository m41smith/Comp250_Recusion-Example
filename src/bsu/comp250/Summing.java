package bsu.comp250;

public class Summing {
    public static void main(String[] args) {
        //Call the method with the initial value to set off the chain of recursion.
        //As long as it's defined properly, we will get an answer back and stored in answer.
        //I'm also taking note of the time it takes, so that we can compare it with an iterative approach after.
        int n = 5000;

        double recursiveStart = System.nanoTime();
        int answer = sumRecursive(n);
        double recursiveEnd = System.nanoTime();
        double recursiveTime = (recursiveEnd - recursiveStart) / 1000000000;
        System.out.printf("The recursive answer is: %d. It took %f seconds\n", answer, recursiveTime);

        //Now we can do the same with an iterative (loop) summing to compare their speeds.
        double loopStart = System.nanoTime();
        int answer2 = sumLoop(n);
        double loopEnd = System.nanoTime();
        double loopTime = (loopEnd - loopStart) / 1000000000;
        System.out.printf("The loop answer is: %d. It took %f seconds\n", answer2, loopTime);

        //Lastly, let's compare directly to see roughly how much faster/slower the loop approach is.
        System.out.printf("Recursive approach was %f times slower.", recursiveTime / loopTime);
    }

    public static int sumRecursive(int n) {
        if (n == 1)
            return 1;
        else
            return n + sumRecursive(n - 1);
    }

    public static int sumLoop(int n) {
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            sum += i;
        }
        return sum;
    }
}