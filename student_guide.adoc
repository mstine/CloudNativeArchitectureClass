= Cloud Native Application Architectures with Spring and Cloud Foundry

Student Guide

== Instructor Details

Matt Stine (@mstine) +
Principal Engineer / Senior Project Manager - Pivotal +
mstine@pivotal.io

Scott Frederick (@scottyfred) +
Senior Software Engineer - Pivotal +
sfrederick@pivotal.io

Vinicius Carvalho (@vccarvalho) +
Field Engineer - Pivotal +
vcarvalho@pivotal.io

== Schedule

This is _loose_ schedule for the two days. We will adjust as necessary based on our pace through the material.

The lectures for this class are intentionally very light and are only intended to set the stage for the hands-on labs.
The overwhelming majority of our time will be spent engaging with the technology directly!

NOTE: We will be updating the course materials throughout the class. You will need to have the materials cloned and track the `citi` branch.

This can be accomplished as follows:

----
$ git clone https://github.com/mstine/CloudNativeArchitectureClass
$ git fetch --all
$ git checkout citi
----

=== Day One

8:00 AM - 9:30 AM:: *Session 1:* _Cloud-Native Architecture Overview and Building Twelve-Factor Apps with Spring Boot_
9:30 AM - 10:00 AM:: Morning Break
10:00 AM - 11:30 AM:: *Session 2:* _Operating Twelve-Factor Apps with Cloud Foundry_
11:30 PM - 12:30 PM:: Lunch
12:30 PM - 3:00 PM:: *Session 3:* _Microservices with Polyglot Persistence: Part One_
3:00 PM - 3:30 PM:: Afternoon Break
3:30 PM - 5:00 PM:: *Session 4:* _Microservices with Polyglot Persistence: Part Two_

=== Day Two

8:00 AM - 9:30 AM:: *Session 5:* _Cloud-Native Architecture Patterns: Part One_
9:30 AM - 10:00 AM:: Morning Break
10:00 AM - 11:30 PM:: *Session 6:* _Cloud-Native Architecture Patterns: Part Two_
11:30 PM - 12:30 PM:: Lunch
12:30 PM - 3:00 PM:: *Session 7:* _Securing Cloud-Native Applications_
3:00 PM - 3:30 PM:: Afternoon Break
3:30 PM - 5:00 PM:: *Session 8:* _The API Gateway Pattern_

== Course Materials

=== Day One

* Session 1 (link:day_01/session_01/session_01.pdf[Slides])
** link:day_01/session_01/lab_01/lab_01.html[Lab 1 - Getting Started with Spring Boot]
** link:day_01/session_01/lab_02/lab_02.html[Lab 2 - Deploying a Web Application with an Embedded Container]
** link:day_01/session_01/lab_03/lab_03.html[Lab 3 - Externalizing Configuration with Spring Boot]
** link:day_01/session_01/lab_04/lab_04.html[Lab 4 - Introspection, Monitoring, and Metrics using Spring Boot Actuator]
* Session 2
** link:day_01/session_02/lab_05/lab_05.html[Lab 5 - From Zero to Pushing Your First Application]
** link:day_01/session_02/lab_06/lab_06.html[Lab 6 - Binding to Cloud Foundry Services]
** link:day_01/session_02/lab_07/lab_07.html[Lab 7 - Scaling Applications]
** link:day_01/session_02/lab_08/lab_08.html[Lab 8 - Monitoring Applications]
* Session 3 (link:day_01/session_03/session_03.pdf[Slides])
** link:day_01/session_03/lab_09/lab_09.html[Lab 9 - Build a Hypermedia-Driven RESTful Web Service with Spring Data REST]
** link:day_01/session_03/lab_10/lab_10.html[Lab 10 - Leveraging Spring Cloud Connectors for Service Binding]
* Session 4 (link:day_01/session_04/session_04.pdf[Slides])
** link:day_01/session_04/lab_11/lab_11.html[Lab 11 - Build a Product Search/Details Service using PostgreSQL]
** link:day_01/session_04/lab_12/lab_12.html[Lab 12 - Build a Product Review Service with MongoDB]
** link:day_01/session_04/lab_13/lab_13.html[Lab 13 - Build a Product Recommendation Service with Neo4J]

=== Day Two

* link:day_02/session_05/session_05.pdf[Session 5 Slides]
** link:day_02/session_05/lab_14/lab_14.html[Lab 14 - Deploying and Using Spring Cloud Config Server]
** link:day_02/session_05/lab_15/lab_15.html[Lab 15 - Refreshing Configuration with Spring Cloud Bus]
** link:day_02/session_05/lab_16/lab_16.html[Lab 16 - Leveraging Eureka for Service Discovery via Spring Cloud Netflix]
* link:day_02/session_06/session_06.pdf[Session 6 Slides]
** link:day_02/session_06/lab_17/lab_17.html[Lab 17 - Client-Side Load Balancing with Ribbon]
** link:day_02/session_06/lab_18/lab_18.html[Lab 18 - Declarative REST Clients with Feign]
** link:day_02/session_06/lab_19/lab_19.html[Lab 19 - Fault-Tolerance with Hystrix]
** link:day_02/session_06/lab_20/lab_20.html[Lab 20 - Monitoring Circuit Breakers with Hystrix Dashboard]
* link:day_02/session_07/session_07.pdf[Session 7 Slides]
** link:day_02/session_07/lab_21/lab_21.html[Lab 21 - Creating an OAuth2 Authorization Server]
** link:day_02/session_07/lab_22/lab_22.html[Lab 22 - Securing a Resource Server with Spring Cloud Security]
* link:day_02/session_08/session_08.pdf[Session 8 Slides]
** link:day_02/session_08/lab_23/lab_23.html[Lab 23 - Building a Simple Reverse Proxy with Zuul]
** link:day_02/session_08/lab_24/lab_24.html[Lab 24 - API Aggregation and Transformation with RxJava]
** link:day_02/session_08/lab_25/lab_25.html[Lab 25 - Implementing OAuth2 SSO in the API Gateway with Spring Cloud Security]
** link:day_02/session_08/lab_26/lab_26.html[Lab 26 - Icing on the Cake: Adding the User Interface]
