#Spring Annotation

1. @Value - can be used for injecting application.properties values into Spring managed beans.


2. @ConfigurationProperties - You can define POJO with the configuration/application properties field and it will read the properties
   @ConfigurationPropertiesScan. @ConfigurationPropertiesScan - This makes class be available for injection. 


3. @Autowired, @Bean, @Configuration, @Component, @Service, @Repository, @RestController, @RestControllerAdvice, @SpringBootApplication
   @ConditionalOnMissingBean


4. @ExceptionHandler, @InitBinder, and @ModelAttribute methods apply within the @Controller class (or class hierarchy) in which they are declared.
   
   If you want such methods to apply more globally (across controllers), you can declare them in a class annotated with @ControllerAdvice or @RestControllerAdvice.

