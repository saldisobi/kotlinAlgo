package dp

class LongestSubsequence {

    fun recursiveSolution(pattern: String, matcher: String): Int {

        return naiveSolution(pattern, matcher)
    }

     fun naiveSolution(pattern: String, matcher: String): Int {
        var patternArray = pattern.toCharArray()

        var matcherArray = matcher.toCharArray()

        var maxCounter = 0
        var currentCount = 0

        for (i in 0 until patternArray.size) {
            if (currentCount > maxCounter)
                maxCounter = currentCount

            currentCount = 0
            var patternPointer = i
            var patternChar = patternArray[i]


            for (i in 0 until matcherArray.size) {
                if (patternChar == matcherArray[i]) {
                    currentCount++
                    patternPointer++
                    if (patternPointer < patternArray.size) {
                        patternChar = patternArray[patternPointer]
                    } else {
                        break
                    }
                }
            }
        }

        return maxCounter
    }
}

fun main() {
    print(LongestSubsequence().naiveSolution("abcaccba", "bcdaccfbaz"))
}