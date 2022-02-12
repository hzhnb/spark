//package com.hzh.test
//
///**
// * 一行的结尾可以省略分号
// * var修饰变量 val修饰常量
// * class类默认实现了get,set方法
// */
//class Person(xname:String,xage:Int){
//  val name = xname
//  val age = xage
//  var money = 100
//
//  {
//    println(111)
//    println(222)
//    println(333)
//  }
//
//  def test():Unit={
////    println("我会被打印吗？"+Test.height)
//
//  }
//  /**
//   * 构造器重写,必须调用对应的默认构造器，
//   * scala分为主构造器和辅助构造器，
//   * 主构造器是写在类上面的，辅助构造器是在类里面的
//   */
//  def this(xname:String,xage:Int,xmoney:Int){
//    this(xname,xage)
//    money = xmoney
//
//  }
//}
//
///**
// * object中的数据或者是函数都是静态的，不能传参
// */
//object Test {
//   private var height = 180
//  /**
//   * 函数的主入口
//   * scala中没有static关键字
//   * 所有想要具有java中static属性的东西，都放在object中
//   * 静态的不需要被实例化对象即可调用，main为程序的主入口
//   * 伴生类和伴生对象 class和object名字相同
//   * @param args
//   */
//  def main(args: Array[String]): Unit = {
//    var a = 1;val b = 2
//    a = 2
//    //    print(a)
//    val person = new Person("lisi",10)
//    println(person.name + person.age +person.money)
//    val person2 = new Person("lisi",10,xmoney = 200)
//    println(person2.name + person2.age + person2.money)
//  }
//}
