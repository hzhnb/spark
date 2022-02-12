package demo;

import com.google.inject.internal.cglib.core.$ClassInfo;
import com.google.inject.internal.cglib.core.$MethodInfoTransformer;
import org.apache.commons.collections.IteratorUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.sources.In;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TopNTest {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("transformation");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        JavaRDD<String> lineRDD = jsc.textFile("F:\\idea代码\\scala\\src\\main\\resources\\data\\score.txt");

        JavaPairRDD<String, Integer> pairRDD = lineRDD.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String line) throws Exception {
//                  数据切割规则定义
                String[] split = line.split(" ");
//                根据业务指定组名和分数
                String groupName = split[0];
                Integer score = Integer.valueOf(split[1]);
                return new Tuple2<>(groupName, score);
            }
        });
        JavaPairRDD<String, Iterable<Integer>> groupByKey = pairRDD.groupByKey();
        /**
         * 第一种方式，利用集合全排序
         * 缺点：集合对象很大，注意内存开销
         * List全排序，排序算法压力大
         */
//        组内排序，取出成绩前3
        /**
         * 当前key为： d对应的值： 84
         * 当前key为： d对应的值： 41
         * 当前key为： d对应的值： 23
         * 当前key为： e对应的值： 98
         * 当前key为： e对应的值： 47
         * 当前key为： e对应的值： 46
         * 当前key为： a对应的值： 86
         * 当前key为： a对应的值： 84
         * 当前key为： a对应的值： 58
         * 当前key为： b对应的值： 98
         * 当前key为： b对应的值： 78
         * 当前key为： b对应的值： 51
         * 当前key为： f对应的值： 48
         * 当前key为： f对应的值： 32
         * 当前key为： f对应的值： 18
         * 当前key为： m对应的值： 48
         * 当前key为： c对应的值： 89
         * 当前key为： c对应的值： 73
         * 当前key为： c对应的值： 47
         */
        groupByKey.foreach(new VoidFunction<Tuple2<String, Iterable<Integer>>>() {
            @Override
            public void call(Tuple2<String, Iterable<Integer>> tuple2) throws Exception {
//                想办法将组内元素进行排序
                String key = tuple2._1;
                Iterator<Integer> iterator = tuple2._2.iterator();
                IteratorUtils.toList()
                List<Integer> list = new ArrayList<>();
                while (iterator.hasNext()){
                    list.add(iterator.next());
                }
                Collections.sort(list);
//                获得排好序的list之后，获得前3元素，因为数据原因，需要考虑是否数量满足，健壮性
                for (int i=0;i<Math.min(3,list.size());i++){
                    System.out.println("当前key为： "+ key + "对应的值： "+ list.get(list.size() - i - 1));
                }

            }
        });

        /**
         * 第二种方式，自己写一段算法
         *
         */
        /**
         * d:84
         * d:41
         * d:23
         * e:98
         * e:47
         * e:46
         * a:86
         * a:84
         * a:58
         * b:98
         * b:78
         * b:51
         * f:48
         * f:32
         * f:18
         * m:48
         * m:null
         * m:null
         * c:89
         * c:73
         * c:47
         */
        groupByKey.foreach(new VoidFunction<Tuple2<String, Iterable<Integer>>>() {
            @Override
            public void call(Tuple2<String, Iterable<Integer>> tuple2) throws Exception {
                String groupName = tuple2._1;
                Iterator<Integer> iterator = tuple2._2.iterator();
                Integer[] top3 = new Integer[3];
                while (iterator.hasNext()){
                    Integer score = iterator.next();
                    for (int i=0;i<top3.length;i++){
                        if (top3[i] == null){
                            top3[i] = score;
                            break;
                        }else if (score > top3[i]){
                            for (int j=2;j>i;j--){
                                top3[j] = top3[j-1];
                            }
                            top3[i] = score;
                            break;
                        }
                    }
                }
                for (Integer score:top3){
                    System.out.println(groupName + ":" + score);
                }
            }

        });


        jsc.stop();
    }
}
