package com.hzh.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object wordCount {
  def main(args: Array[String]): Unit = {
//    1.创建SparkConf对象
    val conf = new SparkConf()
//    2.对conf进行设置
    conf.setMaster("local").setAppName("wc")
//    3.基于配置好的conf创建spark上下文运行环境
    val sparkcontext = new SparkContext(conf)
//    val file: String = wordCount.getClass.getClassLoader.getResource("F:\\idea代码\\scala\\src\\main\\scala\\com\\hzh\\test\\wc.txt").getFile
//    4.数据获取，通过sparkcontext创建RDD
    val line: RDD[String] = sparkcontext.textFile("F:\\idea代码\\scala\\src\\main\\scala\\com\\hzh\\test\\wc.txt")
//    数据转换过程--RDD的转换，转换算子，懒加载
    val word: RDD[String] = line.flatMap(x => x.split(" "))

    val wordAnd1: RDD[(String, Int)] = word.map(x => (x,1))
    val result: RDD[(String, Int)] = wordAnd1.reduceByKey((x, y) => {
      x + y
    })
    line.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).foreach(println)
//    List(1,2,3).flatMap()
//    word.foreach(println)
//    Action算子 启动job
    result.foreach(println)
//    5，关闭SPark上下文对象
    sparkcontext.stop()

  }

}
