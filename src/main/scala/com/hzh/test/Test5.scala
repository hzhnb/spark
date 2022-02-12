package com.hzh.test

object Test5 {
  def main(args: Array[String]): Unit = {
    /**
     * 字符串：String & StringBuider
     */
    var str = "abcd"
    var str2 = "ABCD"
    println(str.indexOf("b"))
    println(str.indexOf(97))
    println(str==str2)

    /**
     * compareToIngoreCase
     */
    println(str.compareToIgnoreCase(str2))//按字典顺序比较两个字符串大小，不考虑大小写
    
    val builder = new StringBuilder

    builder.append("abc")
    builder.+('d')
    builder + 'd'
    builder.++=("efg")
  }

}
