# WebLogic Gelf logging

This is a very small library containing just a [WebLogic startup class](https://docs.oracle.com/en/middleware/standalone/weblogic-server/14.1.1.0/start/overview.html#GUID-593B21F9-F73D-4401-BFFF-D1301B28074E) that will register
a [GelfLogHandler](http://logging.paluch.biz/apidocs/index.html) with [WebLogic's server logger](https://docs.oracle.com/en/middleware/standalone/weblogic-server/14.1.1.0/wllog/logging_services.html#GUID-40A1C76D-7D13-4212-AA18-CF13C7D33B92).

# Usage
To use, put this jar in the `lib` directory under your WebLogic domain directory, along with `logstash-gelf-[VERSION].jar`. Then, using the WebLogic managment console, add a startup class (it's under the _Environment_ sub menu). 
The startup class should be `nl.dhlparcel.weblogic.gelf.Startup`, give it any name you like.

Configuration of the Gelf handler happens through the logging.properties file as described in its http://logging.paluch.biz/examples/jul.html. Set the `-Djava.util.logging.config.file` JVM parameter to the location of the properties file.
Finally, restart WebLogic.

# Building
`mvn package` should do, but there may be a trick to getting the `weblogic-logging` available. If it doesn't work out-of-the-box, you can try the [oracle-maven-sync plugin](https://docs.oracle.com/middleware/1212/core/MAVEN/config_maven.htm#MAVEN312), 
or access [Oracle's repository](https://docs.oracle.com/middleware/1213/core/MAVEN/config_maven_repo.htm#MAVEN9010).
