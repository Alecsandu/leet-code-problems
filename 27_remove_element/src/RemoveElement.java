void main() {
    Solver solver = new Solver();
    int[] nums = new int[]{3, 2, 2, 3};
    int val = 3;
    IO.println("Input array: " + Arrays.toString(nums));
    IO.println("Expected:");
    IO.println("2");
    IO.println("[2, 2, 2, 3]");
    IO.println("Actual:");
    IO.println(solver.removeElement(nums, val));
    IO.println(Arrays.toString(nums));


}

private static class Solver {

    // Problem similar with LC 26, the key is to know what index to use when overwriting the values equal to val
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

}
