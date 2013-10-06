Spring WebMVC / Jetty example [![Build Status](https://travis-ci.org/AlanHohn/webmvc.png)](https://travis-ci.org/AlanHohn/webmvc)
======

This is a small Java project initially developed for a class on
distributed Java (mostly Java EE and Spring). 

The code consists of both a client and a webapp that provides
a trivial calculation capability to illustrate using Spring
WebMVC. There's also a useful `EmbeddedServer` class that allows
the webapp to be run as a standalone Java application (content
based on [this tutorial][tut]). The project can also be built
as a WAR using Maven.

[tut]:http://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty

Finally, there's a sample of using Google's Places API with
Spring WebMVC providing the client functionality and Jackson
doing conversion of the JSON result to a graph of Java objects.



