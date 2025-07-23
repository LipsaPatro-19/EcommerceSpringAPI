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

Tried making http call using RestTemplate of Spring.
Also applied Adapter pattern i guess like mapping a particular object to a different required object or list of object.

Client <--> Controller (JSON)
Controller <--> Service (DTO)
Service <--> Repository (Entities) MapperClass for converting DTO to Entity or Entity to DTO
Repository <--> Database (SQL)

-----------
Repository ---- DB (SQL)
DB ---- Repository >>>> Optional<Product> -> DB in Entity format with Optional wrapper
possibility of null safe

Optional<Entity?> - container that or may not contain not null
It forces the developer to explicitly handle the "not found" case rather than accidentally functioning on a null value

Optional<Product> Table <1,2,3,4,5>
repo.findById(2); //works fine
Product response= repo.findById(20) // null
response.getColor(); // nullpointerexception - this will be thrown if we don't write the the Optional wrapper

Product Table
<------>
categoryId:1 instead of categoryName

Category Table
1 Footwear
2 Electronics

Product belongs to Category 
A single category can have multiple products associated with it.
A join allows you to combine data from two or more tables based on relationship
To represent the above line in spring JPA we have Entity Relationship Mapping
Some annotation - @ManytoOne @OneToMany

FetchType:
EAGER
<----->
Hibernate: select p1_0.id,p1_0.brand,p1_0.category_id,c1_0.id,c1_0.created_at,c1_0.name,c1_0.updated_at,p1_0.color,p1_0.created_at,p1_0.description,p1_0.discount,p1_0.image,p1_0.model,p1_0.popular,p1_0.price,p1_0.title,p1_0.updated_at from product p1_0 join category c1_0 on c1_0.id=p1_0.category_id where p1_0.id=?

LAZY
<---->
Hibernate: select p1_0.id,p1_0.brand,p1_0.category_id,p1_0.color,p1_0.created_at,p1_0.description,p1_0.discount,p1_0.image,p1_0.model,p1_0.popular,p1_0.price,p1_0.title,p1_0.updated_at from product p1_0 where p1_0.id=?
Hibernate: select c1_0.id,c1_0.created_at,c1_0.name,c1_0.updated_at from category c1_0 where c1_0.id=?

ByDefault:
@ManyToOne > Eager
@OneToOne > Eager

@OneToMany > Lazy
@ManyToMany > Lazy

EAGER -> In Eager it will fetch the detail in one hql query using join for the JoinColumn field
LAZY -> In Lazy it won't fetch the detail of joinColumn field except that other fields value will be fetech using first hql, where the joinColumn field is need then it will again make a second hql query to the joincolumn field value for ex when we are trying to do getCategories in mapper class of product for the category field in ProductDtoWIthCategory function

UseCase: 
-When we are having some sort of tight coupling like we need the all the detail including the joinColumn field also then we user Eager
-When we are having some sort of loose coupling like suppose we have the category right it also has a field that have list of products, every time we don't need to load all the products of a particular category, when it is required or asked we can get the list, so in this case we can make this field's fetchType as Lazy





