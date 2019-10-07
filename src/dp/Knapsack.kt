package dp

class Knapsack {

    fun getMaxWeight(values: IntArray, weights: IntArray, totalWeight: Int): Int {
        val solutionMatrix = Array(values.size + 1) { IntArray(totalWeight + 1) }
        for (i in 0..values.size) {
            for (j in 0..totalWeight) {
                if (i == 0 || j == 0) {
                    solutionMatrix[i][j] = 0
                    continue
                }
                if (j - weights[i - 1] >= 0) {
                    solutionMatrix[i][j] =
                        Math.max(solutionMatrix[i - 1][j], solutionMatrix[i - 1][j - weights[i - 1]] + values[i - 1])
                } else {
                    solutionMatrix[i][j] = solutionMatrix[i - 1][j]
                }
            }
        }
        return solutionMatrix[values.size][totalWeight]
    }
}

fun main() {

    val values = intArrayOf(1, 4, 5, 7)
    val weights = intArrayOf(1, 3, 4, 5)
    print(Knapsack().getMaxWeight(values, weights, 7))
}