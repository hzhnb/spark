package com.hzh.demo

import com.hzh.utils.ContextUtils

object SecondSortKeyTest {
  def main(args: Array[String]): Unit = {
    val sc = ContextUtils.getSparkContext(this.getClass.getSimpleName)
    val lineRDD = sc.textFile("F:\\idea代码\\scala\\src\\main\\resources\\data\\secondSort.txt")
    lineRDD
        .map(x => {
          val strings = x.split(" ")
          (new SecondSortKeyScala(strings(0).toInt,strings(1).toInt),x)
        })
        .sortByKey()
        .foreach(x => println(x._2))

    sc.stop()
  }

}

/**
 * ordered:源码中标记，写的example是样例类
 * 注意：
 * scala中类的成员属性和构造参数的区别
 * 解决方式：样例类(case)或者在构造参数前跟上val
 * @param first
 * @param second
 */
class SecondSortKeyScala(val first:Int,val second:Int) extends Serializable with Ordered[SecondSortKeyScala]{
  override def compare(that: SecondSortKeyScala): Int = {
    val value = this.first - that.first
    if (value == 0){
      return this.second - that.second
    }
    value
  }
}
