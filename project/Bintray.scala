import sbt._
import sbt.Keys._

object Bintray {

  lazy val BintrayPublish = config("bintray-publish") extend Default

  lazy val bintraySettings = inConfig(BintrayPublish)(Seq(
    publishMavenStyle := false
  ))

}