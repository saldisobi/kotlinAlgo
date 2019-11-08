package sysDp

import kotlin.math.max

/**
 * Refer Text justification for steps details
 *
 * 1) Subproblems?
 *
 * prefix or suffix , so most of the cases sub-problems are prefix or suffix | Substring in special cases like matrix multiplication
 *
 * let s1 and s2 be two strings of length i and j respectively
 *
 * LCS(i,j) = LCS(i:,j:)
 *
 *
 * 2) Guess or sequence of decisions
 *
 * In this case lets say last characters of s1 and s2  match.
 * what happens now? LCS aka. lowest common subsequence is 1+lcs(i-1,j-1) what if they do not match
 *
 * whether to move 1 pointer in s1 or s2 possible that second character of s1 matches with first character of s2 or vice-versa
 *
 * 3) Recurrence | bottom up
 *
 * LCS(i,j) =  { if current pointer characters match it will be  LCS(i,j) = lcs(i-1,j-1) or generalize lets say for any arbitary number s1i,s2j
 *
 * LCS(i,j) = { if(match) LCS(i,j) = 1+LCS(i-1-1,j-1) else max of (LCS(i-1,j) and LCS(j-1,i)
 *
 * 4) Topological sort
 *
 * Another problem with shortest distance in DAG, do any way
 *
 *
 */
class LongestCommonSubsequenceDp(var s1: String, var s2: String) {

    var mDp = Array(s1.length + 1) { IntArray(s2.length + 1) }

    var solution = ""


    fun getLcs() {
        buildTable()
        printTable()
        print(solution.reversed())
    }


    private fun printTable() {
        var i = s1.length
        var j = s2.length

        var sol = ""
        while (i > 0 && j > 0) {
            if (mDp[i][j] > mDp[i - 1][j] && mDp[i][j] > mDp[i][j - 1]) {
                //this has to be part of solution
                sol += s1[i - 1]
                i--
                j--
            } else if (mDp[i][j] == mDp[i - 1][j]) {
                i--
            } else if (mDp[i][j] == mDp[i][j - 1]) {
                j--
            }
        }

        println(sol.reversed())
    }


    private fun buildTable(): Int {

        for (i in 0 until s1.length + 1) {
            for (j in 0 until s2.length + 1) {
                if (i == 0 || j == 0) {
                    mDp[i][j] = 0
                } else if (s1[i - 1] == s2[j - 1]) {
                    mDp[i][j] = mDp[i - 1][j - 1] + 1
                } else {
                    //characters do not match get diagonal element
                    mDp[i][j] = max(mDp[i - 1][j], mDp[i][j - 1])
                }
            }
        }


        return mDp[s1.length][s2.length]
    }
}

fun main() {
    LongestCommonSubsequenceDp("saurach", "rach").getLcs()
}