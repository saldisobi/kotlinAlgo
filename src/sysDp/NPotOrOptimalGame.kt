package sysDp

import kotlin.math.max
import kotlin.math.min

class NPotOrOptimalGame(var inputArray: IntArray) {

    var mDp = Array(5) {
        Array(5) { 0 }
    }


    fun getMaxProfit() {

        for (interval in 0 until inputArray.size) {
            var i = 0
            var j = interval
            while (j < inputArray.size) {
                i++
                j++

                // a = mDp(i+2,j) - Player1 chooses i Player2 chooses i+1
                // b = mDp(i+1,j-1)- Player1 chooses i , Player2 chooses j OR
                // Player1 chooses j , Player2 chooses i
                // c = mDp(i,j-2)- Player1 chooses j , Player2 chooses j-1

                var a: Int = 0
                var b: Int = 0
                var c: Int = 0
                if (i + 2 <= j)
                    a = mDp[i + 2][j]

                //////////////////////////////////
                if (i + 1 <= j - 1)
                    b = mDp[i + 1][j - 1]

                //////////////////////////////////
                if (i <= j - 2)
                    c = mDp[i][j - 2]


                mDp[i][j] = max(inputArray[i] + min(a, b),inputArray[j] + min(b, c))
            }
        }
    }

}

fun main() {


    println(NPotOrOptimalGame( intArrayOf(1, 2, 3, 4, 5)).getMaxProfit())
}