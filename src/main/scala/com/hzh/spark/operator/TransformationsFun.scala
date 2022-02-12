package com.hzh.spark.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * 转换算子是对rdd相互转换
 * filter\map\flarMap\sample\reduceBuKey
 *
 */
object TransformationsFun {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf()
    conf.setMaster("local").setAppName("transformation_operator")
    val sc: SparkContext = new SparkContext(conf)
//    //数据(RDD)的产生,rdd之间的相互转换
//    val lineRdd: RDD[String] = sc.textFile("F:\\idea代码\\scala\\src\\main\\scala\\com\\hzh\\spark\\wc.txt")
//    println(sc.defaultMinPartitions)
//    println(sc.defaultParallelism)
//
//    /**
//     * filter
//     * filter不会改变数据的整体结构
//     */
//    val resultRDD = lineRdd.filter(x => {
//      if (x.contains("shanghai")) {
//        true
//      } else {
//        false
//      }
//    })
//    resultRDD.foreach(println)
//    println("__________________________________________________________________")
//
//    /**
//     * map & flatmap
//     */
//    val value: RDD[Array[String]] = lineRdd.map(x => x.split(" "))
//    val value1: RDD[String] = lineRdd.flatMap(_.split(" "))
//    value.foreach(println)
//    value1.foreach(println)
//
//    /**
//     * reduceBykey
//     */
//    lineRdd.map(x => (x,1)).reduceByKey(_+_).foreach(println)

    /**
     * sortByKey & sortBy
     * 排序，sortBy指定key再去排序
     * 默认升序，false降序排序
     */
//    val result: RDD[(String, Int)] = lineRdd.flatMap(_.split(" ")).map((_,1)).reduceByKey((x, y)=> x + y)
//    result.sortBy(_._2).foreach(println)
//    result.sortBy(_._2,false).foreach(println)
//    result.sortBy(_._1).foreach(println)
//    result.sortBy(_._1,false).foreach(println)
//    result.sortByKey().foreach(println)

    /**
     * sample
     * 抽样:在后期spark优化中，定位数据倾斜可用到
     */
//    lineRdd.sample(true,0.5).foreach(println)
//    ------------下列算子研究并行度问题-----------------
    /**
     * join
     * 产生新rdd的分区数继承大的rdd
     * 并行度 = partition的个数 = task的个数
     */
//    通过数据集合产生rdd数据
//    val rdd1: RDD[(Int, String)] = sc.parallelize(List(
//      Tuple2(0, "aaa"),
//      Tuple2(1, "bbb"),
//      Tuple2(2, "ccc"),
//      Tuple2(4, "ddd"),
//    ),4)
//    val rdd2: RDD[(Int, Int)] = sc.parallelize(List(
//      Tuple2(0, 100),
//      Tuple2(1, 88),
//      Tuple2(2, 77),
//      Tuple2(3, 0),
//    ),2)
//    val rdd3: RDD[(Int, (String, Int))] = rdd1.join(rdd2)
//    rdd3.foreach(println)//(0,(aaa,100))   (1,(bbb,88))   (2,(ccc,77))
//    val rdd4: RDD[(Int, (String, Option[Int]))] = rdd1.leftOuterJoin(rdd2)
//    val rdd5: RDD[(Int, (Option[String], Int))] = rdd1.rightOuterJoin(rdd2)
//    val rdd6: RDD[(Int, (Option[String], Option[Int]))] = rdd1.fullOuterJoin(rdd2)
//    println(rdd3.getNumPartitions)// 4
//    println(rdd3.partitions.size)// 4
    /**
     * union
     * 子rdd并行度为父rdd并行度之和
     */
//    val rdd1 = sc.parallelize(List(1,2,3,4),4)
//    val rdd2 = sc.parallelize(List(4,5,6),2)
//    val rdd3: RDD[Int] = rdd2.union(rdd1)
//    println(rdd3.getNumPartitions)//6

