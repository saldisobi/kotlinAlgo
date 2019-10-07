package sort

class QuickSort {

    fun sort(array: IntArray, low: Int, high: Int) {

        if (low < high){
            var part = getPatrition(array, low, high)

            sort(array, low, part)
            sort(array, part + 1, high)
        }

    }


    fun getPatrition(array: IntArray, low: Int, high: Int): Int {


        var pivot = low

        var i = low

        var j = high


        while (i < j) {
            while (array[i] < array[pivot]) {
                i++
            }

            while (array[j] > array[pivot]) {
                j--
            }


            var temp = array[i]

            array[i] = array[j]

            array[j] = temp
        }


        var temp = array[pivot]
        array[pivot] = array[j]
        array[j] = temp
        return j
    }
}

fun main() {

    val arr = intArrayOf(12, 11, 13, 5, 8, 6)

    println("Given Array")
    for (element in arr) {
        println(element)
    }

    QuickSort().sort(arr, 0, arr.size - 1)

    println("\nSorted array")
    for (element in arr) {
        println(element)
    }

}