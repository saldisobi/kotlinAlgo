package sort


class BubbleSort {

    var mSortList = ArrayList<Int>()
    fun sort() {
        for (j in 0 until mSortList.size - 1) {
            for (i in 0 until mSortList.size - 1) {
                if (mSortList[i] > mSortList[i + 1]) {
                    var temp = mSortList[i]
                    mSortList[i] = mSortList[i + 1]
                    mSortList[i + 1] = temp
                }
            }
        }

        println(mSortList)
    }
}


fun main() {
    BubbleSort().sort()
}