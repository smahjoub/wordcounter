name := "wordcounter"

version := "0.1"

scalaVersion := "2.11.11"

val sparkVersion = "2.4.1"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion
)