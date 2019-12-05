package com.link_node

class LinkedList {

  var value: Int = _

  var next: LinkedList = _

  def this(value: Int, next: LinkedList) = {
    this
    this.value = value
    this.next = next
  }

  override def toString: String = s"$value"
}

object LinkedList {

  /**
    * 链表翻转
    *
    * @param head
    * @return
    */
  def reserve(head: LinkedList): LinkedList = {
    var pre: LinkedList = null
    var cur = head
    while (cur != null) {
      val temp = cur.next
      cur.next = pre
      pre = cur
      cur = temp
    }
    pre
  }


  def main(args: Array[String]): Unit = {

    val node = new LinkedList(1, new LinkedList(2, new LinkedList(3, null)))

    val nodes = reserve(node)

    println(nodes.value)
  }

}