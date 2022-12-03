import java.util.LinkedList;
import java.util.List;

/*
    https://projecteuler.net/problem=7
    By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

    What is the 10 001st prime number?

    Brute force algorithm:
      dividing every number by a number from 2 till sqrt(N)
*/
public class Prime10001st {

    public static final int N = 10001;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = bruteForce(N);
        System.out.printf("Brute solution: %s", result);
        System.out.printf(" took %s ms", System.currentTimeMillis() - start);
    }

    public static int bruteForce(int n) {
        // collect prime numbers here
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; primeNumbers.size() < n; i++) {
            if (isPrimeBruteForce(i)) {
                primeNumbers.add(i);
                if (primeNumbers.size() == n) {
                    return i;
                }
            }
        }
        return 0;
    }

    private static boolean isPrimeBruteForce(int number) {
        // no sense to check number % i for i greater than sqrt(number)
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
