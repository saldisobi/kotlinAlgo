package strings

import java.util.*

class StringKMP {

    fun matchPattern(pattern: String, text: String): Int {


        var i = 0 //text pointer

        var j = 0 // pattern pointer

        if (pattern.isEmpty()) {
            return 0
        }

        if (text.length < pattern.length) {
            return -1
        }


        val longestPrefixSuffix = getFiniteAutomata(pattern) // DFA

        println(Arrays.toString(longestPrefixSuffix))

        while (i < text.length) {
            if (text[i] == pattern[j]) {
                // same value found, move both str and pattern pointers to their right
                i++
                j++
                if (j == pattern.length) {
                    // whole match found
                    return i - pattern.length
                }
            } else if (j > 0) {
                // move to best known location
                j = longestPrefixSuffix[j - 1]
            } else {
                // restart searching at next str pointer
                i++
            }
        }
        return -1
    }


    fun getFiniteAutomata(pattern: String): IntArray {

        var finiteAutomata = IntArray(pattern.length)

        var j = 0

        var i = 1 //starting form 1 as single characters fulfils all


        while (i < pattern.length) {
            if (pattern[i] == pattern[j]) {
                j++
                finiteAutomata[i] = j
                i++
            } else run {
                var temp = i - 1
                while (temp > 0) {
                    val prevLPS = finiteAutomata[temp]
                    if (pattern[i] == pattern[prevLPS]) {
                        finiteAutomata[i++] = prevLPS + 1
                        j = prevLPS
                        break
                    } else
                        temp = prevLPS - 1
                }
                if (temp <= 0) {
                    finiteAutomata[i++] = 0
                    j = 0
                }
            }
        }
        return finiteAutomata
    }
}

fun main() {
    println(StringKMP().matchPattern("abcabac", "tttttaaadddabcabacgggg"))
}