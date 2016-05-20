name := """bankapi"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs

)

libraryDependencies +=  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42"


lazy val myProject = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

fork in run := true