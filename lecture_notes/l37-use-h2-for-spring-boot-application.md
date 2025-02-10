# Lesson 37. Use H2 for Spring Boot Application 

What will happen if we run our application without the local profile enabled?  
So remember, the 'local' profile brings in the MySQL stuff.
So if we remove --spring.profiles.active=local

What we have we can see in pom.xml that:

    <dependency>
        <groupId>com.h2database</groupId>
    	<artefactId>h2</artefactId>
	    <scope>test</scope>
    </dependency>

So, we have H2 artifact brought in a test context
which has been working fine for us.

On the other side, we have specified the spring.datasource.url
to connect to an H2 database in application.properties
(i.e. for the profile by "default"):

    ##Specify the datasource url for an H2-in memory database
    ##and H2's MySQL compatibility properties:
    spring.datasource.url=jdbc:h2:mem:testdb;\
 
So if we're running our application with these settings
Spring Boot is going to kick into its default configuration
for an H2 in-memory database.
And we're getting failed to load H2 driver class:

    [com.zaxxer.hikari.HikariDataSource]: 
        Factory method 'dataSource' threw exception
        with message: Failed to load driver class org.h2.Driver

What that means is a H2 dependency is not being found on the class path.
Specifically what's happening is we have the H2 database defined as dependency,
but it's got a test scope, so it's going to be there for our test classes,
but we run the application
and only the stuff under the main Java is going to be picked up, not the test.
The test dependencies will not be brought into scope.
We could just remove the scope of test for the h2-dependecy,
but it is not the optimal solution, 
because then we're bringing int two different database drivers.

The better practice here is to use a maven profile to enable the H2 in-memory database for our application. So we add the section <profiles> in pom.xml and add the profile for h2 in there:

    <profiles>
    	<profile>
		    <id>h2</id>
		    <dependencies>
			    <dependency>
				    <groupId>com.h2database</groupId>
				    <artifactId>h2</artifactId>
			    </dependency>
		    </dependencies>
	    </profile>
    </profiles>

So now we can choose our new h2-profile there,
then we should refresh maven-dependencies,
and now if we run the Spring Boot application with the Maven profile of H2 enabled,
we can see that it started up normally.
This approach would be handy if we're doing some type of development,
e.g. as it is being done in this case, against a natural H2 in-memory database
for some rapid prototyping or something like that.

### Additional:
<br>
How To specify a Maven profile from the command line, use the -P option:

    mvn clean install -PprofileName

in our case:

    mvn clean install -Ph2


Replace profileName with the actual profile ID defined in your pom.xml.

If you need to activate multiple profiles, separate them with a comma:

    mvn clean install -Pprofile1,profile2

