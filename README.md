#### Class path
* Classpath is location where your jar files(contains .class files) are present. 
* Whenever you add maven dependency to pom.xml, maven will download that dependency as JAR file and add to the classpath. 
* Spring boot app refer to the classpath where all the jars files located.

#### Magic of Spring Boot
* **1 Spring boot starter project:**
* Spring Boot comes with the concept of starter in pom.xml file that internally takes care of downloading the dependencies JARs based on Spring Boot Requirement. Whereas in Spring developers manually define dependencies for the Spring project in pom.xml.
* Goal of starter project is to get a project up & running quickly.
* Starter project manages list of maven dependencies & versions of different kinds of apps, so u don't have to worry about dependencies & different versions of those dependencies.
* Eg: spring-boot-starter-web contains all the framework needed by typical web applications eg: spring-webmvc, spring-web, spring-boot-starter-tomcat, spring-boot-starter-json.
* **2 Spring boot autoconfiguration:**
* Let’s look at a typical Spring boot application like following:
* @SpringBootApplication
* public class Application {
* public static void main(String[] args) {
* SpringApplication.run(Application.class, args);
* }
* It has a crucial code which does the so-called magic. It is the @SpringBootApplication. This is actually a combination of three annotations. @SpringBootConfiguration, @ComponentScan, @EnableAutoConfiguration.
* @ComponentScan is responsible to load all the beans defined by the developer of the application in user configuration.
* Spring boot starter projects define the different dependencies that are needed to build different kinds of applications & spring boot autoconfiguration(@EnableAutoConfiguration) would look at those dependencies/all the classes available in class path & it would provide autoconfiguration that is typically needed with that kind of application. For eg: If I'm developing a web application, I would want to configure a servlet, I would want to configure a server where I would want to run the application, I would want to configure default error pages, I would want to configure conversion from Java Objects to Json & vice versa. All these configurations are automatically done, so that u can focus on ur business logic. Its goal is that we focus on our application which we are building & not the framework which we are using.
* [Spring Boot Auto Configuration video explanation](https://www.youtube.com/watch?v=qm_lBjlwQLY)
* **3 Spring Boot Embedded servers:**
* Earlier this is how we deployed application(Complex approach/WAR approach):
* 1: Install Java.
* 2: Install web/application server. eg: Tomcat, WebSphere, WebLogic, etc.
* 3: Deploy the application WAR(Web Archive).
* Now due to Embedded servers(Servers which are present in JAR files downloaded by the Spring framework) in Spring Boot, the process of deploying application is very simple.
* 1: Install Java.
* 2: Run JAR file(ur JAR has server in-built).
* With Spring Boot, the default embedded server is Tomcat. Other options available are Jetty and UnderTow.
* [Spring vs Spring MVC vs Spring boot](https://www.javatpoint.com/spring-vs-spring-boot-vs-spring-mvc)

#### JSON, Serialization & Deserialization
* JSON(Javascript Object Notation) is the most popular format for the exchange of data in the world of web applications. 
* The browsers can easily parse json requests and convert them to javascript objects.
* The servers parse json requests, process them, and generates a new json response. 
* JSON is self-describing and easy to understand. 
* The process of converting java objects to json(& other formats as well) is called serialization.
* The process of converting json(& other formats as well) to java objects is called deserialization.

#### Jackson in Spring boot
* Jackson is a Java Json library used for Serialization & Deserialization.
* It has built in Object Mapper class which parses json files and deserializes it to custom java objects. It helps in generating json from java objects.
* We need public getters(if class data members are private) in Class so that Jackson can convert java objects to json & vice versa.

#### Spring Boot Actuator
Monitor & manages ur application in production.
To use Actuator, u need to define a dependency called spring-boot-starter-actuator in ur pom.xml.
Defined in application.properties
Provides u with the number of endpoints Eg:
/beans: Complete list of spring beans in ur app.
/health: Application health information.
/metrics: Application metrics.
/mappings: Details around request mapping.

#### Spring Boot Dev Tools
* DevTools stands for Developer Tool. The aim of the module is to try and improve the development time while working with the Spring Boot application. 
* Spring Boot DevTools pick up the changes done in the application & restart the application.
* If u add or remove a dependency in pom.xml DevTools will not be able to pick that up.
* We can implement the DevTools in our project by adding the following dependency in the pom.xml file.
* groupId: org.springframework.boot  
* artifactId: spring-boot-devtools 
* scope: runtime // Because we don't want it to be a part of deployable unit(JAR)/production.