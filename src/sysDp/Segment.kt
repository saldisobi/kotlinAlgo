package sysDp

class segment {

    private var compareArray = ArrayList<Int>()

    var maxMin = -1


    fun segment(x: Int, arr: List<Int>): Int {

        arr.forEach {

            if (compareArray.size == x) {
                compareArray.add(it)
                doComputation()
            } else {
                compareArray.add(it)
            }
        }

        return maxMin

    }

    private fun doComputation() {
        var min = compareArray[0]
        compareArray.forEach {
            if (it < min) {
                min = it
            }
        }
        if (maxMin == -1 || maxMin < min)
            maxMin = min

        compareArray.removeAt(0)
    }

}

fun main() {
    var list = ArrayList<Int>()
    list.add(2)
    list.add(5)
    list.add(4)
    list.add(6)
    list.add(8)
    print(segment().segment(3, list))
}
