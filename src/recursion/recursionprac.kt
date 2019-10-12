package recursion

class recursionprac {

    fun factorial(n: Int): Int {

        return if (n == 1)
            1
        else
            n * factorial(n - 1)
    }

    fun sumForN(n: Int): Int {

        return if (n == 1)
            1
        else n + sumForN(n - 1)
    }


    fun multiply(num: Int, num1: Int): Int {
        return if (num1 == 1)
            num
        else{
            num+multiply(num,num1-1)
        }
    }


    fun pow(num:Int,pwr:Int){

    }
}

fun main() {
    print(recursionprac().multiply(8,8))
}