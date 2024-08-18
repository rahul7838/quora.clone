#Testing learning

1. @SpringBootTest - 
   * Load the full application context, beans, configurations, and even embedded servers like Tomcat, if you're running a web application.
   * Typically, used for integration testing


2. @TestPropertySource - specify the property file that override the application.properties attribute


3. @WebMvcTest -  It focuses on the web layer of the application, loading only the necessary components (such as controllers, @ControllerAdvice, @JsonComponent, etc.) without starting the entire Spring context or the embedded server.


4. @DataJpaTest - 
* It is a Spring Boot test annotation specifically designed for testing the JPA (Java Persistence API) layer, which typically includes repositories and entities
* @DataJpaTest automatically configures the necessary components for testing JPA repositories, such as EntityManager, DataSource, and the repositories themselves.

5. @TestConfiguration - 
* @Configuration that can be used to define additional beans or customizations for a test.
* Configuration classes annotated with @TestConfiguration are excluded from component scanning, therefore we need to import it explicitly in every test where we want to @Autowire it. We can do that with the @Import annotation

6. @MockBean - is a Spring Boot test annotation used to create and inject mock objects into the Spring application context during testing.
