package com.hzh.demo

import com.hzh.utils.ContextUtils

object GroupSort {
  def main(args: Array[String]): Unit = {
    val sc = ContextUtils.getSparkContext(this.getClass.getSimpleName)
    val lineRDD = sc.textFile("F:\\idea代码\\scala\\src\\main\\resources\\data\\score.txt")

    /**
     * 班级： d,前三名的成绩为： 84~41~23
     * 班级： e,前三名的成绩为： 98~47~46
     * 班级： a,前三名的成绩为： 86~84~58
     * 班级： b,前三名的成绩为： 98~78~51
     * 班级： f,前三名的成绩为： 48~32~18
     * 班级： m,前三名的成绩为： 48
     * 班级： c,前三名的成绩为： 89~73~47
     */
    lineRDD.map(x=>{
      val strings = x.split(" ")
      (strings(0),strings(1).toInt)
    })
        .groupByKey()
        .map(x=>{
          val group = x._1
          val score: Iterable[Int] = x._2
          val top3: Array[Int] = score.toArray.sortWith(_>_).take(3)
          (group,top3)
        }).foreach(x=>{
          println(s"班级： ${x._1},前三名的成绩为： ${x._2.mkString("~")}")
    })


    sc.stop();
  }

}
