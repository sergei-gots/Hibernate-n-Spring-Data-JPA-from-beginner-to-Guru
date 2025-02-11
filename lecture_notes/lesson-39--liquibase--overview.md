## Lesson 39 
#  Overview of <span style="color:violet">Liquibase</span>

### What is a Migration?
<li> Migrations are the process of moving programming code from one system to another
<li> This is fairly large and complex topic of maintaining computer applications
<li> Database Migrations typically need to occur prior to, or in conjunction with application code
<li> Can lead to run time errors if database does not match what is expected
<li> Database migrations are a very important part of the process of moving your application code to
production
<li> Keep in mind, in larger organizations, you as the developer will NOT be doing the migration

### Why Use a Migration Tool?
<li> Hibernate can manage my schema fine, why use a migration tool?
<li> Managing many environments and databases:
<li> Dev (H2), CI/CD, QA, UAT, Production
<li> Development and CI/CD databases are easy, just rebuild each time
<li> QA, UAT, Production are permanent databases
<li> What state are they in?
<li> Has a script been applied?
<li> How to create a new database to a release?

### Why Use a Migration Tool?
<li> Database Migration tools can:
<li> Create a new database
<li> Hold history of migrations
<li> Have a reproducible state of the database
<li> Help manage changes being applied to numerous database instances
<li> Popular Open Source Database Migration Tools (Not a complete list):
<li> <span style="color:violet">Liquibase</span>
<li> <span style="color:red">Flyway</span>

### <span style="color:violet">Liquibase</span> and <span style="color:red">Flyway</span>
<li> Common Features:
<li> Command Line Tools
<li> Integration with Maven and Gradle
<li> Spring Boot Integration
<li> Use script files which can be versioned and tracked
<li> Use database table to track changes
<li> Have commercial support

<span style="color:violet">Liquibase</span> / <span style="color:red">Flyway</span> - Spring Boot Integration
<li> Spring Boot offers support for both <span style="color:violet">Liquibase</span> and <span style="color:red">Flyway</span>
<li> Fundamentally Spring Boot will apply change sets
<li> Spring Boot’s support is narrow in scope
<li> Both tools have additional capabilities available from the command line or build tool plugins
<li> The Spring Boot integration is convenient for migrations
<li> Both tools may be used independently of Spring Boot

<span style="color:violet">Liquibase</span> vs <span style="color:red">Flyway</span>
<li> <span style="color:violet">Liquibase</span> and <span style="color:red">Flyway</span> are very similar in terms of functionality
<li> Share same concepts, slightly different terminology
<li> <span style="color:violet">Liquibase</span> supports change scrips in SQL, XML, YAML, and JSON
<li> XML, YAML and JSON abstract SQL, which may be beneficial for different DB technologies
<li> <span style="color:red">Flyway</span> supports SQL and Java only
<li> <span style="color:violet">Liquibase</span> is a larger and more robust product
<li> <span style="color:red">Flyway</span> seems to have more popularity
<li> Both are mature and widely used

<span style="color:violet">Liquibase</span> vs <span style="color:red">Flyway</span> - Which to Use?
<li> <span style="color:violet">Liquibase</span> is probably a better solution for large enterprises with complex environments
<li> <span style="color:red">Flyway</span> is good for 90% of applications which don’t need the additional capabilities
<li> Recommendation:
<li> If one or the other is being used in the organization, use it
<li> If in doubt, do your own research on each option
<li> John’s preference is <span style="color:red">Flyway</span> - simple and easy to use