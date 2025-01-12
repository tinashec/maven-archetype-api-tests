# E2E API Test Archetype
This is a Maven archetype project for creating an E2E API testing framework. The framework uses RestAssured as the rest client and TestNG as the test framework. When creating a testing framework from scratch there is a lot to consider. Things like, the test framework (TestNG, jUnit), the rest clients, the reporting tools, and the software build management (Gradle or Maven), will the tests be data-driven? What is the structure of the project itself (where do the test classes go, where do I put the endpoints, where do I put the payload)? All this can be overwhelming as you start. The goal of this archetype is to help those with these questions, to generate a project with everything set up and have them running E2E API tests with just a few commands.
# Getting started
The project requires Java 21 and uses Maven as the software project management tool. The IDE of choice is IntelliJ, feel free to use any IDE you're comfortable with.
First things first, clone the repo and navigate to the root of the cloned project i.e. `cd <your_project_folder>/api-test-archetype/`. 
Next, in the terminal, run the following command from the root of the cloned project:
1. `mvn install`
2. navigate out of the project e.g. `cd` 
3. create a folder that'll house your test project if not already available e.g. `mkdir api-test`
4. navigate to the root i.e. `cd api-test` and run the command
      ```
         mvn archetype:generate -DarchetypeGroupId=org.example -DarchetypeArtifactId=api-test-archetype -DarchetypeVersion=1.0-SNAPSHOT -DartifactId=api-test  
      ```
5. the command above will prompt you to define
      - groupID: e.g. com.my_company_name
      - version: e.g. 1.0
      - package: e.g. e2e-api-test 
      - confirmation of the config. Type yes i.e. y 
7. this will create the project which you can open in your IDE

# Directory structure
```
api-test
|-- pom.xml
`-- src
    |`-- main
    |   `-- java
    |     `-- e2e-api-test
    `-- test
        `-- java
            `-- e2e-api-test
                 `-- dataprovider
                 `-- endpoints
                 `-- model
                 `-- payload
                 `-- utils
```
# Overview of the project structure
The dataprovider package will house the classes that inject data into the test. Think of this as having the responsibility
to generate and supply data to your test. Do you need a user to login? Do you need details of a payment i.e. card details,
amount and what is being paid for? The dataprovider is responsible for generating this. In advanced setups, you can connect to 
and get the data from a DB.

The endpoints define the REST related methods for the API calls. e.g. if the service under test
creates a user via a POST request to the endpoint `/create/user/`, we will have the method `createUser(CreateUserPayload payload)`
in the endpoints package. 

The model defines entities that are used to build up the payload. When 
creating a user the payload could require details of the user and information related to their location i.e.
Address. The model can have an Address and User entities.

The payload defines the request body required by the service. Last but not least, tests can be grouped by the feature being tested.