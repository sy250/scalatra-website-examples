organization := "com.example"
name := "Flowershop"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.13.0"

val ScalatraVersion = "2.7.+"

libraryDependencies ++= Seq(
  "org.json4s"              %% "json4s-native"     % "3.6.7",
  "org.scalatra"            %% "scalatra-swagger"  % ScalatraVersion,
  "org.scalatra"            %% "scalatra"          % ScalatraVersion,
  "org.scalatra"            %% "scalatra-scalate"  % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2"   % ScalatraVersion    % Test,
  "ch.qos.logback"          %  "logback-classic"   % "1.2.3"            % Provided,
  "org.eclipse.jetty"       %  "jetty-webapp"      % "9.4.19.v20190610" % Provided,
  "javax.servlet"           %  "javax.servlet-api" % "3.1.0"            % Provided
)

enablePlugins(ScalatraPlugin)
