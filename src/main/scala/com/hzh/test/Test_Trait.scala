package com.hzh.test

/**
 * trait 具体和抽象函数
 * 多继承情况下，存在相同名称的属性；需要在具体类中重写
 */
trait Play{
  val name = "zs"
  val age = 22
  def play()
}
trait Study{
  val name = "lisi"
  val money = 200
  def learn()={
    println("I'm learning")
  }
}

class Person extends Play with Study{
  override val name: String = "joy"
  override def play(): Unit = {
    println("happy")
  }
}

object Test_Trait {
  def main(args: Array[String]): Unit = {
    val person = new Person()
    person.play()
    person.learn()
  }

}
