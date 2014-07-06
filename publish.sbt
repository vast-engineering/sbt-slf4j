import xerial.sbt.Sonatype.SonatypeKeys._

lazy val SonatypePublish = config("sonatype")

inConfig(SonatypePublish)(
  Defaults.baseClasspaths ++
    sonatypeSettings ++
    Seq(
      credentials := Seq(Credentials(Path.userHome / ".ivy2" / ".sonatype-credentials")),
      profileName := "com.vast",
      pomExtra := {
        <developers>
          <developer>
            <id>dpratt@vast.com</id>
            <name>David Pratt</name>
            <url>https://github.com/vast-engineering</url>
          </developer>
        </developers>
      }
    )
)