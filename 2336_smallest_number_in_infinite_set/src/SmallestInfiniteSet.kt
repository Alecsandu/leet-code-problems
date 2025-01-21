fun main() {
    var obj = SmallestInfiniteSet()
    obj.addBack(5)
    obj.addBack(5)
    obj.addBack(5)
    obj.addBack(5)
    obj.addBack(5)
    obj.addBack(5)
    var param_1 = obj.popSmallest()
}

/**
 * https://leetcode.com/problems/smallest-number-in-infinite-set/description/?envType=study-plan-v2&envId=leetcode-75
 */
class SmallestInfiniteSet() {
    private var hashSet = HashSet<Int>()
    init {
        for (num in 1..1000) hashSet.add(num)
    }

    fun popSmallest(): Int {
        val num = hashSet.min()
        hashSet.remove(num)
        return num
    }

    fun addBack(num: Int) {
        hashSet.add(num)
    }

}

class _SmallestInfiniteSet{
    private var items: ByteArray = ByteArray(1001)
    private var minIndex: Int = 0

    fun addBack(num: Int) {
        items[num - 1] = 0
        minIndex = minIndex.coerceAtMost(num - 1)
    }

    fun popSmallest(): Int {
        val byteValue: Byte = 1.toByte()
        while (items[minIndex++] == byteValue);
        items[minIndex - 1] = 1;

        return minIndex
    }

}