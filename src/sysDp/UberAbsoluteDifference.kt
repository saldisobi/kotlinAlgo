package sysDp

class UberAbsoluteDifference {

    fun getComparatorValue(arrayOne: IntArray, arrayTwo: IntArray, comparableValue: Int): Int {

        var comparatorValue = 0

        for (i in 0 until arrayOne.size) {
            var arrOneComparable = arrayOne[i]
            var isBreak = false
            innerLoop@
            for (j in 0 until arrayTwo.size) {
                var absoluteDifference = 0

                absoluteDifference = if (arrOneComparable > arrayTwo[j])
                    arrOneComparable - arrayTwo[j]
                else
                    arrayTwo[j] - arrOneComparable

                if (absoluteDifference <= comparableValue) {
                    isBreak = true
                    break@innerLoop
                }
            }
            if (!isBreak)
                comparatorValue++
        }

        return comparatorValue

    }

}


fun main() {
    println(UberAbsoluteDifference().getComparatorValue(intArrayOf(3, 1, 5), intArrayOf(5, 6, 7), 2))
}