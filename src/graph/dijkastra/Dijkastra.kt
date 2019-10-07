package graph.dijkastra

import graph.kruskal.Graph
import java.util.*
import java.util.LinkedList


class Dijkastra {


    fun findShortestPath(source: Graph.Vertex<Int>) {

        source.minDistance = 0
        var priorityQueue = PriorityQueue<Graph.Vertex<Int>>()
        priorityQueue.add(source)

        while (!priorityQueue.isEmpty()) {
            var u = priorityQueue.poll()

            u.edges.forEach {
                val newDist = u.minDistance + it.weight

                if (it.destinationVertex.minDistance > newDist) {
                    // Remove the node from the queue to update the distance value.
                    priorityQueue.remove(it.destinationVertex)
                    it.destinationVertex.minDistance = newDist

                    // Take the path visited till now and add the new node.s
                    it.destinationVertex.path = LinkedList(u.path)
                    it.destinationVertex.path.add(u)

                    //Reenter the node with new distance.
                    priorityQueue.add(it.destinationVertex)
                }
            }
        }

        print(priorityQueue)
    }
}

fun main() {

    var graph = Graph<Int>()
    graph.addEdge(0, 1, 1)
    graph.addEdge(1, 2, 2)
    graph.addEdge(0, 3, 1)
    graph.addEdge(0, 2, 8)
    graph.addEdge(3, 2, 6)


    Dijkastra().findShortestPath(graph.mVertexMap[0]!!)

    graph.mVertexMap.values.forEach {
        println("${it.id} data :  dist  ${it.minDistance}")
    }
}