package com.hzh.demo

import com.hzh.utils.ContextUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object PVUV2 {
  def main(args: Array[String]): Unit = {
    val sc = ContextUtils.getSparkContext(this.getClass.getSimpleName)
    val lineRDD: RDD[String] = sc.textFile("F:\\idea代码\\scala\\src\\main\\resources\\data\\puuvdata")

    /**
     * (www.suning.com,8)
     * (www.gome.com.cn,4)
     * (www.jd.com,4)
     * (www.dangdang.com,5)
     * (www.taobao.com,3)
     * (www.mi.com,2)
     * (www.baidu.com,7)
     */
//    PV
    lineRDD
      .map(x => (x.split("\t")(5),1))
      .reduceByKey(_+_)
      .foreach(println)
//    UV
//    需要ip和url,并且去重，
    lineRDD.map(x => {
      val strings = x.split("\t")
      (strings(0),strings(5))
    }).distinct().map(x => (x._2,1)).reduceByKey(_+_).foreach(println)
    println("--------------------------------------------------")





    /**
     * key is www.suning.com, value is 7
     * key is www.jd.com, value is 4
     * key is www.baidu.com, value is 6
     * key is www.gome.com.cn, value is 4
     * key is www.dangdang.com, value is 3
     * key is www.taobao.com, value is 3
     * key is www.mi.com, value is 2
     */
    lineRDD.map(x => {
      val strings = x.split("\t")
      (strings(5),strings(0))
    })
      .distinct()
      .countByKey()
       .foreach(x => println(s"key is ${x._1}, value is ${x._2}"))

    sc.stop();
  }

}
