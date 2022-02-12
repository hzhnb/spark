package com.hzh.test

import scala.collection.immutable
import scala.io.StdIn

/**
 * 控制语句循环等
 */
object Test3 {
  def main(args: Array[String]): Unit = {
//    println("请输入年龄:")
//    val age = StdIn.readInt()
//
//    /**
//     * 判断逻辑体中只有一行可以省略大括号
//     */
//    if(age >= 18 && age < 100)
//      println("成年")
//    else if(age > 0 && age < 18){
//      println("未成年")
//    }else{
//      println("???")
//    }
    /**
     * 循环
     * to 包含最后一个元素
     * until 不包含最后一个元素,
     * 返回的都是Range
     * <- 等于集合的foreach
     */
//    println(1 to 10)
//    println(1.to(10))
//    println(1 to (10,2))
//    println(1.to(10,2))
//    println(1 until 10)
//    println(1 until 10,2)
//
    /**
     * for循环中可以追加if判断条件，多个之间封号隔开
     */
//    for(i <- 1 to (10,2);if i>3;if i<8 ){
//      print(i)
//    }
//    println()
//    for(i <- 1 until (10,2);if i>3;if i<8 ){
//      print(i)
//    }
//    println()
//    for (i <- 1 until 10){
//      print(i)
//    }
//    println()
//    for (i <- 1 to  10){
//      print(i)
//    }
//
    /**
     * 在sacla中没有自增，自减运算符
     */
//    var num = 0;
//    num += 1;

//      for (i <- 1 to 9){
//        for (j <- 1 to 9;if j<=i){
//          print(j + "*" + i + "=" + i*j + "\t")
//        }
//        println()
//      }

    /**
     * yield
     */
    val ints = for(i <- 1 to 10;if i>5) yield i+2
    ints.foreach(println)
  }

}
