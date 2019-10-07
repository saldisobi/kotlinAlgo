package search

class BinarySearch {
    fun search(arr: IntArray, item: Int, left: Int, right: Int): Int {

        if (left < right) {
            var middle = (left + right) / 2

            if (arr[middle] == item) {
                println("found at index $middle")
                return middle
            } else if (arr[middle] < item) {
                return search(arr, item, left, middle)
            } else {
                return search(arr, item, middle+1, right)
            }
        } else {
            return -1
        }
    }
}

fun main() {
    println(BinarySearch().search(intArrayOf(55, 54, 33, 32, 31, 29, 28, 13, 9, 8, 6, 2), 29, 0, 12))
}