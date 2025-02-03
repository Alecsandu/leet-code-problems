fun main() {
    val numsAfter = intArrayOf(-1,-1,0,1,1,0)
    numsAfter.foldRight("") { num, acc ->
        "$num, $acc"
    }.dropLast(2).forEach { print(it) }.also { println() }
    val sol = FindPivotIndex()
    println("Pivot index is ${sol.pivotIndex(numsAfter)}")

    val numsBetween = intArrayOf(1,7,3,6,5,6)
    numsBetween.foldRight("") { num, acc ->
        "$num, $acc"
    }.dropLast(2).forEach { print(it) }.also { println() }
    println("Pivot index is ${sol.pivotIndex(numsBetween)}")

    val numsLeft = intArrayOf(2, 1, -1)
    numsLeft.foldRight("") { num, acc ->
        "$num, $acc"
    }.dropLast(2).forEach { print(it) }.also { println() }
    println("Pivot index is ${sol.pivotIndex(numsLeft)}")
}
// https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75
class FindPivotIndex {
    fun pivotIndex(nums: IntArray): Int {
        var leftSum = 0
        var rightSum = nums.drop(1).sum()
        for (i in 0 ..<nums.size - 1) {
            if (leftSum == rightSum) {
                return i
            }
            leftSum += nums[i]
            rightSum -= nums[i + 1]
        }

        if (leftSum == rightSum)
            return nums.size - 1
        return -1
    }
}
