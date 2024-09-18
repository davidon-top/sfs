ThisBuild / version := "0.1.0"
ThisBuild / organization := "top.davidon"

ThisBuild / scalaVersion := "3.5.0"

lazy val precompile = taskKey[Unit]("pre compilation tasks")

precompile := DomGenerator.generate()

(Compile / compile) := ((Compile / compile) dependsOn precompile).value

lazy val root = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Full)
  .in(file("."))
  .settings(
    name := "sfs",
    libraryDependencies ++= Seq(
      "de.tu-darmstadt.stg" %%% "reactives" % "0.36.0",
      "org.scala-js" % "scalajs-dom" % "2.8.0" % "sjs1_3"
    )
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      "org.scala-js" % "scalajs-dom_sjs1_3" % "2.8.0"
    )
  )
