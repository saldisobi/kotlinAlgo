package sort


class SelectionSort {
    var mSortList = ArrayList<Int>()
    fun sort() {
        for (i in 0 until mSortList.size - 1) {
            var min = i


            for (j in i until mSortList.size) {
                if (mSortList[j] < mSortList[min]) {
                    min = j
                }

            }


            var temp = mSortList[i]

            mSortList[i] = temp

            mSortList[i] = mSortList[min]

            mSortList[min] = temp


        }

        println(mSortList)
    }
}

fun main() {
    SelectionSort().sort()
}