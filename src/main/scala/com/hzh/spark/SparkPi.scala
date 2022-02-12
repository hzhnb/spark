package com.hzh.spark

import org.apache.spark.{SparkConf, SparkContext}
import java.lang.Math.random

object SparkPi {
  def main(args: Array[String]): Unit = {
    val num_partitions: Int = if (args.length > 0) {
      args(0).toInt
    } else {
      2
    }
//    点的个数
    val num_points = num_partitions * 100000
    val conf = new SparkConf().setMaster("local").setAppName("pi")
    val sc = new SparkContext(conf)
    println(sc.defaultParallelism)
    val rdd = sc.parallelize(1 to num_points,num_partitions)
//    pi的求取逻辑
//    随机产生[-1,1]
    val result = rdd.map(elements => {
      val x = random() * 2 - 1
      val y = random() * 2 - 1
      if (x * x + y * y < 1) {
        1
      } else {
        0
      }
    }).reduce(_ + _)

//
    val pi = 4.0 * result /num_points
    println(s"Pi is roughly $pi")
    sc.stop()
  }

}
