package stack

class MyStack<E> {

    var mDataStore: ArrayList<E> = ArrayList()

    var mPointer = -1

    fun push(e: E) {
        mDataStore.add(e)
        mPointer++

    }

    fun pop() {
        println("removed ${mDataStore[mPointer]}")
        mDataStore.removeAt(mPointer)
        mPointer--
    }
}

fun main() {
    var stack = MyStack<String>()
    stack.push("ruuch")
    stack.push("kaddu")
    stack.push("rach")
    stack.push("mottu")
    stack.push("Kaju")
    stack.push("kaaja")

    stack.pop()

    stack.pop()

    stack.pop()

    stack.pop()

}