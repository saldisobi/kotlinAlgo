package dp

class FrogJumps {

    var solutionMap = HashMap<Int, Int>()

    fun getJumps(arr: Array<Int>, startIndex: Int): Int {
        if (startIndex == arr.size - 1) {
            // reached end
            return 0
        }

        if (solutionMap.containsKey(arr[startIndex])) {
            return solutionMap[startIndex]!!
        }

        /* if (remainingLength <= arr[startIndex]) {
             //means no further recursion is required
             return 1
         }*/

        return 0
    }
}

fun main() {

    var a = arrayOf(123, 222)

    FrogJumps().getJumps(a, 1)
}