package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Map;

public class Actions {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("action");
        JavaSparkContext jsc = new JavaSparkContext(conf);
//        JavaPairRDD<String,Integer> pairRDD = jsc.parallelizePairs(Arrays.asList(
//                new Tuple2("a",10),
//                new Tuple2("a",11),
//                new Tuple2("b",12),
//                new Tuple2("b",12),
//                new Tuple2("b",13),
//                new Tuple2("e",15)
//
//        ));
        /**
         * reduce
         * 行动算子
         * 对rdd执行给定reduce操作
         */
        JavaRDD<Integer> rdd = jsc.parallelize(Arrays.asList(1, 2, 3, 4, 5));
        /**
         * 当前v1为 1当前v2为 2
         * 当前v1为 3当前v2为 3
         * 当前v1为 6当前v2为 4
         * 当前v1为 10当前v2为 5
         */
        rdd.reduce(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer v1, Integer v2) throws Exception {
                System.out.println("当前v1为 " + v1 + "当前v2为 "+v2);
                return v1 + v2;
            }
        });

        /**
         * countByKey
         * 作用在KV格式rdd上，根据key相同进行元素计数，返回一个map
         * 注意源码，集合数据返回driver端需要注意大小，如果太大，可以考虑继续以rdd的形式进行处理
         * mapValues(_=>1L).reduceByKey(_+_)
         * countByValue
         * 当前的value描述的是完整的pair
         */
//        System.out.println(pairRDD.count());//6
        /**
         * 当前key为：e当前value为：1
         * 当前key为：a当前value为：2
         * 当前key为：b当前value为：3
         */
//        Map<String, Long> map = pairRDD.countByKey();
//        for (Map.Entry<String,Long> entry:map.entrySet()){
//            System.out.println("当前key为：" + entry.getKey() + "当前value为：" + entry.getValue());
//
//        }
        /**
         * 当前key为：(b,12)当前value为：2
         * 当前key为：(a,11)当前value为：1
         * 当前key为：(b,13)当前value为：1
         * 当前key为：(a,10)当前value为：1
         * 当前key为：(e,15)当前value为：1
         */
//        Map<Tuple2<String, Integer>, Long> map1 = pairRDD.countByValue();
//        for (Map.Entry<Tuple2<String, Integer>,Long> entry:map1.entrySet()){
//            System.out.println("当前key为：" + entry.getKey() + "当前value为：" + entry.getValue());
//
//        }


        jsc.stop();

    }
}
