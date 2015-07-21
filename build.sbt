import sbt.Keys._

scalaVersion := "2.11.7"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Xlint", "-Xfatal-warnings")

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4", "org.scalacheck" %% "scalacheck" % "1.12.4")

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD")

version := "0.1.0"

organization := "com.github.nokamoto"

name := "scalatest-util"

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/nokamoto/scalatest-util</url>
  <licenses>
    <license>
      <name>MIT License</name>
      <url>http://www.opensource.org/licenses/mit-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:nokamoto/scalatest-util.git</url>
    <connection>scm:git:git@github.com:nokamoto/scalatest-util.git</connection>
  </scm>
  <developers>
    <developer>
      <id>nokamoto</id>
      <name>Naofumi Okamoto</name>
      <url>https://github.com/nokamoto</url>
    </developer>
  </developers>)
