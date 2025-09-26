void main() {
    Solver solver = new Solver();
    IO.println(solver.searchInsert(new int[]{1, 3, 5, 6}, 5));
    IO.println("Expected result is 2");
    IO.println(solver.searchInsert(new int[]{1, 3, 5, 6}, 2));
    IO.println("Expected result is 1");
    IO.println(solver.searchInsert(new int[]{1, 3, 5, 6}, 7));
    IO.println("Expected result is 4");
}

private static class Solver {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end)
            return start;
        int mid = start + (end - start) / 2;
        if (nums[mid] < target)
            return binarySearch(nums, target, mid + 1, end);
        return binarySearch(nums, target, start, mid - 1);
    }
}
