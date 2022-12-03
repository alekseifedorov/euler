/*
    https://projecteuler.net/problem=6
    Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

    Brute force solution:
    difference = (1 + 2 + ... + N)^2 - (1^2 + 2^2 + ... N^2)

    Mathematical solution:
    difference = ((N * (N+1))/2)^2  - (N*(N+1)*(2*N+1))/6;
*/
public class SumSquareDifference {
    public static final int N = 100;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long bruteForce = bruteForce(N);
        System.out.printf("Simple brute force loop: %s", bruteForce);
        System.out.printf(" took %s ms%n", System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        long modified = modifiedSumSquareDifferenceSolution(N);
        System.out.printf("Mathematical solution: %s", modified);
        System.out.printf("  took %s ms%n", System.currentTimeMillis() - start);
    }

    private static long bruteForce(int n) {
        long sumSquares = 0;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            sumSquares += (int) Math.pow(i, 2);
        }

        return (long) (Math.pow(sum, 2) - sumSquares);
    }

    private static long modifiedSumSquareDifferenceSolution(int n) {
        long sumOfNSquares = (n * (n + 1) * (2L * n + 1)) / 6;
        long squareOfSum = (long) Math.pow((n * (n + 1)) / 2, 2);

        return Math.abs(squareOfSum - sumOfNSquares);
    }
}
