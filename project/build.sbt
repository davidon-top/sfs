lazy val root = (project in file("."))
  .settings(
    libraryDependencies ++= Seq(
      "com.raquo" %% "domtypes" % "18.1.0"
    )
  )
