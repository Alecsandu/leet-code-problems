void main() {
    Solver solver = new Solver();
    int[] nums = new int[]{1, 2, 3, 3, 4};
    IO.println("Actual:");
    IO.println(solver.removeDuplicates(nums));
    IO.println(Arrays.toString(nums));

    IO.println("Expected:");
    IO.println("4");
    IO.println("[1, 2, 3, 4, 4]");
}

private static class Solver {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int k = 1;
        for (int pos = 1; pos < nums.length; pos++) {
            if (nums[pos] != nums[k - 1]) {
                nums[k] = nums[pos];
                k++;
            }
        }

        return k;
    }
}
