package sysDp

import java.lang.Integer.max

class KnapSack(var maxWeight: Int, var values: IntArray, var weights: IntArray) {

    var dp = Array(values.size+1) { IntArray(values.size+1) }

    fun getMaxValue() {

        buildTable()


    }

    private fun buildTable() {
        for (i in 0 until maxWeight) {
            for (j in 0 until values.size) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0
                } else if (weights[i - 1] < maxWeight) {
                    dp[i][j] = max(values[i - 1] + dp[i - 1][maxWeight - weights[i - 1]], dp[i - 1][j])
                } else {
                    dp[i][j] = dp[i - 1][j]
                }
            }
        }

        print("max gain : ${dp[values.size][maxWeight]}")
    }
}


fun main() {
    KnapSack(5, intArrayOf(6, 10, 12), intArrayOf(1, 2, 3)).getMaxValue()
}