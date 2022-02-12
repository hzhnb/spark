package com.hzh.utils

import org.apache.spark.{SparkConf, SparkContext}

object ContextUtils {
  def getSparkContext(appName:String,master:String = "local"): SparkContext ={
    new SparkContext(new SparkConf().setMaster(master).setAppName(appName))
  }

}
