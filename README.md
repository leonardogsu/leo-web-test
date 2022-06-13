#  TIC.BO Automated Tests

## Table Of Contents
* Features
* Pre-requisites
* Project Structure
* How to execute tests
* Reports

##  Features
Features files are located at:
```
src/test/resources/stories/functional/

```

##  Pre-requisites

1. JDK 8 installed
2. Maven installed and configured

##  Project Structure

```
leo-web-test/
├── README.md
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   └── test
│       ├── java
│       │   └── bo
│       │       └── tic
│       │           ├── bdd
│       │           │   ├── runners
│       │           │   │   └── TestRunner.java
│       │           │   └── stepdefinitions
│       │           │       └── Steps.java
│       │           ├── drivers
│       │           │   └── RemoteDriver.java
│       │           └── tools
│       └── resources
│           ├── project.properties
│           └── stories
│               └── functional
│                   └── suite_a
│                       └── rest
│                           └── Suite - A - Catalog - List.feature
└── target
    ├── generated-test-sources
    │   └── test-annotations
    ├── leo-web-test-0.0.1-SNAPSHOT.jar
    ├── maven-archiver
    │   └── pom.properties
    ├── maven-status
    │   └── maven-compiler-plugin
    │       ├── compile
    │       │   └── default-compile
    │       │       └── inputFiles.lst
    │       └── testCompile
    │           └── default-testCompile
    │               ├── createdFiles.lst
    │               └── inputFiles.lst
    ├── surefire-reports
    │   ├── TEST-bo.tic.bdd.runners.TestRunner.xml
    │   └── bo.tic.bdd.runners.TestRunner.txt
    └── test-classes
        ├── bo
        │   └── tic
        │       ├── bdd
        │       │   ├── runners
        │       │   │   └── TestRunner.class
        │       │   └── stepdefinitions
        │       │       └── Steps.class
        │       └── drivers
        │           └── RemoteDriver.class
        ├── project.properties
        └── stories
            └── functional
                └── suite_a
                    └── rest
                        └── Suite - A - Catalog - List.feature


```

##  How to execute tests

In a terminal from leo-web-test folder execute:

```
mvn clean install
mvn test

```

##  Reports
You can find execution reports in "target/surefire-reports"

```
leo-web-test/
├── README.md
├── pom.xml
├── src
└── target
├── generated-test-sources
├── leo-web-test-0.0.1-SNAPSHOT.jar
├── maven-archiver
├── maven-status
├── surefire-reports
│   ├── TEST-bo.tic.bdd.runners.TestRunner.xml
│   └── bo.tic.bdd.runners.TestRunner.txt
└── test-classes

``` 