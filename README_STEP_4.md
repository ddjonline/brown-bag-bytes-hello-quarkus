# Step 4 (Use the Uber/FAT Jar File)

Up until now we've been using the Quarkus Developer framework to run the application. But that is not how the application would be run as a deployed application.

As a reminder Quarkus offers several options to build the application for deployment (set by the `quarkus.package.jar.type` value set in the pom.xml file):

* `mutable-jar` - used for remote development mode where only the changed source is deployed
* `fast-jar` - (default) application jar and separate library bundle to reduce the application upload if the libraries are already available in the container or target server.
* `uber-jar` executable Uber/FAT Jar run by the JVM/JRE with all dependencies loaded and filtered. <== This is the one we want!!
* `legacy-jar` - the original type before version `1.12`
* Native executable created by the GraalVM (or Mandrel) which can run as an *.exe file without the need for a separate JVM/JRE install

For the sake of time and to match the usual deployed pattern of an application which is intended to run for an extended amount of time, we are only going to test the JVM Uber/FAT pattern.

However, the native option is something to definitely explore if you have time. The Native compiled option is scary fast in both its bootup time and its responses for a long period of time. However, the JVM has had a few decades at this point to figure out memory management and will perform better for applications deployed for long periods of time.

If you have the Quarkus DEV framework (still running `mvn quarkus:dev`), stop the framework.

In a terminal/Command Prompt at the root of the project directory perform the following command:

```shell
mvn clean package
```

This command shoudl have successfully completed and you should now see a file called `brown-bag-bytes-hello-quarkus-1.0.0-SNAPSHOT-runner.jar` in a new `target/` subdirectory of the project.

Let's run the executable jar and see the REST API in action

```shell
java -jar target/brown-bag-bytes-hello-quarkus-1.0.0-SNAPSHOT-runner.jar
```

You should now be able to open the endpoints in your browser or simply refresh them to view the server running at either <http://localhost:8080/step2> and <http://localhost:8080/step3> just as you did before but the Quarkus DEV UI should no longer be responding.

## You Did It!

You have now created a simple but very efficient Java application that responds to REST GET requests. Let's get creative...
