
# Spring Crudoperation Application 

## Running Crudoperation locally
Crudoperation is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line.


```
git clone https://github.com/pkesavulu/crudoperation.git

cd crudoperation-master

mvn clean install

java -jar crudoperation-0.0.1-SNAPSHOT.jar
```

You can then access Crudoperation here: http://localhost:8080/

### <u>Note</u>:- 
[accessKey,secretKey and topicArn](#AWS_Configuration) need to be updated in **application.properties** file before you can build the jar file.

## Database configuration

Here default configuration, Crudoperation uses an in-memory database (APACHE DERBY).

## AWS_Configuration

We can send a notification to users using AWS SNS(Simple Notification Service).

### Steps to configure AWS SNS:

* Create accessKey and secretKey using [IAM User](https://docs.aws.amazon.com/sns/latest/dg/sns-setting-up.html)

* Create a Topic using [Amazon SNS](https://docs.aws.amazon.com/sns/latest/dg/sns-getting-started.html) 

* Finally **accessKey,secretKey** and **topicArn** add into an  **application.properties** file.

## Working with Curdoperation in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 8 .
* git command line tool (https://help.github.com/articles/set-up-git)
* Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
  not there, just follow the install process here: https://www.eclipse.org/m2e/
* [VS Code](https://code.visualstudio.com)

### Steps:

1) On the command line
```
git clone https://github.com/pkesavulu/crudoperation.git
```
2) Inside Eclipse
```
File -> Import -> Maven -> Existing Maven project
```

Then Run the application main method by right clicking on it and choosing `Run As -> Java Application`.

3) Navigate to Crudoperation

Visit [http://localhost:8080](http://localhost:8080) in your browser.


