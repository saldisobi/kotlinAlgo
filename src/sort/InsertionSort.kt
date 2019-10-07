package sort



class InsertionSort () {

    var mSortList = ArrayList<Int>()

    fun sort() {

        for (i in 1 until mSortList.size) {
            var key = mSortList[i]

            var j = i - 1

            while (j >= 0 && mSortList[j] > key) {
                mSortList[j + 1] = mSortList[j]
                j--
            }
            mSortList[j+1] = key
        }

        println(mSortList)
    }
}



fun main() {
    InsertionSort().sort()
}