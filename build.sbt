organization := "com.vast.sbt"

name := "sbt-slf4j"

description := "An SLF4j backend that utilizes the SBT TaskStreams log."

scalaVersion := "2.10.4"

crossPaths := false

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.7",
  "org.scala-sbt" % "logging" % "0.13.5" % "provided"
)

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

homepage := Some(url("https://github.com/vast-engineering"))

startYear := Some(2014)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/vast-engineering/sbt-slf4j"),
    "scm:git:github.com/vast-engineering/athena",
    Some("scm:git:git@github.com:vast-engineering/athena")
  )
)
