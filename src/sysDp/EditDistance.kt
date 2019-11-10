package sysDp

import java.lang.Integer.min

class EditDistance(var mStringOne: String, var mStringTwo: String) {

    var mDp = Array(mStringOne.length + 1) { IntArray(mStringTwo.length + 1) }

    fun getEditDistance() {
        buildDpTable()
        printResult()
    }


    fun buildDpTable() {
        for (i in 0 until mStringOne.length + 1) {
            for (j in 0 until mStringTwo.length + 1) {
                if (i == 0 && j == 0) {
                    mDp[i][j] = 0
                } else if (i == 0) {
                    mDp[i][j] = j
                } else if (j == 0) {
                    mDp[i][j] = i
                } else if (mStringOne[i - 1] == mStringTwo[j - 1]) {
                    mDp[i][j] = mDp[i - 1][j - 1]
                } else {
                    mDp[i][j] = min(min(mDp[i - 1][j - 1], mDp[i - 1][j]), mDp[i][j - 1]) + 1
                }
            }
        }
    }

    fun printResult() {
        //this printing of dp table is just for understanding and comparing what I drew on notebook and can be skipped
        for (i in 0 until mStringOne.length + 1) {
            println()
            for (j in 0 until mStringTwo.length + 1) {
                print(mDp[i][j])
            }
        }

        println()
        println("minimum operations required is ${mDp[mStringOne.length][mStringTwo.length]}")

    }
}


fun main() {
    EditDistance("SOURABH", "SAURABH").getEditDistance()
}