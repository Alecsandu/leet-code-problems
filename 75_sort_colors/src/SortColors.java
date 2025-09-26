void main() {
    var solver = new Solver();
    var nums = new int[]{1, 2, 0, 2, 1, 0, 0, 2, 0, 1, 1};
    var nums2 = new int[]{1, 2, 0, 2, 1, 0, 0, 2, 0, 1, 1};
    // 0-4, 1-4, 2-3
    // 4 8 11 11

    solver.sortColors(nums2);
    solver.sortColorsCounting(nums);
    Arrays.stream(nums).forEach(System.out::print);
    System.out.println();
    Arrays.stream(nums2).forEach(System.out::print);
    System.out.println();
}

//1,1,1,0,0
//2, 3, 0
//2, 5, 5

//https://leetcode.com/problems/sort-colors/description
private static class Solver {
    public void sortColors(int[] nums) {
        if (nums.length < 1) return;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] counts = new int[max + 1];
        int[] output = new int[nums.length];
        Arrays.fill(counts, 0);

        for (int num : nums) {
            counts[num]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            counts[nums[i]]--;
            output[counts[nums[i]]] = nums[i];
        }

        System.arraycopy(output, 0, nums, 0, output.length);
    }

    public void sortColorsCounting(int[] nums) {
        if (nums.length < 1) return;

        int maxValue = Arrays.stream(nums).max().getAsInt();
        int[] counts = new int[maxValue + 1];

        for (int num : nums) counts[num]++;

        for (int i = 0, pos = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                nums[pos++] = i;
            }
        }

            /*
            int pos = 0;
            for (int i = 0; i < counts.length; i++) {
                int count = counts[i];
                while (count > 0) {
                    nums[pos] = i;
                    count--;
                    pos++;
                }
            }
            */
    }
}
