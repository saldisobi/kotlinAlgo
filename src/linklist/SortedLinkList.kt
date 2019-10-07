package linklist


class SortedLinkList {


    var head: Node? = null

    data class Node(
        var data: Int,
        var next: Node? = null
    )

    fun insert(data: Int) {

        println("inserting $data")

        var node = Node(data, null)
        if (head == null) {
            head = node
        } else {
            if (data < head!!.data) {
                node.next = head
                head = node
                return
            }
            var tempPointer: Node? = head

            var previousPointer: Node? = head


            while (node.data > tempPointer!!.data && tempPointer.next != null) {
                println("node data  ${node.data} temp data ${tempPointer.data}")
                previousPointer = tempPointer
                tempPointer = tempPointer!!.next
            }

            dothat(tempPointer, node, previousPointer!!)
        }

    }


    fun dothat(tempPointer: Node, node: Node, previousPointer: Node) {
        if (tempPointer.next == null && tempPointer.data < node.data) {
            println("exited because it reached tail")
            //only insertion needed
            tempPointer.next = node
        } else {
            // this is position where it should be inserted
            println("this is position where it should be inserted")
            node.next = tempPointer
            previousPointer?.next = node
        }
    }


    fun reverseList() {
        var currentNode = head


        while (currentNode!!.next !=null &&currentNode.next!!.next!= null) {
            var prevnode = currentNode
            var currentNode = currentNode!!.next
            var nextNode = currentNode!!.next
            currentNode.next = prevnode

        }

        head = currentNode
    }

}

fun main() {

    var myLinkList = SortedLinkList()
    myLinkList.insert(1)
    printLL(myLinkList)

    myLinkList.insert(67)
    printLL(myLinkList)

    myLinkList.insert(190)
    printLL(myLinkList)

    myLinkList.insert(16)
    printLL(myLinkList)

    myLinkList.insert(188)
    printLL(myLinkList)

    myLinkList.insert(34)
    printLL(myLinkList)


    myLinkList.insert(400)
    printLL(myLinkList)

    myLinkList.insert(0)
    printLL(myLinkList)

    myLinkList.insert(187)
    printLL(myLinkList)

    myLinkList.insert(191)


    myLinkList.reverseList()

    printLL(myLinkList)

}


fun printLL(myLinkList: SortedLinkList) {
    println("fresh print requested ")
    var tempPointer = myLinkList.head

    println(tempPointer!!.data)
    while (tempPointer!!.next != null) {
        tempPointer = tempPointer!!.next
        println(tempPointer!!.data)
    }
}

