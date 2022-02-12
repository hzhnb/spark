package com.hzh.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object worc {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local").setAppName("WC")
    val sc = new SparkContext(conf)
    val lines: RDD[String] = sc.textFile("F:\\idea代码\\scala\\src\\main\\scala\\com\\hzh\\test\\wc.txt")
    val word: RDD[String] = lines.flatMap{
      lines => {
        lines.split(" ")
      }}
    val pairs: RDD[(String, Int)] = word.map{ x => (x,1)}
    val result = pairs.reduceByKey{(a,b)=>{a+b}}
    result.sortBy(_._2,false).foreach(println)

  }

}
