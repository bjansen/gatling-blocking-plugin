ThisBuild / organization := "com.github.bjansen"
ThisBuild / version := "0.1.0"
ThisBuild / versionScheme := Some("semver-spec")

ThisBuild / scalaVersion := "2.13.18"

lazy val root = (project in file("."))
  .enablePlugins(GatlingPlugin)
  .settings(
    name := "gatling-blocking-plugin",

    Gatling / publishArtifact   := false,
    GatlingIt / publishArtifact := false,

    libraryDependencies ++= Seq(
      "io.gatling" % "gatling-core" % "3.15.0",
      "io.gatling" % "gatling-core-java" % "3.15.0",
    )
  )

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.15.0" % "test"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "3.15.0" % "test"
