fun main() {

    val root = BST.TreeNode(1)
    root.left = BST.TreeNode(2)
    root.right = BST.TreeNode(3)

    var searchVal = 3
    BST().recursiveBST(root, searchVal)?.let { println("${it.`val`} was found in the binary tree.") }
    searchVal = 5
    val res = BST().recursiveBST(root, searchVal)
    if (res == null) {
        println("$searchVal was not found in the binary tree.")
    }
}

class BST {
    fun recursiveBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null)
            return null
        return if (root.`val` == `val`)
            root
        else if (`val` < root.`val`)
            recursiveBST(root.left, `val`)
        else
            recursiveBST(root.right, `val`)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
