import com.typesafe.sbt.SbtPgp
import xerial.sbt.Sonatype.SonatypeKeys._

lazy val SonatypePublish = config("sonatype")

inConfig(SonatypePublish)(
  Defaults.baseClasspaths ++
    Seq(
      credentials += Credentials(Path.userHome / ".ivy2" / ".sonatype-credentials"),
      pomExtra := {
        <developers>
          <developer>
            <id>dpratt@vast.com</id>
            <name>David Pratt</name>
            <url>https://github.com/vast-engineering</url>
          </developer>
        </developers>
      }
    ) ++
    SbtPgp.settings ++
    sonatypeSettings :+ (profileName := "com.vast")
)