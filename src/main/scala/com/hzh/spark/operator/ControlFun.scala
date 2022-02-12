package com.hzh.spark.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

/**
 * 持久化算子cache,对rdd进行持久化到内存的操作，(中间结果的持久化),能够提升性能
 * persist和cache,persist记忆一些存储级别， 这两个算子多用做性能优化
 * checkpoint:容错
 */
object ControlFun {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local").setAppName("cache")
    val sc = new SparkContext(conf)
//    checkpoint使用需要设置数据存储路径
    sc.setCheckpointDir("./checkpoint")
    val lineRDD: RDD[String] = sc.textFile("F:\\idea代码\\scala\\src\\main\\scala\\com\\hzh\\spark\\wc.txt")
//    cache() = persist()  只放在内存
//    lineRDD.cache()
//    lineRDD.persist(StorageLevel.DISK_ONLY)
    lineRDD.checkpoint()
    val startTime = System.currentTimeMillis()
    val count = lineRDD.count()
    val endTime = System.currentTimeMillis()
//    用时9759
//    开启cache后，11430
    println(s"此rdd共有$count 条数据，初始化数据以及cache用时为${endTime-startTime}")


    val startTime2 = System.currentTimeMillis()
    val count2 = lineRDD.count()
    val endTime2 = System.currentTimeMillis()
//    用时2967
//    开启cache后：520
    println(s"此rdd共有$count2 条数据，初始化数据以及cache用时为${endTime2-startTime2}")


    sc.stop()

  }

}
