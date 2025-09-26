void main() {

    Solver solver = new Solver();
    IO.println("n = 2, res = 2, calculated = " + solver.climbStairs(2));
    IO.println("n = 3, res = 3, calculated = " + solver.climbStairs(3));
    IO.println("n = 6, res = 13, calculated = " + solver.climbStairs(6));
    IO.println("n = 6, res = 13, calculated = " + solver.climbStairsRec(6));
    IO.println("n = 6, res = 13, calculated = " + solver.climbStairsSpaceOptimization(6));
    IO.println("n = 6, res = 13, calculated = " + solver.climbStairsMemoization(6));

}

private static class Solver {

    public int climbStairsRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return climbStairsRec(n - 1) + climbStairsRec(n - 2);
    }

    public int climbStairsMemoization(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return climbStairsMemo(n, memo);
    }

    public int climbStairsMemo(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo));
        }
        return memo.get(n);
    }

    // tabulation
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int climbStairsSpaceOptimization(int n) {
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = prev + curr;
            prev = curr;
            curr = temp;
        }

        return curr;
    }
}