organization := "org.scalatra.example"
name := "Scalatra Twirl"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.13.0"

val ScalatraVersion = "2.7.+"

libraryDependencies ++= Seq(
  "org.scalatra"            %% "scalatra"          % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2"   % ScalatraVersion    % Test,
  "javax.servlet"           %  "javax.servlet-api" % "3.1.0"            % Provided,
  "ch.qos.logback"          %  "logback-classic"   % "1.2.3"            % Provided,
  "org.eclipse.jetty"       %  "jetty-webapp"      % "9.4.19.v20190610" % Provided,
  "javax.servlet"           %  "javax.servlet-api" % "3.1.0"            % Provided
)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)
