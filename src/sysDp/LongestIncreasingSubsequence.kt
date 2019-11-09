package sysDp

/**
 * Prints in reverse order just wanted to show logic
 *
 */
class LongestIncreasingSubsequence(private var inputList: ArrayList<Int>) {

    var mDp = Array(inputList.size) { 1 }

    fun getLongestIncreasingSubsequence() {
        for (i in 1 until inputList.size) {
            for (j in 0 until i) {
                if (inputList[j] < inputList[i]) {
                    if (mDp[i] < mDp[j] + 1)
                        mDp[i] = mDp[j] + 1
                }
            }
        }

        mDp.forEach {
            println(it)
        }

        //   inputList.add(0,0)
        var lastI = 0
        for (i in inputList.size - 1 downTo 0) {

            if (i > 0) {
                if (mDp[i] > mDp[i - 1]) {
                    print(inputList[i])
                    lastI = inputList[i]
                }
            } else {
                if (inputList[0] < lastI)
                    print(inputList[0])
            }
        }
    }
}

fun main() {

    var inputList = ArrayList<Int>()


    inputList.add(10)
    inputList.add(22)
    inputList.add(9)
    inputList.add(33)
    inputList.add(21)
    inputList.add(50)
    inputList.add(41)
    inputList.add(60)

    LongestIncreasingSubsequence(inputList).getLongestIncreasingSubsequence()
}