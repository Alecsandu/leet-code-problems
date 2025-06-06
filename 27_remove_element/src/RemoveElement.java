import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        Solver solver = new Solver();
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Expected:");
        System.out.println("2");
        System.out.println("[2, 2, 2, 3]");
        System.out.println("Actual:");
        System.out.println(solver.removeElement(nums, val));
        System.out.println(Arrays.toString(nums));


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

}
