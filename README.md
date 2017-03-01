 Lagom Scala Word Count

This is a Scala Sbt project that demonstrates the legacy word count example using the Lagom Framework.
This is a microservices based Kafka Producer/Consumer application where one is the producer which produces data in Kafka and persist events in Cassandra Db. The other service consumes data from Kafka and gives the word count of the words.
Here, we are using embedded Kafka and Cassandra. You can use external ones as well. For that you just need to uncomment the last 4 lines of the build.sbt and install Kafka and Cassandra on your machine.You need to start Zookeeper server, Kafka server and Cassandra before starting the application as well.

Setting up the development environment:

https://github.com/piyushknoldus/lagom-scala-wordcount/wiki/Setting-up-the-development-environment

Json Formats for different Rest services:

https://github.com/piyushknoldus/lagom-scala-wordcount/wiki/Json-Formats-for-different-Rest-services

Tools Integrated:

https://github.com/piyushknoldus/lagom-scala-wordcount/wiki/Tools-Integrated

Screen Shots:

https://github.com/piyushknoldus/lagom-scala-wordcount/wiki/Working-ScreenShots


For any issue please raise a ticket @ Github Issue
 https://github.com/piyushknoldus/lagom-scala-wordcount/issues