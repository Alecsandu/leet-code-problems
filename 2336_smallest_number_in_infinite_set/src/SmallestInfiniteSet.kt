fun main() {
    val obj = SmallestInfiniteSet()
    obj.addBack(5)
    obj.addBack(5)
    obj.addBack(5)
    obj.addBack(5)
    obj.addBack(5)
    obj.addBack(5)
    val param1 = obj.popSmallest()
    println(param1)

    val obj2 = SmallestInfiniteSetWithByteArray()
    val param2 = obj2.popSmallest()
    obj2.popSmallest()
    obj2.popSmallest()
    obj2.popSmallest()
    obj2.popSmallest()
    obj2.popSmallest()
    obj2.popSmallest()
    obj2.addBack(5)
    obj2.addBack(5)
    obj2.addBack(5)
    obj2.addBack(5)
    obj2.addBack(5)
    obj2.addBack(5)
    println(param2)
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

class SmallestInfiniteSetWithByteArray{
    private var items: ByteArray = ByteArray(1001)
    private var minIndex: Int = 0

    fun addBack(num: Int) {
        items[num - 1] = 0
        minIndex = minIndex.coerceAtMost(num - 1)
    }

    fun popSmallest(): Int {
        val byteValue: Byte = 1.toByte()
        while (items[minIndex] == byteValue) {
            minIndex++
        }
        items[minIndex] = 1

        return minIndex
    }

}