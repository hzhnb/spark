package com.hzh.test

import scala.io.StdIn

object Test1 {
  def main(args: Array[String]): Unit = {
    println("请输入姓名")
    val name = StdIn.readLine()
    println("请输入年龄")
    val age = StdIn.readInt()
    printf("您输入的姓名是%s,年轻是%d",name,age)
  }
}
