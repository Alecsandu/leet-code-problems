void main() {
    int[] nums = new int[]{1, 0, 1};
    int[][] queries = new int[][]{{0, 2}};

    IO.println(new Solver().isZeroArray(nums, queries));

    nums = new int[]{4, 3, 2, 1};
    queries = new int[][]{{1, 3}, {0, 2}};

    IO.println(new Solver().isZeroArray(nums, queries));
}

private static class Solver {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        for (var query : queries) {
            int l = query[0], r = query[1];
            List<Integer> sublist = new ArrayList<>();
            for (int i = l; i <= r; i++) {
                if (nums[i] > 0) {
                    sublist.add(i);
                }
            }
            sublist.forEach(num -> nums[num]--);
        }

        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
