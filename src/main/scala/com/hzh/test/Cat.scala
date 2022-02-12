package com.hzh.test

object Cat extends AAA with BBB{
  override def eat(): Unit = {

  }

  override def eat222(): Unit = {

  }
}

trait AAA{
  def eat():Unit = {
    println("AAA eat")
  }
}

trait BBB {
  def eat222():Unit = {
    println("BBB eat")
  }
}