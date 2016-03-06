name := """filamnt-expiration-service"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0-RC1" % Test,
  "com.amazonaws" % "aws-java-sdk" % "1.10.57",
  "com.typesafe.play.modules" %% "play-modules-redis" % "2.4.0"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers += "google-sedis-fix" at "http://pk11-scratch.googlecode.com/svn/trunk"

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
