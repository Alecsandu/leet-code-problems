/**
 * Problem description at
 * <a href="https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75">link</a>
 */
void main() {
    Solution solution1 = new Solution1();
    Solution solution2 = new Solution2();
    int[] nums = new int[]{1, 12, -5, -6, 50, 3};
    int k = 4;
    IO.println("Solution 1 result is: " + solution1.findMaxAverage(nums, k) + "(should be 12.75)");
    IO.println("Solution 2 result is: " + solution2.findMaxAverage(nums, k) + "(should be 12.75)");

    nums = new int[]{-1};
    k = 1;
    IO.println("Solution 1 result is: " + solution1.findMaxAverage(nums, k) + "(should be -1.0)");
    IO.println("Solution 2 result is: " + solution2.findMaxAverage(nums, k) + "(should be -1.0)");
}

/**
 * Find the max sum of contiguous subarray of length k, then calculate the average of the max.
 */
static class Solution1 implements Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int currentSum = SolutionUtility.sumK(nums, i, i + k);
            maxSum = Math.max(maxSum, currentSum);
        }

        return ((double) maxSum) / k;
    }
}

/**
 * Optimized the first solution.
 * Use sum of first K numbers then just subtract the first number and add the next number.
 */
static class Solution2 implements Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = SolutionUtility.sumK(nums, 0, k);
        for (int i = k; i < nums.length; i++) {
            int currentSum = maxSum - nums[i - k] + nums[i];
            maxSum = Math.max(currentSum, maxSum);
        }

        return ((double) maxSum) / k;
    }
}

static class SolutionUtility {
    static int sumK(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

interface Solution {
    double findMaxAverage(int[] nums, int k);
}