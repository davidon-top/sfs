ThisBuild / scalaVersion := "3.5.2"
ThisBuild / versionScheme := Some("semver-spec")

lazy val publishSettings = Seq(
  publishMavenStyle := true,
  publishTo := Some(
    "GitHub Package Registry" at "https://maven.pkg.github.com/davidon-top/sfs"
  ),
  credentials += Credentials(
    "GitHub Package Registry",
    "maven.pkg.github.com",
    sys.env("THEHUB_USERNAME"),
    sys.env("THEHUB_TOKEN")
  ),
  licenses += ("MIT", url("https://opensource.org/license/MIT")),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/davidon-top/sfs"),
      "scm:https://github.com/davidon-top/sfs.git"
    )
  ),
  organization := "top.davidon.sfs",
  organizationName := "DavidOnTop",
  organizationHomepage := Some(url("https://davidon.top"))
)

lazy val generate = taskKey[Unit]("pre compilation codegen task")

generate := DomGenerator.generate()

(Compile / compile) := ((Compile / compile) dependsOn generate).value

lazy val dom = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("./dom"))
  .settings(publishSettings)
  .settings(
    name := "sfs-dom",
    version := "0.1.0",
    libraryDependencies ++= Seq(
      "de.tu-darmstadt.stg" %% "rescala" % "0.35.1"
    )
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      "org.scala-js" % "scalajs-dom_sjs1_3" % "2.8.0"
    )
  )
  .jsSettings(
    libraryDependencies ++= Seq(
      "org.scala-js" % "scalajs-dom_sjs1_3" % "2.8.0"
    )
  )

lazy val sfs = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("./sfs"))
  .settings(publishSettings)
  .settings(
    name := "sfs",
    version := "0.1.0"
  )
  .dependsOn(dom)
