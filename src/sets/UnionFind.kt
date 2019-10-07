package sets


class UnionFind(var edgeCount: Int, var verticeCount: Int) {


    var edges: ArrayList<Edge> = ArrayList()

    init {

        for (i in 0 until edgeCount) {
            edges.add(Edge(null, null))
        }

    }

    class Edge(var source: Int?, var destination: Int?)

    fun isCycle(): Int {

        var sets = ArrayList<Int>()
        //each vertex is in its own set here
        for (i in 0 until verticeCount) {
            sets.add(-1)
        }


        //iterate over all edges :)


        for (i in 0 until edgeCount) {
            var sourceSet = getSetForVertex(sets, edges[i].source)
            var destSet = getSetForVertex(sets, edges[i].destination)
            if (sourceSet == destSet)
                return 0

            doUnion(sets, sourceSet, destSet)
        }

        return -1

    }

    private fun doUnion(sets: ArrayList<Int>, sourceSet: Int, destSet: Int) {
        val sset = getSetForVertex(sets, sourceSet)
        val dset = getSetForVertex(sets, destSet)
        sets[sset] = dset
    }

    private fun getSetForVertex(sets: ArrayList<Int>, key: Int?): Int {

        return if (sets[key!!] == -1) {
            key
        } else {
            getSetForVertex(sets, sets[key])
        }

    }

}


fun main() {
/* Let us create following graph
		0
		| \
		|  \
		|    \
		1-----2 */

    val graph = UnionFind(3, 3)

    // add edge 0-1
    graph.edges[0].source = 0
    graph.edges[0].destination = 1

    // add edge 1-2
    graph.edges[1].source = 1
    graph.edges[1].destination = 2

    // add edge 0-2
    graph.edges[2].source = 0
    graph.edges[2].destination = 1

    if (graph.isCycle() == 0)
        println("graph contains cycle")
    else
        println("graph doesn't contain cycle")
}