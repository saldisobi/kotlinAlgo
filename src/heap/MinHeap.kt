package heap

class MinHeap {
    var arr = ArrayList<Int>()

    fun insert(key: Int) {
        arr.add(key)
        heapify(arr.size - 1)
    }

    fun delete(key: Int) {
        var deletePosition = 0
        for (i in 0 until arr.size - 1) {
            if (arr[i] == key) {
                deletePosition = i
                break
            }
        }

        arr[deletePosition] = arr[arr.size - 1]

        arr[arr.size - 1] = Int.MAX_VALUE

        heapify(deletePosition)
    }

    private fun heapify(affectedPosition: Int) {
        var parent = (affectedPosition) / 2
        if (arr[affectedPosition] > arr[parent]) {

            var temp = arr[affectedPosition]
            arr[affectedPosition] = arr[parent]
            arr[parent] = temp

            heapify(parent)
        }
    }


    fun print() {
        print(arr)
    }

}

fun main() {

    var minHeap = MinHeap()
    minHeap.insert(10)
    minHeap.insert(35)
    minHeap.insert(3)
    minHeap.insert(552)
    minHeap.insert(4)
    minHeap.insert(455)
    minHeap.insert(46)
    minHeap.insert(4559)

    //  minHeap.delete(4)

    minHeap.print()
}