package tree

class BinarySearchTree {

    var mNode: SearchNode? = null

    class SearchNode(var data: Int) {
        var left: SearchNode? = null
        var right: SearchNode? = null
    }

    fun insert(data: Int) {

        var searchNode = SearchNode(data)


        if (mNode == null) {

            mNode = searchNode

            return
        }

        addNode(mNode, searchNode)
    }


    fun search(node: SearchNode? = mNode, key: Int): Int {
        if (node!!.data == key) {
            println("exists at node ${node}")
            return 0
        } else if (key > node.data) {
            if (node.right != null)
                return search(node.right, key)
        } else {
            if (node.left != null)
                return search(node.left, key)
        }

        print("not found")
        return -1
    }

    private fun addNode(parent: SearchNode?, child: SearchNode) {
        if (child.data < parent!!.data) {
            if (parent.left == null) {
                parent.left = child
            } else {
                addNode(parent.left, child)
            }
        } else {
            if (parent.right == null) {
                parent.right = child
            } else {
                addNode(parent.right, child)
            }

        }

    }

    fun inOrderRecursive(root: SearchNode? = mNode) {
        if (root != null) {
            inOrderRecursive(root?.left)
            println(root!!.data)
            inOrderRecursive(root?.right)
        }
    }
}

fun main() {

    var binarySearchTree = BinarySearchTree()

    binarySearchTree.insert(1)
    binarySearchTree.insert(10)
    binarySearchTree.insert(21)
    binarySearchTree.insert(11)
    binarySearchTree.insert(198)
    binarySearchTree.insert(31)

    // binarySearchTree.inOrderRecursive()

    binarySearchTree.search(binarySearchTree.mNode, 198)
    binarySearchTree.search(binarySearchTree.mNode, 500)
}