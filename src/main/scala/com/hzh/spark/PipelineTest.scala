package com.hzh.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object PipelineTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local").setAppName("pipeline")
    val sc = new SparkContext(conf)
    val rdd: RDD[Int] = sc.makeRDD(Array(1,2,3,4))

    /**
     * 管道计算，先进先出
     */
    /**
     * 当前map1
     * 当前filter1
     * 当前map2
     * 当前filter2
     * 当前map3
     * 当前filter3
     * 当前map4
     * 当前filter4
     */
    val rdd1 = rdd.map(x => {
      println("当前map" + x)
      x
    })
    val rdd2: RDD[Int] = rdd1.filter(x => {
      println("当前map" + x)
      true
    })
    rdd2.collect()


    sc.stop()
  }

}
