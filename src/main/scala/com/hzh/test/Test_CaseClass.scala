package com.hzh.test

/**
 * 样例类：特殊的类，对应自己使用而言： 省心
 * @param name
 * @param age
 */
case class Student(name:String,age:Int)

object Test_CaseClass {
  def main(args: Array[String]): Unit = {
    val student: Student = Student("zs",18)
    val student1 = new Student("lisi",20)
    println(student)
    println(student1)
    //equals是如何执行的？以String举例。先比地址，再比长度，再去对比字符串数组中的值是否是一一对应
    println(student.equals(student1))
  }

}
