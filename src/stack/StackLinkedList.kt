package stack


class StackLinkedList {


    var head: Node? = null

    data class Node(
        var data: Int,
        var last: Node? = null
    )

    fun push(data: Int) {

        print("pushing $data")


        var node = Node(data, null)


        if (head == null) {
            head = node
        } else {
            var tempHead = head
            head = node
            head?.last = tempHead
        }

    }


    fun pop() {
        print("removing ${head?.data}")
        head = head?.last
    }


    fun peek() {
        print("peeking ${head?.data}")
        head = head?.last
    }





}

fun main() {

    var stackLinkedList = StackLinkedList()


}

