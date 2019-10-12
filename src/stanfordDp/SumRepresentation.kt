package stanfordDp

class SumRepresentation {

    fun getWaysToSum(number: Int) {
        var sumArray = IntArray(6)

        sumArray[0] = 0

        sumArray[1] = 1

        sumArray[2] = 1

        sumArray[3] = 2

        for (i in 4 until number+1) {

            sumArray[i] = sumArray[i - 1] + sumArray[i - 3] + sumArray[i - 4]
        }

        sumArray.forEach {
            print(it)
        }
    }
}

fun main() {
    SumRepresentation().getWaysToSum(5)
}