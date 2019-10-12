package recursion


class Fibonacci {

    fun getNthFibonacci(n: Int): Int {
        return if (n == 0 || n == 1) {
            1
        } else {
            getNthFibonacci(n - 1) + getNthFibonacci(n - 2)
        }
    }

    var memo = IntArray(100)
    fun getNthFibonacciDP(n: Int): Int {

        if (memo[n] != 0)
            return memo[n]!!

        if (n == 0 || n == 1) {
            memo[n] = 1
            return 1

        } else {
            var s = getNthFibonacci(n - 1) + getNthFibonacci(n - 2)
            memo[n] = s
            return s
        }
    }
}

fun main() {
    var current = System.currentTimeMillis()



    println("${Fibonacci().getNthFibonacciDP(45)} time taken  ${System.currentTimeMillis() - current}")


    current = System.currentTimeMillis()
    println("${Fibonacci().getNthFibonacci(45)} time taken ${System.currentTimeMillis() - current}")

}