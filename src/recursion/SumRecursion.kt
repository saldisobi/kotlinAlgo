package recursion

class SumRecursion {

    fun sunRecursive(arr: Array<Int>, startIndex: Int): Int {

        if (startIndex >= 0) {
            return when {
                arr.isEmpty() -> 0
                arr.size == 1 -> arr[0]
                else -> arr[startIndex] + sunRecursive(arr, startIndex - 1)
            }
        }

        return 0
    }
}

fun main() {
    print(SumRecursion().sunRecursive(arrayOf(1, 2, 3, 4, 5), 4))
}