package com.sort

object BucketSortScala {


  def sort(arr: Array[Int], count: Int): Unit = {

    if (null == arr || arr.length <= 1) {
      return
    }

    /**
      * 找到最大值最小值
      */
    var max = arr(0)
    var min = arr(0)
    for (elem <- arr) {
      if (elem > max) max = elem
      if (elem < min) min = elem
    }

    /**
      * 找到区间
      */

    val internal = if ((max - min + 1) % count == 0) (max - min + 1) / count else (max - min + 1) / count + 1







  }


}
