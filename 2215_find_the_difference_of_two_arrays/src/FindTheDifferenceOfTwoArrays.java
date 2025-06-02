import java.util.*;

public class FindTheDifferenceOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{2, 4, 6};
        Solver solver = new Solver();
        var res = solver.findDifference(nums1, nums2);
        System.out.println("Expected values : [[1, 3] [4, 6]]");
        System.out.println("Actual values : [" + res.get(0) + " " + res.get(1) + "]");
        res = solver.findDifferenceWithOneArrayLooping(nums1, nums2);
        System.out.println("Actual values : [" + res.get(0) + " " + res.get(1) + "]");
    }

    private static class Solver {

        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

            Set<Integer> nums1MinusNums2 = calculateDifference(nums1, nums2);
            Set<Integer> nums2MinusNums1 = calculateDifference(nums2, nums1);

            return new ArrayList<>(List.of(nums1MinusNums2.stream().toList(), nums2MinusNums1.stream().toList()));
        }

        private Set<Integer> calculateDifference(int[] nums1, int[] nums2) {
            Set<Integer> nums1MinusNums2 = new HashSet<>();
            for (int k : nums1) {
                boolean isSame = false;
                for (int i : nums2) {
                    if (k == i) {
                        isSame = true;
                        break;
                    }
                }
                if (!isSame) {
                    nums1MinusNums2.add(k);
                }
            }
            return nums1MinusNums2;
        }

        public List<List<Integer>> findDifferenceWithOneArrayLooping(int[] nums1, int[] nums2) {
            Set<Integer> hs1 = new HashSet<>(Arrays.stream(nums1).boxed().toList());
            Set<Integer> hs2 = new HashSet<>(Arrays.stream(nums2).boxed().toList());

            for (int num : nums2) {
                if (hs1.contains(num)) {
                    hs1.remove(num);
                    hs2.remove(num);
                }
            }

            return new ArrayList<>(List.of(hs1.stream().toList(), hs2.stream().toList()));
        }
    }

}
