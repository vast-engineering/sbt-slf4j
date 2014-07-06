//import sbt.Keys._
//import sbt._
//import xerial.sbt.Sonatype._
//import xerial.sbt.Sonatype.SonatypeKeys._
//
//import scala.xml.NodeSeq
//
//object Publish {
//
//  lazy val sonatypePublishSettings = inConfig(Sonatype)(
//    sonatypeSettings ++
//      Seq(
//        credentials := Seq(Credentials(Path.userHome / ".ivy2" / ".sonatype-credentials")),
//        profileName := "com.vast"
////        ,
////        pomExtra := {
////          val xmlScm: NodeSeq = scmInfo.value.map { scm =>
////            <scm>
////              <connection>{scm.connection}</connection>
////              {scm.devConnection.map(dev => <developerConnection>{dev}</developerConnection>).getOrElse(NodeSeq.Empty)}
////              <url>{scm.browseUrl.toExternalForm}</url>
////            </scm>
////          } getOrElse NodeSeq.Empty
////
////          val xmlLicenses: NodeSeq = <licenses>
////            {licenses.value.map { case (licenseName, licenseUrl) =>
////              <license>
////                <name>{licenseName}</name>
////                <url>{licenseUrl.toExternalForm}</url>
////              </license>
////            }}
////          </licenses>
////
////          val urlXml = <url>{homepage.value.map(_.toExternalForm).get}</url>
////
////          val developerXml =
////            <developers>
////              <developer>
////                <id>dpratt@vast.com</id>
////                <name>David Pratt</name>
////                <url>https://github.com/vast-engineering</url>
////              </developer>
////            </developers>
////
////          urlXml ++ xmlScm ++ xmlLicenses ++ developerXml
////        }
//     )
//  )
//
//
//}