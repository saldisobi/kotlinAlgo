package sysDp

import kotlin.math.max
import kotlin.math.min

object CoinGame {

    fun solve(inputArray: IntArray): Int {
        val MV = Array(inputArray.size) { IntArray(inputArray.size) }

        for (i in 0 until  inputArray.size) {
            var index = 0
            var j = i
            while (j < inputArray.size) {
                // a = MV(i+2,j) - Alice chooses i Bob chooses i+1
                // b = MV(i+1,j-1)- Alice chooses i , Bob chooses j OR
                // Alice chooses j , Bob chooses i
                // c = MV(i,j-2)- Alice chooses j , Bob chooses j-1
                val a: Int
                val b: Int
                val c: Int
                if (index + 2 <= j)
                    a = MV[index + 2][j]
                else
                    a = 0
                //////////////////////////////////
                if (index + 1 <= j - 1)
                    b = MV[index + 1][j - 1]
                else
                    b = 0
                //////////////////////////////////
                if (index <= j - 2)
                    c = MV[index][j - 2]
                else
                    c = 0
                //////////////////////////////////
                MV[index][j] = max(inputArray[index] + min(a, b), inputArray[j] + min(b, c))
                index++
                j++
            }
        }
        return MV[0][inputArray.size - 1]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val B = intArrayOf(6, 9, 1, 2, 16, 8)
        println("Max value pick up by player1(Alice) " + solve(B))
    }




}