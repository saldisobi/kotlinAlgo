package sysDp

class SubsetSum(var input: IntArray, var sum: Int) {

    var mDp = Array(input.size + 1) { Array<Boolean>(sum + 1) { false } }

    fun isSum(): Boolean {
        for (i in 0 until input.size + 1) {
            for (j in 0 until sum + 1) {
                when {
                    i == 0 -> mDp[i][j] = false //if empty set how will you make any sum out of it?
                    j == 0 -> mDp[i][j] = true // you don't have to make  any sum
                    input[i - 1] <= j -> mDp[i][j] = mDp[i - 1][j] ||
                            mDp[i - 1][j - input[i - 1]]
                    else -> mDp[i][j] = mDp[i - 1][j]
                }
            }
        }
        printResult()

        println()
        return mDp[input.size][sum]
    }

    private fun printResult() {
        for (i in 0 until input.size + 1) {
            println()
            for (j in 0 until sum + 1) {
                print(mDp[i][j])
                print("  ")
            }
        }

    }
}

fun main() {
    println("check if sum ${SubsetSum(intArrayOf(3, 34, 4, 12, 5, 2), 6).isSum()}")
}