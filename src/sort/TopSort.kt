package sort

import java.util.*

class TopSort {
    internal class Graph(var size: Int) {
        var edgeList = ArrayList<LinkedList<Int>>();

        init {
            for (i in 0 until size) {
                edgeList.add(LinkedList())
            }
        }

        fun addEdge(source: Int, destination: Int) {
            edgeList[source].addFirst(destination)
        }

        fun sort() {
            var visitedArray = BooleanArray(8)

            var stack = Stack<Int>()

            for (i in 0 until size - 1) {
                visitedArray[i] = false
            }


            for (i in 0 until size) {
                if (!visitedArray[i])
                    dfs(stack, i, visitedArray)
            }

            while (!stack.isEmpty()) {
                println(stack.pop())
            }
        }


        fun dfs(stack: Stack<Int>, i: Int, visitedArray: BooleanArray) {
            visitedArray[i] = true
            edgeList[i].forEach {
                // these are edges bro.
                if(!visitedArray[it]){
                    dfs(stack,it,visitedArray)
                }
            }

            stack.push(i)
        }


    }
}


fun main() {
    var graph = TopSort.Graph(8)
    graph.addEdge(7, 6)
    graph.addEdge(7, 5)
    graph.addEdge(6, 3)
    graph.addEdge(6, 4)
    graph.addEdge(5, 4)
    graph.addEdge(5, 2)
    graph.addEdge(4, 1)
    graph.addEdge(2, 1)
    graph.addEdge(3, 1)
    graph.addEdge(1, 0)

    graph.sort()
}