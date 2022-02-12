package com.hzh.test

/**
 * 隐式值和隐式参数 作用域
 * 隐式值无关乎变量名，只关注具体类型， 隐式参数同样
 * 不能出现多个类型相同的隐式值
 */

object Test_Implicit {
  //隐式值 注意隐式参数和隐式值的类型一致
//  implicit val name = "zs"
  implicit val age:Int = 18
  implicit val age2:Int = 22
  //隐式参数
  def test1(implicit str:String): Unit ={
    println(str)
  }
  def test2(implicit str:String): Unit ={
    println(str)
  }

  //如果函数中有隐式参数，也有普通参数，要以柯里化的方式书写，将隐式参数放在最后
  def test3(name:String)(implicit age:Int) = {
    println(name + ":" + age)
  }

  def test4(implicit name:String,age:Int)={
    println(name + ":" + age)
  }

  def main(args: Array[String]): Unit = {
    test1(str = "nihao")//nihao
//    test1   //zs。scala会自动在作用域范围内寻找隐式值作为当前的函数参数执行
    test3("zs")(22)
//    test4
//    test3("lisi")
  }

}
