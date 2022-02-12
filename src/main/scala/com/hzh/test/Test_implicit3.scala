//package com.hzh.test
//
//class Bird(xname:String){
//  val name = xname
//}
//
//object Test_implicit3 {
//  //需要一个参数
//  //函数和属性都可
//  implicit class leiming(bird: Bird){
//    val gender = "body"
//    def fly(): Unit ={
//      println(bird.name + " fly")
//    }
//  }
//
//  def main(args: Array[String]): Unit = {
//    //通过隐式类获取本不存在于类中的属性和函数
//    val bird = new Bird("小鸟")
//    bird.fly()
//    println(bird.gender)
//  }
//
//}
