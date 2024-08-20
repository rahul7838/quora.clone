## Quora Clone

# Goal: To create Quora backend using spring boot with Kotlin

#Requirement 
1. Use microservice architecture
2. Deploy to cloud 
3. Write swagger documentation
4. Write unit test and integration test cases
5. Conduct various performance tests (e.g., load, spike, breakpoint, endurance)
6. Integrate (SonarQube, Checkmarx, JFrog XRay, Blackduck) any one



# Design Details

Apis 
1. User Sign-up with email
2. Login
3. User Profile
4. Login with Google
5. Forgot password

#TODO
1. Why UserSignUpController test do not terminate
2. ~~Define Login API~~
3. ~~Write proper exception handling~~
   (https://medium.com/insights-from-thoughtclan/the-best-way-to-structure-api-responses-in-spring-boot-ff9005fb8ff0)
4. ~~Define standard response format for all apis~~
5. Define proper logging 
6. Sign up with Google 
7. Avoid men in the middle attack, secure apis communication
8. 


#Database

1. Database migration
2. Defining relations
3. Flyway vs Liquibase
4. RabbitMQ

#Future learning
1. Experience with at least one of the following messaging queue frameworks: Kafka, RabbitMQ, or ActiveMQ
2. Knowledge of OAuth2 SSO
3. Executor framework
4. Elastic search
5. Design pattern
6. Understanding of synchronous/asynchronous processing, statelessness, and containerized auto-scaling applications.
7. How will you determine api failure. Such as internal-server-error
