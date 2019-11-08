package sysDp

import java.lang.Math.pow

/**
 * Text Justification problem | Recursion and memoization solution as taught in (or at-least as I understood)  MIT 6006
 *
 *
 * Hint to solution
 *
 * What is badness
 *
 * consider this example
 *
 * blah blah blah            blah      blah
 * b   l    a   h       vs   blah      blah
 * reallylongword            reallylongword
 *
 * Badness in a line is number of useless empty spaces (Please note spaces between two words are not 'useless'
 *
 * Implementation of badness is cost of fitting words from i to j
 *
 * or B(i,j) = { if(words can not fit in line depending on given width) = infinity else (number of empty spaces) to nth power
 *
 * Why to nth power?  spaces will be same in greedy and DP solution but idea is we prefer having 1 empty space in two lines than two empty spaces in one line
 *
 *
 * Our goal : To minimize badness while splitting words in a line [Optimzing badness]
 *
 * (helper method get badness does this)
 *
 * okay, solution in five easy steps
 *
 * 1) Define subproblems
 *
 * okay, our first word starts from 0th char in line 1 , no brainer | Where second word starts ?? similarly third fourth
 *  ....so on and so forth
 *
 *  subbproblem : minimize badness for suffix (i:) so, number of subproblems = number of words minimize badness putting each word
 *
 *  number of subproblems = n-1 (we know first word already fits) so O(n) complexity
 *
 *  2) Guess (as said in MIT lecture ) or Sequence of decisions
 *
 *  what decisions/Guesses
 *
 *  Where to end current line starting i and ending at j
 *
 *  choices : all words n so, it must be of order n O(n)
 *
 *
 *  3) Recurrence relation or top down
 *
 *  We will be using recurrence and memoization here : Let the function be named DP[] for notions// getDp() method below
 *
 *  4) Recurse + memoize and find valid top sort
 *
 *  This step needs some knowledge on graphs and games problem (goes out od scope of this note)
 *
 *  hint:  Think of ths as smallest path in weighted DAG where weights are badness [i to j]
 *
 *  Anyhow, valid top sort here is order starts from n, n-1, n-2.....0
 *
 *  5) Solution ?
 *
 *  DP[0]
 *
 *
 */
class TextJustificationMemoization(inputText: String, private val width: Int) {

    private var mWords: List<String> = inputText.split(" ") //String to array list of string each word

    private var mPathPointers = Array<Int?>(mWords.size) { null } // this stores path of actual solution

    private var mDp = Array(mWords.size) { -1 } //memoization data structure


    fun justifyText(): Int {

        var sol = getDp(0)


        mPathPointers.forEach {
            println(it)
        }

        return sol


        /*     val result = ArrayList<String>()


             var from = 0



             while (from != mWords.size) {
                 val next = mPathPointers[from]
                 if (next != null) {
                     result.add(" " + mWords.take(next - from))
                     from = next
                 }
             }

             return result;*/

    }


    private fun getBadness(begin: Int, end: Int): Int {

        // println()

        //  print("begin =  $begin end =  $end")

        var lengthOfWords = mWords.drop(begin).take(end - begin).sumBy { s -> s.length }

        //  print("   lengthOfWords =  $lengthOfWords")

        var numberOfSpaces = end - begin - 1;

        //   print("   numberOfSpaces =  $numberOfSpaces")

        if (lengthOfWords + numberOfSpaces > width) {

            //   print("   badness =  ${Int.MAX_VALUE}")
            return Int.MAX_VALUE
        }

        if (end == mWords.size) //don't care about last line
        {
            //   print("   badness lol  = 0")
            return 0;
        }

        var badness = width - lengthOfWords - numberOfSpaces;

        // No power function for Int in kotlin?

        var mybdn = pow(badness.toDouble(), 3.toDouble()).toInt()

        //      print("   badness = ${mybdn}")
        return mybdn
    }

    /**
     * This method is named such so as to match 6006 lecture mit
     */
    private fun getDp(index: Int): Int {


        if (index == mWords.size) //no words in line is the end of justification
            return 0;

        if (mDp[index] != -1) //if we have solution calculated, return it
            return mDp[index]

        var minCost = Int.MAX_VALUE


        for (k in index + 1 until mWords.size + 1) {

            var dp = getDp(k);

            var cost = getBadness(index, k) + dp




            if (cost < minCost) {
                mPathPointers[index] = k; //remember this part of solution
                minCost = cost;
            }
        }

        mDp[index] = minCost;

        return minCost;
    }
}


fun main() {
    println(TextJustificationMemoization("blah blah blah blah reallylongword", 14).justifyText())
}