package sets


class DisjointSet {

    var mMap = HashMap<Int, Node>()

    class Node {
        var data: Int? = null

        var rank: Int = 0

        var parent: Node? = null
    }

    fun makeSet(data: Int) {
        var node = Node()
        node.data = data
        node.parent = node

        mMap[data] = node
    }

    fun union(dataOne: Int, dataTwo: Int): Boolean {
        var nodeOne = mMap[dataOne]

        var nodeTwo = mMap[dataTwo]

        var parentOne = findSet(nodeOne!!)

        var parentTwo = findSet(nodeTwo!!)

        if (parentOne == parentTwo) {
            return false
        }

        when {
            parentOne.rank > parentTwo.rank -> {
                parentTwo.parent = parentOne
            }
            parentTwo.rank > parentOne.rank -> {
                parentOne.parent = parentTwo
            }
            else -> {
                parentOne.rank++
                parentTwo.parent = parentOne
            }
        }

        return true
    }


    private fun findSet(node: Node): Node {
        val parent = node.parent
        if (parent === node) {
            return parent
        }
        node.parent = findSet(node.parent!!)
        return node.parent!!
    }

    fun findSet(data:Int){
       findSet(mMap[data]!!)
    }


}

fun main() {
    val ds = DisjointSet()
    ds.makeSet(1)
    ds.makeSet(2)
    ds.makeSet(3)
    ds.makeSet(4)
    ds.makeSet(5)
    ds.makeSet(6)
    ds.makeSet(7)

    ds.union(1, 2)
    ds.union(2, 3)
    ds.union(4, 5)
    ds.union(6, 7)
    ds.union(5, 6)
    ds.union(3, 7)

    println(ds.findSet(1))
    println(ds.findSet(2))
    println(ds.findSet(3))
    println(ds.findSet(4))
    println(ds.findSet(5))
    println(ds.findSet(6))
    println(ds.findSet(7))
}