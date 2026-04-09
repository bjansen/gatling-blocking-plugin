ThisBuild / organization := "com.github.bjansen"
ThisBuild / organizationName := "bjansen"
ThisBuild / organizationHomepage := Some(url("https://github.com/bjansen"))

pgpSigningKey := Some("bastien.jansen@gmx.com")

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/bjansen/gatling-blocking-plugin"),
    "scm:git@github.com:bjansen/gatling-blocking-plugin.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id = "bjansen",
    name = "Bastien Jansen",
    email = "bastien.jansen@gmx.com",
    url = url("https://github.com/bjansen")
  )
)

ThisBuild / description := "Gatling protocol to run blocking code in virtual threads "
ThisBuild / licenses := List(
  "GNU General Public License v3.0" -> new URI("https://github.com/bjansen/gatling-blocking-plugin/blob/main/LICENSE").toURL
)
ThisBuild / homepage := Some(url("https://github.com/bjansen/gatling-blocking-plugin"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishMavenStyle := true

// new setting for the Central Portal
ThisBuild / publishTo := {
  val centralSnapshots = "https://central.sonatype.com/repository/maven-snapshots/"
  if (isSnapshot.value) Some("central-snapshots" at centralSnapshots)
  else localStaging.value
}
