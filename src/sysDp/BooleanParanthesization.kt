package sysDp

/**
 *
 * Question:
 *https://www.geeksforgeeks.org/boolean-parenthesization-problem-dp-37/
 *
 *
 * Reference to answer
 *
 * https://www.quora.com/How-do-I-solve-the-boolean-parenthesizations-problem-of-dynamic-programming
 *
 *
 * Other hints:
 *
 * One of the substring subproblems not the prefix or suffix
 */
class BooleanParanthesization {

    fun getOptimalParanthesization(operands:CharArray,operators:CharArray) {
        val mFdp = Array(operands.size) { IntArray(operands.size) }
        val mTdp = Array(operands.size) { IntArray(operands.size) }

        for (i in 0 until 10) {
            mFdp[i][i] = if (operands[i] === 'F') 1 else 0
            mTdp[i][i] = if (operands[i] === 'T') 1 else 0
        }
    }
}

fun main(){
    BooleanParanthesization().getOptimalParanthesization(charArrayOf('T','F','T'), charArrayOf('&','|','^'))
}