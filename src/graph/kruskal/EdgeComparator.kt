package graph.kruskal

class EdgeComparator : Comparator<Graph.Edge<Int>> {

    override fun compare(o1: Graph.Edge<Int>, o2: Graph.Edge<Int>): Int {
        return if (o1.weight < o2.weight) {
            -1
        } else {
            1
        }
    }
}
