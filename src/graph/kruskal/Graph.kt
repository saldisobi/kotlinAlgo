package graph.kruskal

import java.util.*


class Graph<T> {

    var mEdgeList = ArrayList<Edge<T>>()

    var mVertexMap = HashMap<Int, Vertex<T>>()

    class Edge<T>(var weight: Int = -1, var sourceVertex: Vertex<T>, var destinationVertex: Vertex<T>)

    class Vertex<T>(var id: Int) : Comparable<Vertex<Int>> {
        override fun compareTo(other: Vertex<Int>): Int {
            return when {
                minDistance == other.minDistance -> 0
                minDistance < other.minDistance -> -1
                else -> 1
            }
        }

        var data: Int? = null
        var edges = ArrayList<Edge<T>>()
        private var adjacentVertices = ArrayList<Vertex<T>>()
        var minDistance = Integer.MAX_VALUE - 500
        var path = LinkedList<Vertex<Int>>()

        fun addAdjacentVertex(e: Edge<T>, v: Vertex<T>) {
            edges.add(e)
            adjacentVertices.add(v)
        }
    }

    fun addEdge(id1: Int, id2: Int, weight: Int) {
        var vertex1: Vertex<T>? = null
        if (mVertexMap.containsKey(id1)) {
            vertex1 = mVertexMap[id1]
        } else {
            vertex1 = Vertex(id1)
            mVertexMap[id1] = vertex1
        }
        var vertex2: Vertex<T>? = null
        if (mVertexMap.containsKey(id2)) {
            vertex2 = mVertexMap[id2]
        } else {
            vertex2 = Vertex(id2)
            mVertexMap[id2] = vertex2
        }

        val edge = Edge(weight, vertex1!!, vertex2!!)
        mEdgeList.add(edge)
        vertex1.addAdjacentVertex(edge, vertex2)

    }
}