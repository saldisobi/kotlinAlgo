package tree

import java.util.*


class TreeTraversal {

    var mRoot: TraversalNode? = null


    class TraversalNode(var data: Int) {


        var mLeftChild: TraversalNode? = null

        var mRightChild: TraversalNode? = null

    }

    fun preRecursive(root: TraversalNode? = mRoot) {
        if (root != null) {
            print(root.data)
            preRecursive(root?.mLeftChild)
            preRecursive(root?.mRightChild)
        }
    }

    fun postrecursive(root: TraversalNode? = mRoot) {
        if (root != null) {
            postrecursive(root?.mLeftChild)
            postrecursive(root?.mRightChild)
            print(root!!.data)
        }
    }

    fun inOrderRecursive(root: TraversalNode? = mRoot) {
        if (root != null) {
            inOrderRecursive(root?.mLeftChild)
            print(root!!.data)
            inOrderRecursive(root?.mRightChild)
        }
    }

    fun levelRecursive() {

        var height = getHeight()

        var i = 1
        while (i <= height) {
            printGivenLevel(mRoot, i)
            i++
        }
    }


    private fun printGivenLevel(root: TraversalNode? = mRoot, level: Int) {
        if (level == 1) {
            print(root?.data)
        } else if (level > 1) {
            printGivenLevel(root?.mLeftChild, level - 1)
            printGivenLevel(root?.mRightChild, level - 1)
        }

    }

    private fun getHeight(root: TraversalNode? = mRoot): Int {

        var height = 0
        if (root == null)
            return height
        else {
            var lHeight = getHeight(root.mLeftChild)
            var rHeight = getHeight(root.mRightChild)
            height = if (lHeight > rHeight)
                lHeight + 1
            else
                rHeight + 1
        }

        return height
    }


    fun preIterative() {
        var stack = Stack<TraversalNode>()
        stack.push(mRoot)
        while (!stack.isEmpty()) {

            var node = stack.pop()

            print(node.data)

            if (node.mRightChild != null)
                stack.push(node.mRightChild)


            if (node.mLeftChild != null)

                stack.push(node.mLeftChild)


        }
    }


    fun postOrderIterative() {
        var node = mRoot
        var stack = Stack<TraversalNode>()
        var lastVisitedNode: TraversalNode? = null
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node)
                node = node.mLeftChild
            } else {
                var peekNode = stack.peek()
                if (peekNode.mRightChild != null && lastVisitedNode != peekNode.mRightChild) {
                    //we haven' visited right of this node lets do it now
                    node = peekNode.mRightChild
                } else {
                    print(peekNode.data)
                    lastVisitedNode = stack.pop()
                }
            }
        }
    }

    fun inOrderIterative() {

        if (mRoot == null)
            return

        var current = mRoot

        var stack = Stack<TraversalNode>()

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current)
                current = current.mLeftChild
            }

            // reached here means we current is null. lets pop and print
            var s = stack.pop()
            print(s.data)

            //lets add now right ones

            current = s?.mRightChild
        }
    }

    fun levelIterative() {

        var queue = LinkedList<TraversalNode>()

        var current = mRoot

        if (current != null) {
            queue.add(current)
        }

        while (!queue.isEmpty()) {

            var tempNode = queue.poll()

            print(tempNode.data)

            if (tempNode.mLeftChild != null) {
                queue.add(tempNode.mLeftChild!!)
            }

            if (tempNode.mRightChild != null) {
                queue.add(tempNode.mRightChild!!)
            }
        }

    }

}

fun main() {
    var treeTraversal = TreeTraversal()
    treeTraversal.mRoot = TreeTraversal.TraversalNode(1)
    treeTraversal.mRoot!!.mLeftChild = TreeTraversal.TraversalNode(7)
    treeTraversal.mRoot!!.mRightChild = TreeTraversal.TraversalNode(2)
    treeTraversal.mRoot!!.mRightChild!!.mLeftChild = TreeTraversal.TraversalNode(4)
    treeTraversal.mRoot!!.mRightChild!!.mLeftChild!!.mLeftChild = TreeTraversal.TraversalNode(5)
    treeTraversal.mRoot!!.mRightChild!!.mLeftChild!!.mRightChild = TreeTraversal.TraversalNode(6)

    treeTraversal.inOrderRecursive()
    println()
    /* treeTraversal.inOrderIterative()
     println()
     treeTraversal.postrecursive()
     println()
     treeTraversal.postOrderIterative()
     println()
     treeTraversal.preRecursive()
     println()
     treeTraversal.preIterative()
     println()
     treeTraversal.levelRecursive()
     println()
     treeTraversal.levelIterative()*/


}