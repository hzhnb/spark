package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * java要区分RDD的种类，对应不同的算子 map mapToPair
 */
public class WordCountJava {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("javawc");
        JavaSparkContext jsc = new JavaSparkContext(conf);
//        jsc.sc().setCheckpointDir();

        JavaRDD<String> lineRDD = jsc.textFile("F:\\idea代码\\scala\\src\\main\\java\\spark\\wc.txt");
//       函数式接口，有且仅有一个抽象方法，可有多个非抽象方法

        JavaRDD<String> word = lineRDD.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String line) throws Exception {
                String[] split = line.split(" ");
                List<String> list = Arrays.asList(split);
                return list.iterator();
            }
        });
//        lineRDD.flatMap(x->Arrays.asList(x.split(" ")).iterator());
//        word -> (word,1) mapToPair java中特有的方法
        JavaPairRDD<String, Integer> pairRDD = word.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s, 1);
            }
        });
//        reduceByKey会进行map端的欲聚合
        pairRDD
                .reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1 + v2;
            }
        })
                .mapToPair(new PairFunction<Tuple2<String, Integer>, Integer, String>() {
                    @Override
                    public Tuple2<Integer, String> call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                        return stringIntegerTuple2.swap();
                    }
                })
//                java中没有sortBy
                .sortByKey(false)
                .foreach(x-> System.out.println(x));
//        行动算子 count,foreach,first,collect,take
        System.out.println(lineRDD.count());
        System.out.println(lineRDD.take(3));
        System.out.println(lineRDD.first());
        System.out.println(lineRDD.collect());
        jsc.stop();
    }
}
