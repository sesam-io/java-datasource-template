========================
java-datasource-template
========================

A Java microservice template for feeding a JSON entity stream to a Sesam service instance.

Build the service using Maven:

::

  $ mvn clean package
  
Start the service.

::

  $ mvn exec:java
  [INFO] Scanning for projects...
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building java-datasource-template 1.0-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ java-datasource-template ---
  [Thread-1] INFO org.eclipse.jetty.util.log - Logging initialized @1405ms
  [Thread-1] INFO spark.embeddedserver.jetty.EmbeddedJettyServer - == Spark has ignited ...
  [Thread-1] INFO spark.embeddedserver.jetty.EmbeddedJettyServer - >> Listening on 0.0.0.0:4567
  [Thread-1] INFO org.eclipse.jetty.server.Server - jetty-9.3.6.v20151106
  [Thread-1] INFO org.eclipse.jetty.server.ServerConnector - Started ServerConnector@2b17199d{HTTP/1.1,[http/1.1]}{0.0.0.0:4567}
  [Thread-1] INFO org.eclipse.jetty.server.Server - Started @1473ms
    
The service listens on port 4567. JSON entities can be retrieved from 'http://localhost:4567/entities'.

::

  $ curl -s 'http://localhost:4567/entities' | python3 -m json.tool
  [
      {
          "id": "entity-0",
          "name": "entity-0",
          "updated": "2016-06-26T08:42:45.815Z"
      },
      {
          "id": "entity-1",
          "name": "entity-1",
          "updated": "2016-06-26T08:42:45.816Z"
      },
      {
          "id": "entity-2",
          "name": "entity-2",
          "updated": "2016-06-26T08:42:45.817Z"
      },
      {
          "id": "entity-3",
          "name": "entity-3",
          "updated": "2016-06-26T08:42:45.818Z"
      },
      {
          "id": "entity-4",
          "name": "entity-4",
          "updated": "2016-06-26T08:42:45.819Z"
      },
      {
          "id": "entity-5",
          "name": "entity-5",
          "updated": "2016-06-26T08:42:45.820Z"
      },
      {
          "id": "entity-6",
          "name": "entity-6",
          "updated": "2016-06-26T08:42:45.821Z"
      },
      {
          "id": "entity-7",
          "name": "entity-7",
          "updated": "2016-06-26T08:42:45.822Z"
      },
      {
          "id": "entity-8",
          "name": "entity-8",
          "updated": "2016-06-26T08:42:45.823Z"
      },
      {
          "id": "entity-9",
          "name": "entity-9",
          "updated": "2016-06-26T08:42:45.824Z"
      }
  ]

::

  $ curl -s 'http://localhost:4567/entities?since=2016-06-26T08:42:45.822Z' | python3 -m json.tool
  [
      {
          "id": "entity-8",
          "name": "entity-8",
          "updated": "2016-06-26T08:42:45.823Z"
      },
      {
          "id": "entity-9",
          "name": "entity-9",
          "updated": "2016-06-26T08:42:45.824Z"
      }
  ]
