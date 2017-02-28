import scoverage.ScoverageKeys.coverageFailOnMinimum

organization in ThisBuild := "com.knoldus"

version in ThisBuild := "1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.8"

val macwire = "com.softwaremill.macwire" %% "macros" % "2.2.5" % "provided"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1" % Test
val cassandraApi = "com.datastax.cassandra" % "cassandra-driver-extras" % "3.0.0"
val mockito = "org.mockito" % "mockito-all" % "1.10.19" % Test

lazy val `lagom-spike` = (project in file("."))
  .aggregate(`producer-api`, `producer-impl`, `consumer-api`,
    `consumer-impl`)


lazy val `producer-api` = (project in file("producer-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `producer-impl` = (project in file("producer-impl"))
  .enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceCassandra,
      lagomScaladslTestKit,
      lagomScaladslKafkaBroker,
      lagomScaladslKafkaClient,
      lagomScaladslBroker,
      cassandraApi,
      macwire,
      scalaTest
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`producer-api`)

lazy val `consumer-api` = (project in file("consumer-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `consumer-impl` = (project in file("consumer-impl"))
  .enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceCassandra,
      lagomScaladslTestKit,
      lagomScaladslKafkaBroker,
      lagomScaladslKafkaClient,
      lagomScaladslBroker,
      cassandraApi,
      macwire,
      scalaTest,
      mockito
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`consumer-api`, `producer-api`, `producer-impl`)


coverageExcludedPackages in `consumer-impl` :=
"""sample.helloworldconsumer.impl.HelloConsumerLoader""".stripMargin

coverageExcludedPackages in `producer-impl` :=
"""sample.helloworld.impl.HelloLoader""".stripMargin
// End => scoverage exludes files configuration according to projects


lagomCassandraEnabled in ThisBuild := false

lagomUnmanagedServices in ThisBuild := Map("cas_native" -> "http://localhost:9042")

lagomKafkaEnabled in ThisBuild := false

lagomKafkaAddress in ThisBuild := "localhost:9092"
