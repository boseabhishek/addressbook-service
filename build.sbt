name := "addressbook-service"

organization := "example"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.2"

crossScalaVersions := Seq("2.10.4", "2.11.2")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.5" % "test",
  "joda-time" % "joda-time" % "2.9.9",
  "org.joda" % "joda-convert" % "1.8.1"
)

initialCommands := "import example._"
