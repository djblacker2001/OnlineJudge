import java.util.Scanner;

public class LOGGING_EI2223Q1ADAF3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read input
        int n = sc.nextInt();
        long[] k = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            k[i] = sc.nextLong();
        }

        // Initialize dp array, where dp[i] represents the max value from cutting trees up to i
        long[] dp = new long[n + 1];
        dp[0] = 0;  // no tree
        dp[1] = Integer.MIN_VALUE; // Impossible to cut only one tree

        // Start filling dp array from the second tree
        for (int i = 2; i <= n; i++) {
            // Option 1: cut trees i-1 and i together
            dp[i] = Math.max(dp[i], dp[i - 2] + k[i - 1] + k[i]);

            // Option 2: continue cutting from the previous tree (i.e., adding tree i to previous sequence)
            dp[i] = Math.max(dp[i], dp[i - 1] + k[i]);
        }
        
        // The maximum value after cutting at least two consecutive trees
        System.out.println(dp[n]);
    }
}
