package com.hzh.spark.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * action算子的个数等同于当前application中job的个数
 */

object ActionFun {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf()
    conf.setMaster("local").setAppName("action_operator")
    val sc = new SparkContext(conf)
    val lineRDD: RDD[String] = sc.textFile("F:\\idea代码\\scala\\src\\main\\scala\\com\\hzh\\spark\\wc.txt")

    /**
     * 行动算子
     * count,foreach,collect,take,first
     */
    /**
     * hello nih
     * hello shanghai
     * hello beijing
     * hello nih
     * hello shanghai
     * hello beijing
     * hello nih
     * hello shanghai
     * hello beijing
     * hello nih
     * hello shanghai
     * hello beijing
     * hello nih
     * hello shanghai
     * hello beijing
     */
    lineRDD.foreach(println)
//    15
    println(lineRDD.count())

    /**
     * hello nih
     * hello shanghai
     * hello beijing
     * hello nih
     * hello shanghai
     * hello beijing
     * hello nih
     * hello shanghai
     * hello beijing
     * hello nih
     * hello shanghai
     * hello beijing
     * hello nih
     * hello shanghai
     * hello beijing
     */
    lineRDD.collect().foreach(println)

    /**
     * hello nih
     * hello shanghai
     */

    lineRDD.take(2).foreach(println)

    val str: String = lineRDD.first()

    /**
     * hello nih
     */

    println(str)

    sc.stop()
  }

}
