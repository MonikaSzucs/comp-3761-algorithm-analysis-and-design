import java.util.ArrayList;

public class DynamicFibonacci {
    // Static ArrayList to store Fibonacci numbers
    private static ArrayList<Integer> dp;

    // Constructor to initialize the base cases
    public DynamicFibonacci() {
        dp = new ArrayList<>();
        dp.add(0); // Base case: fib(0) = 0
        dp.add(1); // Base case: fib(1) = 1
    }

    // Dynamic Programming (Bottom-Up) Fibonacci function
    public static int fibo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative.");
        }

        // If n is within the current ArrayList size, return the precomputed value
        if (n < dp.size()) {
            return dp.get(n);
        }

        // Fill the ArrayList using the bottom-up approach
        for (int i = dp.size(); i <= n; i++) {
            int nextFib = dp.get(i - 1) + dp.get(i - 2); // Recurrence relation
            dp.add(nextFib); // Add the computed Fibonacci number to the ArrayList
        }

        return dp.get(n); // Return the nth Fibonacci number
    }
}