// https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
void main() {
    var solver = new Solver();
    //var gains = new int[]{-5, 1, 5, 0, -7};
    var gains = new int[]{0, -4, -7, -9, -10, -6, -3, -1};
    IO.println("Max altitude is: " + solver.largestAltitude(gains));
}

private static class Solver {
    public int largestAltitude(int[] gain) {
        int maxAltGain = 0;
        int current = 0;

        for (int j : gain) {
            current += j;
            if (current > 0)
                maxAltGain = Math.max(maxAltGain, current);
        }
        return maxAltGain;
    }
}
