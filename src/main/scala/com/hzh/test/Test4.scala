package com.hzh.test

import java.util.Date

/**
 * 函数
 */
object Test4 {
  def main(args: Array[String]): Unit = {
    //    val result = getMax(1,10)
    //    println(result)
    //    /**
    //     * 递归函数：递归的定义以及终止条件,不能省略函数的返回类型
    //     * 5的阶乘
    //     * @param num
    //     */
    //    def fun2(num:Int):Int = {
    //      if(num == 1){
    //        num
    //      }else{
    //        num * fun2(num - 1)
    //      }
    //    }
    //    println(fun2(num = 5))
    //
    //    /**
    //     * 包含参数默认值的函数
    //     * 有默认值可以不传递参数，但是需要注意默认值参数的位置，可以指定参数进行赋值
    //     */
    //    def fun3(a:Int = 5,b:Int)={
    //      a+b
    //    }
    //    println(fun3(b=4))
    /**
     * 可变参数个数的函数，可变参数就是不定长数组
     */
    //    def fun4(a:Int*): Int ={
    //      var sum = 0;
    //      for (i <- a){
    //        sum += i;
    //      }
    //      sum
    //    }
    //    println(fun4(1,2,3,4,5,6,7))
    /**
     * 匿名函数 ()=>{} 后期会和高阶函数结合在一起使用
     * (形参列表) => {函数体}
     * 1，有参数的匿名函数
     * 2，无参数的匿名函数
     * 3，有返回值的匿名函数
     */
    //     val function = (a:Int,b:Int) => {
    //        a + b
    //    }
    //    println(function(1,2))
    //    def sum(a:Int,b:Int)={
    //      a + b
    //    }
    //    println(sum(1,2))
    //    val f4: () => Unit = () => {
    //      println("这是一个无参匿名函数")
    //    }
    //    f4()
    //    def test(a:Int) = {
    //      println(222)
    //    }
    //    test(1)
    /**
     * 嵌套函数
     * 注意嵌套函数何时调用
     */
    //    def f6(a:Int,b:Int)={
    //      def f7(c:Int)={
    //        a * b * c
    //      }
    //      println(f7(10))
    //    }
    //    f6(3,4)
    /**
     * 偏应用函数，有具体应用场景(要求看懂)
     * @param date
     * @param s
     */
//    def log(date: Date, s: String) = {
//      println("date is" + date + ".log is" + s)
//    }
//
//    val date = new Date()
//    log(date, " log1")
//    log(date, " log2")
//    log(date, "log3 ")
//    //想要调用log，以上变化的是第二个参数,可以用偏应用函数处理，下划线可以用来替换缺失的参数列表
//    val logWithDate = log(date, _: String)
//    logWithDate("log11")
//    logWithDate("log22")
//    logWithDate("log33")
    /**
     * f函数表示接受两个int类型的参数，并且返回一个int类型的函数
     * 高阶函数一般和匿名函数结合使用
     * 函数的参数和返回值类型都可以是函数
     * @param a
     * @param f
     */
//    def f7(a:Int,f:(Int,Int)=>(Int)) ={
//      val result = f(1,2)
//      a * result
//    }
//    def f8(a:Int,b:Int):Int=a+b
//
//    println(f7(1,f8))
//    println(f7(1,(a:Int,b:Int) => a+b))
//    //函数的返回值是函数
//    def f9(a:Int,b:Int):(String,String)=>String = {
//        def f10(c:String,d:String) = {
//          a + b + c + d
//        }
//      //此处不要调用
//      f10
//    }
//    val function:(String,String) => String =  f9(1,2)
//    val str:String = function("1","2")
//    println(str)
//    println(f9(1,2)("1","2"))
//
//    def f11(f:(Int,Int)=>Int):(Int,Int)=>Int = {
//      f
//    }
//    println(f11((a:Int,b:Int)=>a+b)(10,20))
//    //使用下划线作为通配符需要注意，此变量只被使用一次
//    println(f11((_+_))(10,20))
    /**
     * 柯里化函数
     *
     */
//      def fun12(a:Int,b:Int)(c:Int,d:Int) = {
//        a+b+c+d
//      }
//      def fun13(a:Int,b:Int,c:Int,d:Int)={
//        a+b+c+d
//      }
//      println(fun12(1,2),(3,4))
  }
//  /**
//   * scala会自动将函数的最后一行的值作为返回值返回
//   * return可以省略
//   * 如果不写return,函数的返回类型可以省略，会进行类型的自动推断
//   * =可以省略表示将函数的返回值丢弃，但是丢弃不等于不调用函数
//   * @param a
//   * @param b
//   * @return
//   */
//  def getMax(a:Int,b:Int) = {
//    if(a>b){
//      a
//    }else{
//      b
//    }
//  }


}
