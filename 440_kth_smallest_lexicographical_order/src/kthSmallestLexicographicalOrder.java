void main() {
    Solver solver = new Solver();
    IO.println("Actual: " + solver.findKthNumber(10, 3));
    IO.println("Expected: 10");
}

private static class Solver {

    public int findKthNumber(int n, long k) {
        int current = 1;
        k--;

        while (k > 0) {
            long steps = countSteps(n, current, current + 1);
            if (steps <= k) {
                current++;//move to the next prefix
                k -= steps;//skip numbers in the current prefix subtree
            } else {
                current *= 10;
                k--;
            }
        }

        return current;
    }

    private long countSteps(long n, long curr, long next) {
        long steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }

}
