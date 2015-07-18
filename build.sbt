import sbt.Keys._

scalaVersion := "2.11.7"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Xlint", "-Xfatal-warnings")

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4", "org.scalacheck" %% "scalacheck" % "1.12.4")

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD")

