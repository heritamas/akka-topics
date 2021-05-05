val AkkaVersion = "2.6.13"
val LogbackVersion = "1.2.3"
val ScalaVersion = "2.13.1"
val AkkaManagementVersion = "1.0.9"
val AkkaProjectionVersion = "1.1.0"
val ScalikeJdbcVersion = "3.5.0"

lazy val `up-and-running` = project
  .in(file("up-and-running"))
  .settings(
    scalaVersion := ScalaVersion,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
      "org.scalatest" %% "scalatest" % "3.1.4" % Test,
      )
    )
lazy val `unit-testing` = project
  .in(file("unit-testing"))
  .settings(
    scalaVersion := ScalaVersion,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
      "org.scalatest" %% "scalatest" % "3.1.4" % Test,
    ))

lazy val supervision = project
  .in(file("supervision"))
  .settings(
    scalaVersion := ScalaVersion,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
      "org.scalatest" %% "scalatest" % "3.1.4" % Test,
    ))

lazy val `discovery-routers` = project
  .in(file("discovery-routers"))
  .settings(
    scalaVersion := ScalaVersion,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
      "org.scalatest" %% "scalatest" % "3.1.4" % Test,
    ))

lazy val clustering = project
  .in(file("clustering"))
  .settings(
    scalaVersion := ScalaVersion,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
      "com.typesafe.akka" %% "akka-cluster-typed" % AkkaVersion,         
      "com.typesafe.akka" %% "akka-serialization-jackson" % AkkaVersion,
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
      "com.lightbend.akka.management" %% "akka-management" % AkkaManagementVersion,
      "com.lightbend.akka.management" %% "akka-management-cluster-http" % AkkaManagementVersion,
      "com.typesafe.akka" %% "akka-discovery" % AkkaVersion,
      "org.scalatest" %% "scalatest" % "3.1.4" % Test,
    ),
  )

lazy val sharding = project
  .in(file("sharding"))
  .settings(
    scalaVersion := ScalaVersion,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
      "com.typesafe.akka" %% "akka-cluster-typed" % AkkaVersion,         
      "com.typesafe.akka" %% "akka-cluster-sharding-typed" % AkkaVersion,         
      "com.typesafe.akka" %% "akka-serialization-jackson" % AkkaVersion,
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
      "com.lightbend.akka.management" %% "akka-management" % AkkaManagementVersion,
      "com.lightbend.akka.management" %% "akka-management-cluster-http" % AkkaManagementVersion,
      "com.typesafe.akka" %% "akka-cluster-sharding" % AkkaVersion,
      "com.typesafe.akka" %% "akka-discovery" % AkkaVersion,
      "org.scalatest" %% "scalatest" % "3.1.4" % Test,
    )
  )

lazy val persistence = project
  .in(file("persistence"))
  .settings(
    scalaVersion := ScalaVersion,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
      "com.typesafe.akka" %% "akka-cluster-typed" % AkkaVersion,         
      "com.typesafe.akka" %% "akka-cluster-sharding-typed" % AkkaVersion,         
      "com.typesafe.akka" %% "akka-serialization-jackson" % AkkaVersion,
      "com.typesafe.akka" %% "akka-persistence-typed" % AkkaVersion,
      "com.typesafe.akka" %% "akka-persistence-testkit" % AkkaVersion % Test,
      "com.lightbend.akka" %% "akka-persistence-jdbc" % "5.0.0",
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
      "com.lightbend.akka.management" %% "akka-management" % AkkaManagementVersion,
      "com.lightbend.akka.management" %% "akka-management-cluster-http" % AkkaManagementVersion,
      "com.typesafe.akka" %% "akka-cluster-sharding" % AkkaVersion,
      "com.typesafe.akka" %% "akka-discovery" % AkkaVersion,
      "org.scalatest" %% "scalatest" % "3.1.4" % Test,
      "org.postgresql" % "postgresql" % "42.2.18",
    )
  )

lazy val projections = project
  .in(file("projections"))
  .settings(
    scalaVersion := ScalaVersion,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion  ,
      "com.typesafe.akka" %% "akka-cluster-typed" % AkkaVersion,         
      "com.typesafe.akka" %% "akka-cluster-sharding-typed" % AkkaVersion,         
      "com.typesafe.akka" %% "akka-serialization-jackson" % AkkaVersion,
      "com.typesafe.akka" %% "akka-persistence-typed" % AkkaVersion,
      "com.typesafe.akka" %% "akka-persistence-testkit" % AkkaVersion % Test,
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "com.lightbend.akka.management" %% "akka-management" % AkkaManagementVersion,
      "com.lightbend.akka.management" %% "akka-management-cluster-http" % AkkaManagementVersion,
      "com.typesafe.akka" %% "akka-cluster-sharding" % AkkaVersion,
      "com.lightbend.akka" %% "akka-projection-core" % AkkaProjectionVersion,
      "com.lightbend.akka" %% "akka-projection-eventsourced" % AkkaProjectionVersion,
      "com.lightbend.akka" %% "akka-projection-jdbc" % AkkaProjectionVersion,
      "com.lightbend.akka" %% "akka-projection-testkit" % AkkaProjectionVersion,
      "com.typesafe.akka" %% "akka-persistence-query" % AkkaVersion,
      "com.lightbend.akka" %% "akka-persistence-jdbc" % "5.0.0",
      "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
      "com.typesafe.akka" %% "akka-stream-testkit" % AkkaVersion ,
      "com.typesafe.akka" %% "akka-discovery" % AkkaVersion,
      "org.scalatest" %% "scalatest" % "3.1.4" % Test,
      "org.scalikejdbc" %% "scalikejdbc"       % ScalikeJdbcVersion,
        "org.scalikejdbc" %% "scalikejdbc-config" % ScalikeJdbcVersion,

      "org.postgresql" % "postgresql" % "42.2.18",
    )
  )

lazy val `akka-streams-one` = project
    .in(file("akka-streams-one")) 
    .settings(
      scalaVersion := ScalaVersion,
      libraryDependencies ++= Seq(
        "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
        "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion  ,
        "com.typesafe.akka" %% "akka-cluster-typed" % AkkaVersion, //otherwise java.lang.ClassNotFoundException: akka.cluster.ClusterActorRefProvider 
        "org.scalatest" %% "scalatest" % "3.1.4" % Test,
      ))

ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger