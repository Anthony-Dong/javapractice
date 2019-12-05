package com.tree

/**
  * 定义树
  */
class TreeNode {

  var value: Int = _

  var left: TreeNode = _

  var right: TreeNode = _


  def this(value: Int) = {
    this
    this.value = value
  }
}

object TreeNode {

  /**
    * 先序遍历 , 先根
    *
    * @param root
    */
  def recursionPreOrderTraversal(root: TreeNode): Unit = {
    if (null == root) return
    println(root.value)
    recursionPreOrderTraversal(root.left)
    recursionPreOrderTraversal(root.right)
  }

  /**
    * 中序遍历
    *
    * @param root
    */
  def recursionMidOrderTraversal(root: TreeNode): Unit = {
    if (null != root) {
      recursionPreOrderTraversal(root.left)
      println(root.value)
      recursionPreOrderTraversal(root.right)
    }
  }

  /**
    * 后续遍历
    *
    * @param root
    */
  def recursionAftOrderTraversal(root: TreeNode): Unit = {
    if (null != root) {
      recursionPreOrderTraversal(root.left)
      recursionPreOrderTraversal(root.right)
      println(root.value)
    }
  }

  def main(args: Array[String]): Unit = {
       val node = new TreeNode(1)
       node.right = new TreeNode(2)
       node.left = new TreeNode(3)
       recursionPreOrderTraversal(node)
  }


  def sum(arr: Array[Int], start: Int): Int = {
    if (start == arr.length) {
      return 0
    }
    arr(start) + sum(arr, start + 1)
  }

}
