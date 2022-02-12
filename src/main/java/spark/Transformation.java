package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Transformation {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("transformation");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        JavaRDD<Integer> rdd = jsc.parallelize(Arrays.asList(1, 2, 3, 4), 3);
        /**
         * repartition
         * 无论增加还是减少分区都会产生shuffle.
         * coalesce
         * 减少分区专用(shuffle)，想要增加分区true
         */
        /**
         * mapPartitionsWithIndex
         * 戴上追踪索引号
         */
        /**
         * partition id is 0,value is 1
         *
         * partition id is 1,value is 2
         *
         * partition id is 2,value is 3
         * partition id is 2,value is 4
         */
//        rdd.mapPartitionsWithIndex(new Function2<Integer, Iterator<Integer>, Iterator<Integer>>() {
//            @Override
//            public Iterator<Integer> call(Integer index, Iterator<Integer> iterator) throws Exception {
//                List list = new ArrayList();
//                while (iterator.hasNext()){
//                    Integer i = iterator.next();
//                    list.add(i + 1);
//                    System.out.println("partition id is " + index + ",value is " + i);
//                }
//                return list.iterator();
//            }
//        },true).collect();

//        JavaRDD<Integer> rdd2 = rdd.coalesce(2);//不shuffle
//        JavaRDD<Integer> rdd2 = rdd.repartition(2,true);//shuffle
//        JavaRDD<Integer> rdd2 = rdd.repartition(2);//3
        /**
         * partition id is 0,value is 1
         * partition id is 0,value is 3
         *
         * partition id is 1,value is 2
         * partition id is 1,value is 4
         */
//        JavaRDD<Integer> rdd2 = rdd.repartition(2);
//        rdd2.mapPartitionsWithIndex(new Function2<Integer, Iterator<Integer>, Iterator<Integer>>() {
//            @Override
//            public Iterator<Integer> call(Integer index, Iterator<Integer> iterator) throws Exception {
//                List list = new ArrayList();
//                while (iterator.hasNext()){
//                    Integer i = iterator.next();
//                    list.add(i + 1);
//                    System.out.println("partition id is " + index + ",value is " + i);
//                }
//                return list.iterator();
//            }
//        },true).collect();
        /**
         * partition id is 0,value is 3
         *
         * partition id is 1,value is 2
         * partition id is 1,value is 4
         *
         * partition id is 3,value is 1
         */
//        JavaRDD<Integer> rdd3 = rdd.repartition(4);
//        rdd3.mapPartitionsWithIndex(new Function2<Integer, Iterator<Integer>, Iterator<Integer>>() {
//            @Override
//            public Iterator<Integer> call(Integer index, Iterator<Integer> iterator) throws Exception {
//                List list = new ArrayList();
//                while (iterator.hasNext()){
//                    Integer i = iterator.next();
//                    list.add(i + 1);
//                    System.out.println("partition id is " + index + ",value is " + i);
//                }
//                return list.iterator();
//            }
//        },true).collect();

        /**
         * groupByKey
         */
//        JavaPairRDD<String,Integer> pairRDD = jsc.parallelizePairs(Arrays.asList(
//                new Tuple2("a",10),
//                new Tuple2("a",11),
//                new Tuple2("b",12),
//                new Tuple2("c",13),
//                new Tuple2("d",14),
//                new Tuple2("e",15)
//
//        ));
//        JavaPairRDD<String, Iterable<Integer>> pairRDD1 = pairRDD.groupByKey();
        /**
         * groupByKey
         * 源码中对于聚合操作的介绍
         * reduceByKey：相比groupByKey存在map端欲聚合操作，效率更高。
         *
         */
        /**
         * 当前tuple数据位(d,[14])
         * 14!!!!
         * 当前tuple数据位(e,[15])
         * 15!!!!
         * 当前tuple数据位(a,[10, 11])
         * 10!!!!
         * 11!!!!
         * 当前tuple数据位(b,[12])
         * 12!!!!
         * 当前tuple数据位(c,[13])
         * 13!!!!
         */
//        pairRDD1.foreach(new VoidFunction<Tuple2<String, Iterable<Integer>>>() {
//            @Override
//            public void call(Tuple2<String, Iterable<Integer>> stringIterableTuple2) throws Exception {
//                System.out.println("当前tuple数据位" + stringIterableTuple2);
//                Iterable<Integer> integers = stringIterableTuple2._2;
//                Iterator<Integer> iterator = integers.iterator();
//                while (iterator.hasNext()){
//                    System.out.println(iterator.next() + "!!!!");
//                }
//            }
//        });
        /**
         * zip
         * 拉链
         * 两个RDD,个数相同
         * rdd对应类型没有影响
         */
//        JavaRDD<String> name = jsc.parallelize(Arrays.asList("zs", "lisi", "ww"));
//        JavaRDD<Integer> money = jsc.parallelize(Arrays.asList(100,200,300));
//        JavaPairRDD<String, Integer> zip = name.zip(money);
        /**
         * (zs,100)
         * (lisi,200)
         * (ww,300)
         */
//        zip.foreach(new VoidFunction<Tuple2<String, Integer>>() {
//            @Override
//            public void call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
//                System.out.println(stringIntegerTuple2);
//            }
//        });
//        JavaPairRDD<String,Integer> pairRDD = jsc.parallelizePairs(Arrays.asList(
//                new Tuple2("a",10),
//                new Tuple2("a",11),
//                new Tuple2("b",12),
//                new Tuple2("d",13)
//
//        ));

//        JavaRDD<String> name = jsc.parallelize(Arrays.asList("zs", "lisi", "ww"));
//        JavaRDD<Integer> money = jsc.parallelize(Arrays.asList(100,200,300,400));
//        JavaPairRDD<String, Integer> zip = name.zip(money);
        /**
         * Caused by: org.apache.spark.SparkException: Can only zip RDDs with same number of elements in each partition
         */
//        zip.foreach(new VoidFunction<Tuple2<String, Integer>>() {
//            @Override
//            public void call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
//                System.out.println(stringIntegerTuple2);
//            }
//        });
        /**
         * ((a,10),100)
         * ((a,11),200)
         * ((b,12),300)
         * ((d,13),400)
         */
//        pairRDD.zip(money).foreach(x -> System.out.println(x));
        /**
         * (100,0)
         * (200,1)
         * (300,2)
         * (400,3)
         */
        /**
         * zipWithIndex
         * 顺序，序列index
         */
        JavaRDD<Integer> money = jsc.parallelize(Arrays.asList(100,200,300,400));
        money.zipWithIndex().foreach(x -> System.out.println(x));

        jsc.stop();
    }
}
