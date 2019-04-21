package com.smahjoub.wordcounter

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object App {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("Word counter app")
    val sc = new SparkContext(sparkConf)

    val textFile = sc.textFile("file:///E:/Documents/spark-examples/spark-input.txt")

    val tokenizedTextFile = textFile.flatMap(line => line.split(" "))
    val countPrep = tokenizedTextFile.map(word => (word, 1))

    val counts = countPrep.reduceByKey((accValue, newValue) =>  accValue + newValue)
    val sortedCounts = counts.sortBy(kvPair => kvPair._2, false)
    sortedCounts.saveAsTextFile("file:///E:/Documents/spark-examples//spark-output")
  }
}
