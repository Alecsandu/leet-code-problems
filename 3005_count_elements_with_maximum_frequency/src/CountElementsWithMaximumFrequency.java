void main() {

    Solver solver = new Solver();

    IO.println("CountElementsWithMaximumFrequency for nums = [1,2,2,3,1,4] is 4, calculated is : " + solver.maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
    IO.println("CountElementsWithMaximumFrequency for nums = [1,2,3,4,5] is 5, calculated is : " + solver.maxFrequencyElements(new int[]{1, 2, 3, 4, 5}));

}

// https://leetcode.com/problems/count-elements-with-maximum-frequency/description/
private static class Solver {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1);
            }
        }

        int maxCount = 0;
        for (int count : counts.values()) {
            maxCount = Math.max(maxCount, count);
        }

        int sumMaxCount = 0;
        for (int count : counts.values()) {
            if (count == maxCount) {
                sumMaxCount += count;
            }
        }

        return sumMaxCount;
    }
}