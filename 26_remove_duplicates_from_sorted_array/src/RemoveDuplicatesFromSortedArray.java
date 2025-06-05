import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        Solver solver = new Solver();
        int[] nums = new int[]{1, 2, 3, 3, 4};
        System.out.println("Actual:");
        System.out.println(solver.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        System.out.println("Expected:");
        System.out.println("4");
        System.out.println("[1, 2, 3, 4, 4]");
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

}
