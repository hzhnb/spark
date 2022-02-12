package com.hzh.test
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Set
import scala.collection.mutable.Map

object Test6 {
  def main(args: Array[String]): Unit = {
    /**
     * 数组
     */
//    val array = Array(1,2,3)
//    println(array(0))
//    for (i <- array){
//      println(i)
//    }
//    array.foreach(i=>println(i+2))
//    array.foreach(println(_))
//    array.foreach(println(_))
//
//    //二维数组
//    val array1 = new Array[Array[Int]](4)
//    array1(0) = Array(1,2)
//    array1(1) = Array(3,2)
//    array1(2) = Array(4,2)
//    array1(3) = Array(5,2)
//    array1.foreach(i=>{
//      i.foreach(println)
//      println("-----------")
//    })
//    val arr1 = Array("1","2","3")
//    val arr2 = Array("4","5","6")
//    val arr3 = Array.concat(arr1,arr2)
//    arr3.foreach(println)
//    Array.fill(5){
//      3
//    }.foreach(println)
//
//    val arrayBuffer = ArrayBuffer[String]("1","2","3")
//    arrayBuffer.append("c","d")
//    arrayBuffer.+=("z")
//    arrayBuffer.+=:("0")
//    arrayBuffer.foreach(println)

    /**
     * list
     */
//    val list:List[Int] = List(1,2,3)
//    list.foreach(println)
//    for (i<-list){
//      println(i)
//    }
//    //过滤不会改变原有的数据结构，
//    list.filter(x=>true).foreach(println)
//    list.filter(x=>{
//      x > 1 && x % 2 == 0
//    }).foreach(println)
//
//    /**
//     * count
//     * 统计符合条件数据的个数
//     */
//    println(list.count(_=>true))
//
//    /**
//     * map & flatMap
//     * map一进一出
//     * flatmap一进可能多出
//     */
//    val list1 = list.map(x => {
//      x * 2
//    })
//    list1.foreach(println)
//    val list2: List[String] = List("hello shanghai","hello beijing","hello guangzhou")
//    val list3: List[Array[String]] = list2.map(x => {
//      x.split(" ")
//    })
//    list3.foreach(println)
//    list3.foreach(x=>{
//      x.foreach(println)
//    })
//    val list4: List[String] = list2.flatMap(x => {
//      x.split(" ")
//    })
//    list4.foreach(println)
//
//    /**
//     *可变长度List
//     */
//    val listBuffer = ListBuffer[Int](1,2,3,4,5)
//    listBuffer.append(6,7,8,9,10)
//    listBuffer.+=:(0)
//    listBuffer.+=(11)
//    listBuffer.foreach(println)
    /**
     * Set
     */
//    val set: Set[Int] = Set(2,2,3)
//    set.foreach(println)
//    for (i <- set){
//      println(i)
//    }
//    /**
//     * 常见方法
//     * 交并差
//     */
//    val set2: Set[Int] = Set(2,4,5)
//    val set3 = set2.union(set)
//    set3.foreach(println)//1,2,3,4,5
//    val set4 = set3.diff(set2)//
//    set4.foreach(println)//1,3
//    val set5 = set.intersect(set2)
//    set5.foreach(println)//2
//
//    //可以通过符号替代
//    //可以通过符号替代 & = intersect
//    val set1 = set & set2
//    set1.foreach(println)
//
//    val set13 = set &~ set2
//    set3.foreach(println)
//
//    val set7:Set[Int] = Set(2)
//    val bool: Boolean = set7.subsetOf(set2)
//    println("-----------------")
//    //数据结构变化
////    set2.toList
//      val string: String = set1.mkString
//    println(string)
//    println(set1.mkString("~"))
//    //可变Set
//    val set10 = Set[Int](1,2,3,4,5,6)
//    set10.add(7)
//    set10.+=(10,100,200)
//    set10.foreach(println)
    /**
     * Map
     */
//    val map: Map[String, Any] = Map("name"->"zs","age"->18,("money",200))
//    map.foreach(x=>{
//      println(x._1+":"+x._2)
//    })
//    val option: Option[Any] = map.get("name")
//    println(option)
//    val option2: Option[Any] = map.get("name2")
//    //对None.get会出现NoSuchElementException
//    println(option2.getOrElse("nihao"))
//    val value:Any = map.getOrElse("age1",200)
//    println(value)

//    val set: Predef.Set[String] = map.keySet
//    set.foreach(x=>{
//      println(x+":"+map.get(x).get)
//    })
//    val values: Iterable[Any] = map.values
//    values.foreach(println)
    //Map的合并 ++覆盖
//    val map1: Map[String, Any] = Map("name" -> "zs","age" -> 18,("money",200))
//    val map2: Map[String, Any] = Map("name" -> "lisi","age1" -> 18,("money",10000))
//    val map3 = map1.++:(map2)
//    map3.foreach(x=>{
//      println(x._1+":"+x._2)
//    })

    //filter map对应比较的类型不一致时，编译不通过
//    val map1 = Map("age" -> 18,("money",200))
//    map1.filter(x=>{
//      if(x._2>20){
//        true
//      }else{
//        false
//      }
//    }).foreach(println)
//
//    //count
//    println(map1.count(x=>{
//      if(x._2>20){
//        true
//      }else{
//        false
//      }
//    }))
//
//    //contains
//    if(map1.contains("name")){
//      println(map1.get("name"))
//    }else{
//      println("no value")
//    }
//
//    //exists 只要找到了符合条件的元素就结束
//    val bool: Boolean = map1.exists(x => {
//      if (x._2 > 2) {
//        println(x)
//        true
//      } else {
//        false
//      }
//    })

//    val map: mutable.Map[String, Any] = Map(("name","zs"),("age",18))
//    map+=(("age",18))
    /**
     * Tuple
     * 元素的组合
     * 不是整体的类型，而是每一个元素的类型，最大到22
     */
    val tuple1: (Int, String) = Tuple2(1, "2")
    val tuple: (Int, Int) = Tuple2(1, 2)
//    val tuple2: (Int, Int) = (1,2)
    val tuple2 = "1" -> 2
    val tuple3: (Int, String, Float) = Tuple3(1,"2",6.0f)
    val tuple33: (Int, String, Float) = (1,"2",6.0f)
    val list: List[Any] = List(1,"2",6.0f)
    //通过迭代器的方式进行Tuple的遍历,一次性使用
    val iterator = tuple3.productIterator
    while (iterator.hasNext){
      println(iterator.next())
    }
    //二元组特殊swap方法
    println(tuple2.swap.toString())
}
}
