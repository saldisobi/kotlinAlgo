package stack

import java.util.*


object RectArea {
    // The main function to find the maximum rectangular area under given
    // histogram with n bars
    private fun getMaxArea(hist: IntArray): Int {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        val s = Stack<Int>()

        var max_area = 0 // Initialize max area
        var tp: Int // To store top of stack
        var area_with_top: Int // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        var i = 0


        while (i < hist.size) {

            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || hist[s.peek()] <= hist[i]) {

                println("pushing to stack $i")
                s.push(i)
                i++
            } else {
                tp = s.peek() // store the top index
                s.pop() // pop the top

             //   println("not pushing this time  done pop top is $tp")

                // Calculate the area with hist[tp] stack as smallest bar
                if (s.empty()) {
                 //   println("stack is empty just w*h")
                } else {
                 //   println("i is $i " + "s.peek is " + s.peek() + "width is ${i - s.peek() - 1}")
                }

                area_with_top = hist[tp] * if (s.empty()) i else i - s.peek() - 1

                println("area with current top which is $tp with value ${hist[tp]} is $area_with_top")

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top

              //  println("max area is $max_area")
            }// If this bar is lower than top of stack, then calculate area of rectangle
            // with stack top as the smallest (or minimum height) bar. 'i' is
            // 'right index' for the top and element before top in stack is 'left index'
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!s.empty()) {
           // println("next while")
            tp = s.peek()

           // println("i is $i " + "s.peek is " + s.peek() + "width is ${i - s.peek() - 1}")

            s.pop()
            area_with_top = hist[tp] * if (s.empty()) i else i - s.peek() - 1
            println("area with current top which is $tp with value ${hist[tp]} is $area_with_top")

            if (max_area < area_with_top)
                max_area = area_with_top
        }

        return max_area

    }

    // Driver program to test above function
    @JvmStatic
    fun main(args: Array<String>) {
        val hist = intArrayOf(6, 4, 4,1,2,3,2,5)
        println("Maximum area is " + getMaxArea(hist))
    }
}
