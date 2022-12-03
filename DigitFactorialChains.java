import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    https://projecteuler.net/problem=74
    The number 145 is well known for the property that the sum of the factorial of its digits is equal to 145:

    1! + 4! + 5! = 1 + 24 + 120 = 145

    How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?
*/
public class DigitFactorialChains {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int result = solve(1000000);
        System.out.printf("Result: %s", result);
        System.out.printf("  took %s ms", System.currentTimeMillis() - start);
    }

    private static final int[] factorials = new int[10];

    // cache of factorials from 0 to 9
    static {
        factorials[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
    }

    // cache of the terms number of the first several chains
    private static final Map<Integer, Integer> chainLengthByStartingNumberCache = new HashMap<>();

    // summation of digit factorials
    private static int sumDigitFactorials(int number) {
        int result = 0;
        while (number > 0) {
            result += factorials[number % 10];
            number = number / 10;
        }
        return result;
    }

    private static int solve(int n) {
        int result = 0;
        // starting number from 2 to 1000000
        for (int i = 2; i < n; i++) {
            int curNum = i;
            int chainLength = 0;
            List<Integer> curSequence = new ArrayList<>();
            // calculate digit factorials until we meet the same value
            while (!curSequence.contains(curNum)) {
                curSequence.add(curNum);
                // check if the chain length is calculated before
                if (chainLengthByStartingNumberCache.containsKey(curNum)) {
                    chainLength += chainLengthByStartingNumberCache.get(curNum);
                    break;
                }
                curNum = sumDigitFactorials(curNum);
                chainLength++;
            }
            // put the chain length into cache
            chainLengthByStartingNumberCache.put(i, chainLength);
            if (chainLength == 60) {
                result++;
            }
        }
        return result;
    }
}
