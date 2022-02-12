package com.hzh.spark
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
object WordCount {
  def main(args: Array[String]): Unit = {
//    创建SparkConf对象
    val conf = new SparkConf()
//    对conf进行设置
    conf.setMaster("local").setAppName("wc")
//    基于配置好的conf创建spark上下文运行环境
    val sparkcontext = new SparkContext(conf)
//    4.数据获取，通过sparkcontext创建RDD对象
    val line: RDD[String] = sparkcontext.textFile("F:\\idea代码\\scala\\src\\main\\scala\\com\\hzh\\test\\wc.txt")
//    数据转换过程---RDD转换，转换算子，懒加载
    val word: RDD[String] = line.flatMap(x => x.split(" "))
    val wordAnd1: RDD[(String, Int)] = word.map(x => (x,1))
    val result: RDD[(String, Int)] = wordAnd1.reduceByKey((x, y) => {
      x + y
    })
//    Action算子，启动job
    result.foreach(println)
//    关闭spark上下文对象那个
    sparkcontext.stop()
  }

}
