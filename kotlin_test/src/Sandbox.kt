fun main() {
    println("Hello, Sandbox!")

    val head = Node(1, null)
    val linkedList = LinkedList(head, head)

    linkedList.add(Node(2, null))
    linkedList.print()
}

internal class LinkedList(private val head: Node, private var tail: Node) {

    fun add(newNode: Node) {
        tail.next = newNode
        tail = newNode
    }

    fun print() {
        var currentNode: Node? = head
        while (currentNode != null) {
            println(currentNode.data)
            currentNode = currentNode.next
        }
    }

}

internal data class Node(val data: Int, var next: Node?)