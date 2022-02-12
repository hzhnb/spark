package demo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.sources.In;
import scala.Tuple2;

/**
 *  二次排序
 *  需要理解
 *  sortBy & sortByKey这样的算子，是如何实现排序的？
 *  By 的类可以被比较？按照String的写法操作
 *  如果常规的类不能满足你的需求，自动以类:spark操作需要实现序列化接口，有引文需要比较，需要实现comparable接口
 */
public class SecondSortTest {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("transformation");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        JavaRDD<String> lineRDD = jsc.textFile("F:\\idea代码\\scala\\src\\main\\resources\\data\\secondSort.txt");
//        1 3 ---> SecondSortKey,通过写好的自定义对象完成比较
//        首先通过对象完成比较，并且比较完成之后，将结果升序返回
        /**
         * 1 3
         * 1 3
         * 1 4
         * 1 6
         * 1 9
         * 1 9
         * 2 3
         * 2 3
         * 2 3
         * 2 5
         * 2 9
         * 3 1
         * 3 6
         * 3 8
         * 4 1
         * 4 2
         * 4 4
         * 4 4
         * 4 4
         * 4 5
         * 4 9
         * 5 6
         * 5 6
         * 6 4
         * 6 4
         * 6 7
         * 6 7
         * 7 2
         * 7 8
         * 8 1
         * 9 3
         */
        lineRDD.mapToPair(new PairFunction<String, SecondSortKey, String>() {
            @Override
            public Tuple2<SecondSortKey, String> call(String line) throws Exception {
                String[] split = line.split(" ");
                SecondSortKey secondSortKey = new SecondSortKey(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return new Tuple2<>(secondSortKey,line);
            }
        }).sortByKey().foreach(new VoidFunction<Tuple2<SecondSortKey, String>>() {
            @Override
            public void call(Tuple2<SecondSortKey, String> secondSortKeyStringTuple2) throws Exception {
                System.out.println(secondSortKeyStringTuple2._2);
            }
        });
    }
}
