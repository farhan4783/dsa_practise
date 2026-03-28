class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];
        
        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
        return dp[n];
    }
}


//bottom up 


class Solution {
    public int fib(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}


//best optimal solution

class Solution {
    public int fib(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}
