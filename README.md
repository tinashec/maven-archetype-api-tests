This is a Maven archetype project for creating an E2E API testing framework. The framework uses RestAssured as the rest client and TestNG as the test framework. 
When creating a testing framework there is a lot to  consider. The test framework (TestNG, jUnit), the rest client, the reporting tools, the software build management (Gradle or Maven),
will the be data-driven and the structure of the project itself (where do the test classes go, where do I put the endpoints, where do I put the payload). All this can be overwhelming 
as you start. The goal of this archetype is to help thos with those questions, to generate a project with everything setup and have them running E2E API tests with just a few commands. 
