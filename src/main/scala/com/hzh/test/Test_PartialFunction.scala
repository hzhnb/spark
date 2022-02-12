package com.hzh.test

/**
 * 通过list中map和collect来体现偏函数区别
 * isDefinedAt 定义接受参数的范围
 * apply 具体应用
 * 偏函数只处理自己感兴趣的数据
 */
object Test_PartialFunction {



  def main(args: Array[String]): Unit = {
    //    println(MyTest1("hello"))
//    def MyTest1:PartialFunction[String,String] = {
//      case "hello" => "hello"
//      case "hello1" => "hello1"
//      case _=> "no match"
//    }
    val list = List(1,3,5,"seven")
//    list.map(MyTest).foreach(println)
    list.collect(MyTest).foreach(println)
    def MyTest:PartialFunction[Any,Int] = {
      case i:Int => i + 1
    }
  }

}
