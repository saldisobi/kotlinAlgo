package sysDp

/**
 * Problem, n as sum of 1, 2, 3
 *
 * Now, let n be 3
 *
 * number of ways
 *
 * 1+1+1
 * 1+2
 * 2+1
 * 3
 *
 * observe carefully, 1+1+1 and 2+1 are sum that end with 1 what is sum except these 2 , so sum of n-2, similarly for n-3 and n-2
 *
 * Total number of ways = (n-1)+(n-2)+(n-3)
 *
 * Base cases n = 1 or n = 0 = 1 || how? check my question here : https://stackoverflow.com/questions/58360973/understanding-base-case-in-dynamic-programming
 *
 * lets dive into solution now
 */
class NasSum {

    fun getWaysForN(n: Int): Int {
        if (n < 0)
            return 0
        return if (n == 0 || n == 1)
            1
        else
            getWaysForN(n - 1) + getWaysForN(n - 2) + getWaysForN(n - 4)


    }
}

fun main(){
   println( NasSum().getWaysForN(5) )
}