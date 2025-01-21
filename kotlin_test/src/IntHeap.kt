import java.util.*

fun main() {
    println("Hello")

    val ints = intArrayOf(2, 7, 17, 3, 19, 100, 36, 25, 1, 3, -1)
    val heap = IntMinHeap(IntArray(10))
    heap.print()
    ints.forEach { heap.insert(it) }
    heap.print()
    val x = PriorityQueue<Int>()
    x.addAll(ints.toList())
    x.forEach { print("$it ") }
    println("EMPTY ")
}


internal interface MinHeap {
    fun peek(): Int
    fun poll(): Int
    fun insert(newValue: Int)
}

class IntMinHeap(private var array: IntArray, private var size: Int = 0, private var capacity: Int = 10) : MinHeap {

    override fun peek(): Int {
        if (size == 0) throw IllegalStateException("Heap is empty!")
        return array[0]
    }

    override fun poll(): Int {
        if (size == 0) throw IllegalStateException("Heap is empty!")

        val item = array[0]
        array[0] = array[size - 1]
        size--
        heapifyDown()
        return item
    }

    override fun insert(newValue: Int) {
        ensureCapacity()
        array[size++] = newValue
        heapifyUp()
    }

    fun print() {
        array.forEach { print("$it ") }
        println()
    }

    private fun heapifyDown() {
        var index = 0

        while (hasLeftChild(index)) {
            var smallerChildIndex = getLeftChildIndex(index)
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index)
            }

            if (array[index] < array[smallerChildIndex]) {
                break
            } else {
                swap(index, smallerChildIndex)
            }

            index = smallerChildIndex
        }
    }

    private fun heapifyUp() {
        var index = size - 1

        while (hasParent(index) && parent(index) > array[index]) {
            swap(index, getParentIndex(index))
            index = getParentIndex(index)
        }
    }

    private fun getLeftChildIndex(parentIndex: Int): Int = 2 * parentIndex + 1
    private fun getRightChildIndex(parentIndex: Int): Int = 2 * parentIndex + 2
    private fun getParentIndex(childIndex: Int): Int = (childIndex - 1) / 2

    private fun hasLeftChild(index: Int): Boolean = getLeftChildIndex(index) < size
    private fun hasRightChild(index: Int): Boolean = getRightChildIndex(index) < size
    private fun hasParent(index: Int): Boolean = getParentIndex(index) >= 0

    private fun leftChild(parentIndex: Int): Int = array[getLeftChildIndex(parentIndex)]
    private fun rightChild(parentIndex: Int): Int = array[getRightChildIndex(parentIndex)]
    private fun parent(childIndex: Int): Int = array[getParentIndex(childIndex)]

    private fun swap(first: Int, second: Int) {
        val temp = array[first]
        array[first] = array[second]
        array[second] = temp
    }

    private fun ensureCapacity() {
        if (capacity == size) {
            array = array.copyOf(capacity * 2)
            capacity *= 2
        }
    }
}