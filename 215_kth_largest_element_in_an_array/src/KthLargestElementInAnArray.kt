import java.util.*

fun main() {
    println(findKthLargest(intArrayOf(2, 2, 2, 6, 6, 6), 2))
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    val pQ = PriorityQueue<Int>(Comparator.reverseOrder()) // MaxHeap
    pQ.addAll(nums.toList())

    var temp = k
    var x = 0
    while (temp > 0) {
        x = pQ.poll()
        temp--
    }

    return x
}

fun _findKthLargest(nums: IntArray, k: Int): Int {
    val max = nums.max()
    val min = nums.min()
    val counts = IntArray(max + 1 - min)
    for (num in nums) {
        counts[num - min]++
    }
    var rem = k
    var i = counts.size
    while (rem > 0) {
        i--
        rem -= counts[i]
    }
    return i + min
}
