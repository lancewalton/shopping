lazy val buildSettings: Seq[Setting[_]] = Defaults.coreDefaultSettings ++ Seq[Setting[_]](
  organization := "hmrc",
  name := "shopping",
  scalaVersion := "2.12.4",
  scalaBinaryVersion := "2.12",
  scalacOptions := Seq(
    "-language:_",
    "-Xfatal-warnings",
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-unchecked",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Xfuture",
    "-Ywarn-unused-import",
    "-Ypartial-unification")
)

lazy val allDependencies = Seq(
  "org.scalatest"   %% "scalatest"     % "3.0.3"  % "test",
  "org.scalacheck"  %% "scalacheck"    % "1.14.0" % "test"
)

lazy val shopping = (project in file("."))
  .settings(
    buildSettings ++
    Seq(resolvers := Seq(Classpaths.typesafeReleases),
        libraryDependencies ++= allDependencies))
