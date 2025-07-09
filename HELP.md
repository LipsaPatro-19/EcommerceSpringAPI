# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.3/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.3/gradle-plugin/packaging-oci-image.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.5.3/reference/using/devtools.html)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/3.5.3/specification/configuration-metadata/annotation-processor.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.3/reference/web/servlet.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Flow 
Whenever client hits api/categories ->
the request goes to CategoryController ->
then the corresponding getmapping method and inside that to CategoryService which is service layer->
then CategoryGateway which is Gateway layer ->
Gateway layer is going to make a third party API call which is FakeStoreCategoryAPI call

Inside FakeStoreCategoryGateway we are doing fakeStoreCategoryAPI.getAllFakeCategories().
here how we are getting the object of fakeStoreCategoryAPI - this a retrofit api not springboot one.
So this taken care in RetroConfig by doing Bean of FakeStoreCategoryAPI. So when ever we need a object of fakeStoreCategoryAPI
that will get by the method in RetroConfig. Inside here we need a retrofit object, which is also getting created in the same file
so how will we know how to create a Retrofit object we will refer to the Retrofit documentation

@Primary - while implementing the same interface in multiple class it might show conflict in constructor dependency injection,
so to fix that we can mention any one class as Primary so while creating Object it can create the object of the Primary class
It defines default class to inject

@Qualifier - It is specific


