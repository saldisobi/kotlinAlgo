package sysDp

class LongestPathInMatrix(inputMarix: Array<IntArray>) {

    var mDp = Array(inputMarix.size) { IntArray(inputMarix[0].size) }

    fun getLongestPath(){

    }
}

fun main() {
    val inputMatrix: Array<IntArray> = arrayOf(
        intArrayOf(1, 2, 9),
        intArrayOf(5, 3, 8),
        intArrayOf(4, 6, 7)
    )
    LongestPathInMatrix(inputMatrix)
}