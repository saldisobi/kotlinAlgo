package sysDp

import kotlin.math.max
import kotlin.math.min

object Problem08 {
     lateinit var dp: Array<IntArray>

    fun optimalGameStrategy(arr: IntArray, i: Int, j: Int): Int {
        //If one single element then choose that.
        if (i == j) return arr[i]

        //If only two elements then choose the max.
        if (i + 1 == j) return max(arr[i], arr[j])

        //If the result is already computed, then return that.
        if (dp[i][j] != -1) return dp[i][j]

        /**
         * If I choose i, then the array length will shrink to i+1 to j.
         * The next move is of the opponent. And whatever he choose, I would want the result to be
         * minimum. If he choose j, then array will shrink to i+1, j-1. But if also choose i then
         * array will shrink to i+2,j. Whatever he choose, I want the result to be min, hence I take
         * the minimum of his two choices.
         *
         * Similarly for a case, when I choose j.
         *
         * I will eventually take the maximum of both of my case. :)
         */
        val iChooseI = arr[i] + min(optimalGameStrategy(arr, i + 1, j - 1), optimalGameStrategy(arr, i + 2, j))
        val iChooseJ = arr[j] + min(optimalGameStrategy(arr, i + 1, j - 1), optimalGameStrategy(arr, i, j - 2))
        val res = max(iChooseI, iChooseJ)
        dp[i][j] = res
        return res
    }


    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(5, 3, 7, 10)
        dp = Array(arr.size) { IntArray(arr.size) }
        for (i in arr.indices) {
            for (j in arr.indices) {
                dp[i][j] = -1
            }
        }
        println(" Nas: " + optimalGameStrategy(arr, 0, arr.size - 1))
    }
}