package graph

import java.lang.RuntimeException
import java.util.*
import kotlin.collections.ArrayList

class GraphTraversal(var size: Int) {


    var edges = ArrayList<LinkedList<Int>>()

    var mVisitedList = ArrayList<Boolean>()


    init {
        for (i in 0 until size - 1) {
            edges.add(LinkedList())
            mVisitedList.add(false)
        }
    }


    fun addEdge(startNode: Int, destinationNode: Int) {
        if (startNode < 0 || startNode > size - 1 || destinationNode < 0 || destinationNode > size - 1)
            throw RuntimeException("fucking check input before proceed")
        edges[startNode].push(destinationNode)

    }

    fun traverseBFS(startNode: Int) {
        var queue = LinkedList<Int>()
        queue.add(startNode)
        while (!queue.isEmpty()) {
            var tempNode = queue.poll()
            print(tempNode)
            mVisitedList[tempNode] = true
            var linkedList = edges[tempNode]

            linkedList.iterator().forEach {
                if (!mVisitedList[it])
                    queue.add(it)
            }
        }

    }

    fun traverseDFS(startNode: Int) {

        var stack = Stack<Int>()

        stack.push(startNode)

        while (!stack.isEmpty()) {
            var temp = stack.pop()

            print(temp)

            mVisitedList[temp] = true

            edges[temp].iterator().forEach {
                if (!mVisitedList[it])
                    stack.push(it)
            }
        }
    }
}

fun main() {
    var graphTraversal = GraphTraversal(5)
    graphTraversal.addEdge(0, 1)
    graphTraversal.addEdge(0, 2)
    graphTraversal.addEdge(2, 0)
    graphTraversal.addEdge(1, 2)
    graphTraversal.addEdge(2, 3)
    graphTraversal.addEdge(3, 3)
    //  graphTraversal.traverseBFS(2)
    graphTraversal.traverseDFS(2)

}