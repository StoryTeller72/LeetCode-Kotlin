import org.w3c.dom.Node

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
// order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

class ListNode(var `val`: Int) {
         var next: ListNode? = null
}

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        else if (l1 == null) return l2
        else if (l2 == null) return l1

        var addExtra = 0
        var tempNode1 = l1
        var tempNode2 = l2
        var answer: ListNode? = null
        var nodeToAdd: ListNode? = null
        var sum: Int

        while (tempNode1 != null && tempNode2 != null) {
            sum = addExtra
            sum += tempNode1.`val` + tempNode2.`val`
            if (sum >= 10){
                if(answer == null){
                    answer = ListNode(sum % 10)
                    nodeToAdd = answer
                }else {
                    nodeToAdd?.next = ListNode(sum % 10)
                    nodeToAdd = nodeToAdd?.next
                }
                addExtra = 1

            }else{
                if(answer == null){
                    answer = ListNode(sum)
                    nodeToAdd = answer
                }else {
                    nodeToAdd?.next = ListNode(sum)
                    nodeToAdd = nodeToAdd?.next
                }
                addExtra = 0
            }
            tempNode1 = tempNode1.next
            tempNode2 = tempNode2.next
        }

        while (tempNode1 != null){
            sum = addExtra + tempNode1.`val`
            if (sum >= 10){
                    addExtra = 1
                    nodeToAdd?.next = ListNode(sum % 10)
                    nodeToAdd = nodeToAdd?.next
            }else{
                    addExtra = 0
                    nodeToAdd?.next = ListNode(sum)
                    nodeToAdd = nodeToAdd?.next
            }
            tempNode1 = tempNode1.next
        }

        while (tempNode2 != null){
            sum = addExtra + tempNode2.`val`
            if (sum >= 10){
                addExtra = 1
                nodeToAdd?.next = ListNode(sum % 10)
                nodeToAdd = nodeToAdd?.next
            }else{
                addExtra = 0
                nodeToAdd?.next = ListNode(sum)
                nodeToAdd = nodeToAdd?.next
            }
            tempNode2 = tempNode2.next
        }
        if (addExtra == 1){
            nodeToAdd?.next = ListNode(1)
        }

        return answer

    }

    fun printList(head: ListNode){
        var temp: ListNode? = head
        while (temp != null){
            print("${temp.`val`}  ")
            temp = temp.next
        }
    }
}