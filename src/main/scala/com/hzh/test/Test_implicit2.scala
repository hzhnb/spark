package com.hzh.test

/**
 *
 */

class Bird(name:String){
  def fly(): Unit ={
    println("起飞")
  }
}

class Pig(xname:String){
  val name = xname
}

object Test_implicit2 {
  /**
   * 隐式转换函数，让本不能飞的猪也能飞，前提，要能变成鸟
   */
  implicit def pigToBire(pig: Pig): Bird ={
    new Bird(pig.name)
  }

  def main(args: Array[String]): Unit = {
    val bird = new Bird("小鸟")
    bird.fly()

    val pig = new Pig("猪")
    pig.fly()
  }

}
