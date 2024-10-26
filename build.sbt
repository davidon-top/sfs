ThisBuild / scalaVersion := "3.5.2"
ThisBuild / versionScheme := Some("semver-spec")

ThisBuild / publishMavenStyle := true
ThisBuild / publishTo := Some(
  "GitHub Package Registry" at "https://maven.pkg.github.com/davidon-top/sfs"
)
ThisBuild / credentials += Credentials(
  "GitHub Package Registry",
  "maven.pkg.github.com",
  sys.env("THEHUB_USERNAME"),
  sys.env("THEHUB_TOKEN")
)

ThisBuild / licenses += ("MIT", url("https://opensource.org/license/MIT"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/davidon-top/sfs"),
    "scm:https://github.com/davidon-top/sfs.git"
  )
)

ThisBuild / organization := "top.davidon.sfs"
ThisBuild / organizationName := "DavidOnTop"
ThisBuild / organizationHomepage := Some(url("https://davidon.top"))

lazy val generate = taskKey[Unit]("pre compilation codegen task")

generate := DomGenerator.generate()

(Compile / compile) := ((Compile / compile) dependsOn generate).value

lazy val dom = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("./dom"))
  .settings(
    name := "sfs-dom",
    version := "0.1.0-alpha"
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
  .settings(
    name := "sfs",
    version := "0.1.0-alpha"
  )
  .dependsOn(dom)

lazy val sfsRouter = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("./router"))
  .settings(
    name := "sfs-router",
    version := "0.1.0-alpha"
  )

lazy val sfsReScala = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("./reactive/rescala"))
  .settings(
    name := "sfs-rescala",
    version := "0.1.0-alpha"
  )

lazy val sfsZio = project
  .in(file("./integrations/zio"))
  .settings(
    name := "sfs-zio",
    version := "0.1.0-alpha"
  )
