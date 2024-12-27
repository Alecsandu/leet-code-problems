fun main() {

    val solver = Solver()
    //val array = arrayOf(1, 2, 3, 4).toIntArray()
    val array = arrayOf(1, 1, 1, 1, 3, 1, 3, 4, 3, 7).toIntArray()
    val k = 5
    println("Max num of k-sum pairs (hashmap solution) is: ${solver.countMaxNumberOfKSumPairsWithHashMap(array, k)}")
    println("Max num of k-sum pairs (sort solution) is: ${solver.countMaxNumberOfKSumPairsWithSorting(array, k)}")

}

// https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
internal class Solver {

    fun countMaxNumberOfKSumPairsWithHashMap(nums: IntArray, k: Int): Int {
        var count = 0
        val map = HashMap<Int, Int>()

        nums.forEach { num ->
            val temp = k - num

            if (map.containsKey(temp)) {
                count++

                if (map[temp] == 1) {
                    map.remove(temp)
                } else {
                    val tempNum = map[temp]!!
                    map[temp] = tempNum - 1
                }
            } else {
                map[num] = map.getOrDefault(num, 0) + 1
            }
        }

        return count
    }

    fun countMaxNumberOfKSumPairsWithSorting(nums: IntArray, k : Int): Int {
        var count = 0
        var left = 0
        var right = nums.size - 1

        nums.sort()

        while (left < right && left < nums.size - 1 && right > 0) {
            val temp = nums[right] + nums[left]

            if (temp == k) {
                count++
                left++
                right--
            } else if (temp > k) {
                right--
            } else {
                left++
            }
        }

        return count
    }

}