    /**
     * 交集，intersection
     * 子rdd的并行度为父rdd中并行度大的那个
     */
//    val rdd4: RDD[Int] = rdd1.intersection(rdd2)
//    rdd4.foreach(println)  //4
//    println(rdd4.getNumPartitions)//4
    /**
     * subtract 差集
     * 子rdd并行度为父rdd中并行度大的那个
     */
//    val rdd5: RDD[Int] = rdd1.subtract(rdd2)
//    rdd5.foreach(println)//1,2,3
//    println(rdd5.getNumPartitions)//4
    /**
     * mapPartitions
     * 和数据库相关的操作(外存)
     * 类似于批量处理
     */
//    4到3分区中
    /**
     * 创建数据库连接
     * 查询到数据库中数据1
     * 关闭数据库连接
     *
     * 创建数据库连接
     * 查询到数据库中数据2
     * 关闭数据库连接
     *
     * 创建数据库连接
     * 查询到数据库中数据3
     * 查询到数据库中数据4
     * 关闭数据库连接
     */
//    val rdd = sc.parallelize(List(1,2,3,4,5,6,7,8,9,0),3)
//    rdd.mapPartitions(iter => {
//      println("创建数据库连接")
//      val list = List()
//      while (iter.hasNext){
//        val i = iter.next()
//        println("查询到数据库中数据" + i)
//        i +: list
//      }
//      println("关闭数据库连接")
//      list.iterator
//    }).count()

    /**
     * 创建数据库连接
     * 查询到数据库中的数据1
     * 关闭数据库连接
     *
     * 创建数据库连接
     * 查询到数据库中的数据2
     * 关闭数据库连接
     *
     * 创建数据库连接
     * 查询到数据库中的数据3
     * 关闭数据库连接
     * 创建数据库连接
     * 查询到数据库中的数据4
     * 关闭数据库连接
     */
//    rdd.map(x=>{
//      println("创建数据库连接")
//      println("查询到数据库中的数据" + x)
//      println("关闭数据库连接")
//      x
//    }).count()
    /**
     * 创建数据库连接
     * 查询到数据库中数据1
     * 查询到数据库中数据2
     * 查询到数据库中数据3
     * 关闭数据库连接
     *
     * 创建数据库连接
     * 查询到数据库中数据4
     * 查询到数据库中数据5
     * 查询到数据库中数据6
     * 关闭数据库连接
     *
     * 创建数据库连接
     * 查询到数据库中数据7
     * 查询到数据库中数据8
     * 查询到数据库中数据9
     * 查询到数据库中数据0
     * 关闭数据库连接
     */
//    rdd.foreachPartition(iter => {
//      println("创建数据库连接")
//      val list = List()
//      while (iter.hasNext){
//        val i = iter.next()
//        println("查询到数据库中数据" + i)
//      }
//      println("关闭数据库连接")
//    })

    /**
     * 创建数据库连接
     * 查询到数据库中的数据1
     * 关闭数据库连接
     * 创建数据库连接
     * 查询到数据库中的数据2
     * 关闭数据库连接
     * 创建数据库连接
     * 查询到数据库中的数据3
     * 关闭数据库连接
     *
     * 创建数据库连接
     * 查询到数据库中的数据4
     * 关闭数据库连接
     * 创建数据库连接
     * 查询到数据库中的数据5
     * 关闭数据库连接
     * 创建数据库连接
     * 查询到数据库中的数据6
     * 关闭数据库连接
     *
     * 创建数据库连接
     * 查询到数据库中的数据7
     * 关闭数据库连接
     * 创建数据库连接
     * 查询到数据库中的数据8
     * 关闭数据库连接
     * 创建数据库连接
     * 查询到数据库中的数据9
     * 关闭数据库连接
     * 创建数据库连接
     * 查询到数据库中的数据0
     * 关闭数据库连接
     */
//    rdd.foreach(x=>{
//      println("创建数据库连接")
//      println("查询到数据库中的数据" + x)
//      println("关闭数据库连接")
//      x
//    })

    /**
     * distinct
     * 哪些操作可以改变并行度
     * 如何自己实现：
     * map + reduceByKey(num) + map
     *
     */
    val rdd: RDD[Int] = sc.parallelize(List(1,2,2,3,3,4,5,6),3)

    /**
     * 6
     * 3
     *
     * 4
     * 1
     *
     * 5
     * 2
     */
//    rdd.distinct().foreach(println)
    /**
     * 6
     *
     * 1
     *
     * 2
     *
     * 3
     *
     * 4
     *
     * 5
     */
    rdd.distinct(6).foreach(println)
    sc.stop()
  }

}
