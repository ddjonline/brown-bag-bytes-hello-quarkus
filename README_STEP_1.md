# Step 1 (Maven project setup)

This project will be set up as an Apache Maven project. Maven is one of the most widely used build tools used for Java-based applications (Gradle is the other).

## Directory Structure

This training is intended to be VERY generic. As such let's create the project under a very generic and nebulous domain of `hello.quarkus.brown.bag.bytes.org` . In order to prepare for source code, we've created the following directory structure which follows standard Maven conventions which is to reverse the order of the domain parts to create a `groupId` value of `org.bytes.bag.brown.quarkus.hello` and a matching directorystructure of `org/bytes/bag/brown/quarkus/hello`.

* src
  * main
    * java
      * org
        * bytes
          * bag
            * brown
              * quarkus
                * hello
    * resources
  * test
    * java
      * org
        * bytes
          * bag
            * brown
              * quarkus
                * hello
    * resources
* pom.xml

## Maven POM file

Maven is controlled by an XML file called the Project Object Model file often simply named `pom.xml` which resides at the root of each project. This file contains the information about the project as well as how to build the source code and dependency libraries into an application.

For this training we will be creating a simple REST API project which will return a simple string response. Quarkus can be built into several types of outputs such as simple "Jar" (Java Archive) file (simple jar which then uses additional library files externally on the classpath using a JRE to run), an "Uber" or "FAT" jar (all source and resources contained in a single, self-sustained file using a JRE to run), or a native executable (fully compiled application which does not need _anything_ externally to run). For the sake of simplicity and to match the current best long-term performance pattern, we will use the "Uber" jar pattern.

### Pom File

Review the [pom.xml](pom.xml) file at your leisure. This pom file sets us up with Quarkus version `3.21.0` with health checks, unit tests, and the Quarkus DEV UI tool we will use later on.

### Formatting and Git Management Files

In the root of the project source, you will notice 2 additional files.

The .gitignore file is for configuring the GIT source code management tool used during development to prevent GIT from uploading and saving temporary, ephemeral files which do not belong in GIT. Only source and configuration files are stored in the GIT source code repository as a standard. The temporary files used to create the application and the application output itself should not be saved so that the source becomes the "source of truth" of the project.

The .editorconfig file is a control file to help with IDE extensions to know how to consistently format the source code.

## Start the Dev-UI

In a terminal/Command Prompt session at the root of this project perform the following in order to start the Quarkus Dev experience:

```shell
mvn quarkus:dev
```

Open a browser to <http://localhost:8080/q/dev-ui> and view the base Quarkus DEV UI to explore your running application.

## Next...

Next step is to write some code => [Step 2](README_STEP_2.md)
