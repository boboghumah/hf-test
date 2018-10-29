# qa-test-hf Test 1 (UI Automation)

## Getting started

#### Requirements [Important]
+ This project uses the [Cucumber.io](https://docs.cucumber.io/guides/) testing framework
+ You will need to have the Java Development Kit (JDK) installed. The minimum required version is 7. 
You can check this by running `java -version` from the command line.
+ You will need to have the Maven installed. The required version is 3.5.4. 
You can check this by running `maven -version` from the command line.


#### Getting Getting the source code
To get started, clone the repository using the commands

```bash
git clone https://github.com/boboghumah/hf-test.git
```

#### How to RUN:

+ Import project into Eclipse IDE as maven project.
+ Go To src > test >> java >> com >> hellofreshchallenge >> runner
+ Right click on MainRunner.java file and you will get option to RUN as JUNIT test. 
+ Click on it and it will start execution.
+ Result can be found in the target folder


# qa-test-hf Test 2 (API Automation)
## Getting started

#### Requirements [Important]
+ This project uses the [org.apache.httpcomponents](https://hc.apache.org/httpcomponents-client-ga/quickstart.html) testing tool
+ You will need to have the Java Development Kit (JDK) installed. The minimum required version is 7. 
You can check this by running `java -version` from the command line.


#### How to RUN:

+ Import project into IntelliJ IDE as maven project.
+ All the required dependencies will be downloaded from the POM file.
+ Go To src > test >> java >> com >> hellofreshchallenge >> runner
+ Right click on the java folder and you will get option to RUN All Test. 
+ Click on it and it will start execution.

#### How to RUN from Command line:
+ Navigate to the project from your command line
+ Enter `mvn install` 
+ Enter `mvn clean test`
###Note : The test will fail because the `AddCountryTest` is expecting a `204` but got a `200`. change the expected result to `200` for all the test to pass
