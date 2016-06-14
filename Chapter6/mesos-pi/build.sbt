import AssemblyKeys._

assemblySettings

name := "mesos-pi"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies += "org.apache.mesos" % "mesos" % "0.26.0"

libraryDependencies += "log4j" % "log4j" % "1.2.17"
