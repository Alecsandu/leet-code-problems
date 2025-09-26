void main() {
    Solver solver = new Solver();
    IO.println("3Sum closest for [-1,2,1,-4] and target 1 is 2, calculated was " + solver.threeSumClosest(new int[]{-1, 2, 1, -4}, 1) + ".");
    IO.println("3Sum closest for [2,3,8,9,10] and target 16 is 15, calculated was " + solver.threeSumClosest(new int[]{2, 3, 8, 9, 10}, 16) + ".");
}

// https://leetcode.com/problems/3sum-closest/description/
private static class Solver {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum == target) return target;
                if (sum < target) j++;
                else k--;
            }
        }

        return res;
    }
}