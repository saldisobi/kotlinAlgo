package sort




class MergeSort   {


    fun sort(arr: IntArray, l: Int, r: Int) {
        if (l < r) {
            // Find the middle point
            val m = (l + r) / 2

            // Sort first and second halves
            sort(arr, l, m)
            sort(arr, m + 1, r)

            // Merge the sorted halves

            println("merging array aux")
            for (element in arr) {
                println(element)
            }
            mergeMe(arr, l, m, r)
        }
    }


    fun mergeMe(arr: IntArray, l: Int, m: Int, r: Int) {


        var leftLength = m - l + 1

        var rightLength = r - m


        var LeftArray = IntArray(leftLength)

        var rightArray = IntArray(rightLength)

        for (i in 0 until leftLength) {
            LeftArray[i] = arr[l + i]

        }

        for (i in 0 until rightLength) {
            rightArray[i] = arr[m + i + 1]

        }

        var leftPointer = 0

        var rightPointer = 0

        var k = l
        while (leftPointer < leftLength && rightPointer < rightLength) {
            if (LeftArray[leftPointer] < rightArray[rightPointer]) {
                arr[k] = LeftArray[leftPointer]

                leftPointer++
            } else {
                arr[k] = rightArray[rightPointer]
                rightPointer++
            }

            k++


        }


        while (leftPointer < leftLength) {
            arr[k] = LeftArray[leftPointer]
            leftPointer++
            k++
        }

        while (rightPointer < rightLength) {
            arr[k] = rightArray[rightPointer]
            rightPointer++
            k++
        }

    }


    fun merge(arr: IntArray, l: Int, m: Int, r: Int) {
        // Find sizes of two subarrays to be merged
        val n1 = m - l + 1
        val n2 = r - m

        /* Create temp arrays */
        val L = IntArray(n1)
        val R = IntArray(n2)

        /*Copy data to temp arrays*/
        for (i in 0 until n1)
            L[i] = arr[l + i]
        for (j in 0 until n2)
            R[j] = arr[m + 1 + j]


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        var i = 0
        var j = 0

        // Initial index of merged subarry array
        var k = l
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i]
                i++
            } else {
                arr[k] = R[j]
                j++
            }
            k++
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i]
            i++
            k++
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j]
            j++
            k++
        }
    }


}

fun main() {
    val arr = intArrayOf(12, 11, 13, 5, 8, 6)

    println("Given Array")
    for (element in arr) {
        println(element)
    }

    MergeSort().sort(arr, 0, arr.size - 1)

    println("\nSorted array")
    for (element in arr) {
        println(element)
    }
}