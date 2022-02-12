package com.hzh.test

/**
 * 坐标轴上的点比较
 */
trait Equal {
  def isEqual(x: Any): Boolean

  def isNotEqual(x: Any): Boolean = {
    !isEqual(x)
  }
}

class Point(xx:Int,yy:Int) extends Equal{
    //横纵坐标
  val x = xx
  val y = yy

  // scala  中判断一个对象是否是某个类的实例化对象
  //注意先判断，在转换，如果对象是null,那么操作会返回false null
  override def isEqual(p: Any): Boolean = {
      if(p.isInstanceOf[Point]){
        val point: Point = p.asInstanceOf[Point]
        x == point.x && y == point.y
      }else{
        false
      }
  }
}



object Test_trait2 {
  def main(args: Array[String]): Unit = {
    val point1 = new Point(1,2)
    val point2 = new Point(1,3)
    println(point1.isEqual(point2))
  }
}
