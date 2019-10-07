package graph.kruskal

import sets.DisjointSet
import java.util.*
import kotlin.collections.ArrayList

class Kruskal {

    fun getMinimumSpanningTree(graph: Graph<Int>) {


        var edges = graph.mEdgeList

        var result = ArrayList<Graph.Edge<Int>>()

        Collections.sort(edges, EdgeComparator())

        var disjointSet = DisjointSet()

        graph.mVertexMap.values.forEach {
            disjointSet.makeSet(it.data!!)
        }

        graph.mEdgeList.forEach {
            var sourceSet = disjointSet.findSet(it.sourceVertex.id)

            var destinationSet = disjointSet.findSet(it.destinationVertex.id)

            if (sourceSet != destinationSet) {
                result.add(it)
                disjointSet.union(it.sourceVertex.id, it.destinationVertex.id)
            }

        }

        print(result)


    }
}

fun main() {

    val graph = Graph<Int>()
    graph.addEdge(1, 2, 4)
    graph.addEdge(1, 3, 1)
    graph.addEdge(2, 5, 1)
    graph.addEdge(2, 6, 3)
    graph.addEdge(2, 4, 2)
    graph.addEdge(6, 5, 2)
    graph.addEdge(6, 4, 3)
    graph.addEdge(4, 7, 2)
    graph.addEdge(3, 4, 5)
    graph.addEdge(3, 7, 8)
    val mst = Kruskal()
    mst.getMinimumSpanningTree(graph)

}