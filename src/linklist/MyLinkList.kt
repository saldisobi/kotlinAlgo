package linklist


class MyLinkList {


    var head: Node? = null

    data class Node(
        var data: Int,
        var next: Node? = null
    )

    fun insert(data: Int) {


        var node = Node(data, null)
        if (head == null) {
            head = node
        } else {
            var tempPointer: Node? = head
            while (tempPointer!!.next != null) {
                tempPointer = tempPointer!!.next
            }

            if (tempPointer != null)
                tempPointer.next = node
        }

    }


    fun replaceEveryThird() {
        var counter = 1
        var tempHead = head
        var currentHead: Node? = null
        var currentTail: Node? = null
        while (head != null) {
            counter++
            if (counter % 3 == 0) {


                var list = sortGroup(tempHead!!)

                var loopHead = list[0]
                var loopTail = list[1]



                if (currentTail != null) {
                    //this is repeat
                    currentTail.next = loopHead
                    currentTail = loopTail
                } else {
                    currentTail = loopTail
                    currentHead = loopHead
                }


                tempHead = loopTail?.next
            }

            head = head!!.next
        }

        head = currentHead

        while (head != null) {
            print(head!!.data)
            head = head!!.next

        }

    }


    fun sortGroup(head: Node): ArrayList<Node?> {

        var sortList = ArrayList<Node?>()

        var firstNode: Node? = head

        var secondNode: Node? = head?.next

        var thirdNode: Node? = head?.next?.next

        val temp = thirdNode?.next

        thirdNode?.next = secondNode

        secondNode?.next = firstNode

        firstNode?.next = temp

        sortList.add(thirdNode)
        sortList.add(firstNode)


        return sortList
    }

    fun nThFromLast(n: Int) {

        var pointer_one = 0

        var temp_node: Node? = null

        var temp_node_two: Node
        temp_node_two = head as Node
        if (head == null) {
            println("empty LL")
        } else {
            temp_node = head as Node
            while (temp_node?.next != null) {
                println(temp_node.data)
                temp_node = temp_node?.next
                pointer_one++
                if (pointer_one >= n) {
                    println("pointer one $pointer_one")
                    temp_node_two = temp_node_two.next!!
                }
            }

            println("final answer" + temp_node_two.data)

        }


    }


    fun detectLoop() {
        var pointer_one = head
        var pointer_two = head
        while (pointer_two?.next != null && pointer_one != null && pointer_two != null && pointer_one.next != null) {
            println("pointer one ${pointer_one.next}")
            pointer_one = pointer_one.next
            pointer_two = pointer_two.next!!.next
            if (pointer_one == pointer_two) {
                println("loop hai bc")

                return
            }
        }

        println("finish no loop")

    }


}

fun main() {

    var myLinkList = MyLinkList()
    myLinkList.insert(1)
    //  println("insertion done")
    myLinkList.insert(2)
    //  println("insertion done")
    myLinkList.insert(3)
    //  println("insertion done")
    myLinkList.insert(4)
    myLinkList.insert(5)
    myLinkList.insert(6)
    myLinkList.insert(7)
    myLinkList.insert(8)
    myLinkList.insert(9)

    myLinkList.replaceEveryThird()

    //  println("insertion done")

    // myLinkList.detectLoop()
    //  myLinkList.head?.next!!.next!!.next!!.next = myLinkList.head

    //myLinkList.detectLoop()

    /* var tempPointer = myLinkList.head


     while (tempPointer!!.next != null) {
         tempPointer = tempPointer!!.next
         println(tempPointer!!.data)
     }*/


    /*myLinkList.nThFromLast(1)
    myLinkList.nThFromLast(2)
    myLinkList.nThFromLast(3)
    myLinkList.nThFromLast(4)*/


}

