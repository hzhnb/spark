package demo;

import org.apache.ivy.osgi.p2.P2Artifact;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

public class PVUV {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("transformation");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        JavaRDD<String> lineRDD = jsc.textFile("F:\\idea代码\\scala\\src\\main\\resources\\data\\puuvdata");
//      "\t" 从当前一行数据中读取出相应的url数据
        /**
         * (www.suning.com,8)
         * (www.gome.com.cn,4)
         * (www.jd.com,4)
         * (www.dangdang.com,5)
         * (www.taobao.com,3)
         * (www.mi.com,2)
         * (www.baidu.com,7)
         */
        lineRDD.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String line) throws Exception {
                return new Tuple2<>((line.split("\t")[5]),1);
            }
        }).reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1 + v2;
            }
        }).foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                System.out.println(stringIntegerTuple2);
            }
        });

        jsc.stop();
    }
}
