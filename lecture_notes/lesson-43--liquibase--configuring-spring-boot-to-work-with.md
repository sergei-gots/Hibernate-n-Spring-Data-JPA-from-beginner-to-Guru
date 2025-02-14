## Lesson 43 
#  Using Liquibase with Spring Boot

So here we've got a tutorial that's been published by <span style="color:violet">Liquibase</span>
at to use Spring Boot with it:

https://contribute.liquibase.com/extensions-integrations/directory/integration-docs/springboot/

Spring Boot will go through autoconfiguration steps to configure using
Liquibase for us. The key thing that we want to point out on this documentation is there's a set of properties that we can use to set things up.
The key properties we'll use to provide <span style="color:violet">Liquibase</span> integration are:

<li>spring.liquibase.<b>change-log</b> to determine our changeLog file
<li>spring.liquibase.<b>username</b> 
<li>spring.liquibase.<b>password</b> to access to the database

### Configuring Spring Boot Application to work with Liquibase

1. We need to add in to the <code>pom.xml</code> the new dependency for that.
   John likes to add in this right above the test dependencies.

        <dependency>
   	        <groupId>org.liquibase</groupId>
   	        <artifactId>liquibase-core</artifactId>
        </dependency>

2. Next thing we want to do is come over here to <code>application.properties</code> i.e. in the core application properties.
   And here what we want to do is set up that <code>spring.liquibase.change-log</code>:

   
        spring.liquibase.change-log=db/changelog/changelog-master.xml

3. And what we will also want to do here is this will fork fine for H2
   because we're not using multiple users in this, but for our application local profile, this is where we can set up the overrides.
   So remember we did this a little while ago, so let's come back over here
   to SQL users in

[create--users-n-schema.sql](../src/main/scripts/create--users-n-schema.sql)

where we created two users with different levels of privileges.
And so we have an application user <b>bookuser</b> with limited permissions.
And then we also have the user <b>bookadmin</b> that
has elevated properties that can actually do things create tables, drop tables and things like that.
So again, this is <b>security 101 type stuff</b> where we want to have
our application service accounts have the minimal access to a database.
<br>So now what we can do is previously we had use the elevated privileges.
Now we can actually change those.
So that is going to set uup the Spring Boot Application,
so the Spring Boot Application will be using <b>bookuser</b>  
and for Liquibase we will be using the next <code>application-local.properties</code>-entries:

	spring.liquibase.user=bookadmin
	spring.liquibase.password=password

4. Before we run, we want to clean up the database,
   so we're going to come over here to e.g. dBeaver,
   we got the two tables, the <code>book</code> and <code>book_seq</code>.
   And we're going to go ahead and just drop these tables.
   <br><br>
   And toggle back over to InitelliJ and let's go ahead and run our application.
   <br>And here we will run into an error and can see:

   
    Caused by: java.sql.SQLSyntaxErrorException: DROP command denied to user 'bookuser'@'localhost' for table 'book'

Guess why we see this error. There are 2 reasons.
<li>So one, we are trying to DROP the table, so what's happening is that DROP command is coming from our firstly added <code>resources/schema.sql</code>, so it says <code>DROP TABLE IF EXISTS</code>. But what's happening is that DROP commande is being issued under bookuser account, which does not have permisiions in that scale to do that.
<li>The second thing is, by default, <b>Hibernate</b> is going to be running that schema SQL when it finds <code>schema.sql</code> it in the classpath.
And the way we can fix that, fix both of those things is 
we want to take it from resources and move it under scripts, so we're
just going to refactor this and move <code>schema.sql</code> out there, or just rename this file not to have the key <code>schema.sql</code> name.
becase we don't want that running anymore, we are now managing the database using Liquibase.

<br><br>Ok, we've fixed it. And now will run into a different error:

	org.springframework.orm.jpa.JpaSystemException: could not read a hi value - you need to populate the table: book_seq
	Caused by: org.hibernate.id.IdentifierGenerationException: could not read a hi value - you need to populate the table: book_seq

It's because if we can see our tablse <code>book</code> and <code>book_seq</code>. And the problem is the table <code>book_seq</code> is empty. There's no next value in there. And what we need to do here is populate a balue into this table, and we're going to find out how to do this that in the next lesson.
<br> Once again, what we need to do here is configure Liquibase to populate that value.

### The tables DATABASECHANGELOG and DATABASECHANGELOGLOCK

But what we can see extra, the tables <code>DATABASECHANGELOG</code>,
<code>DATABASECHANGELOGLOCK</code>. These are the tables that have been generated. Take a peek at them. They contain information about changesets
been ever executed upon the database.
So here we can see the id, the author and the data executed so
we can see what has been put in there, description etc. So this is a log of changes applied to the database.
And remember, we talked about having this type of tool being able to track
changes to the database. So now we have a database table that tells us what logs have been applied. Very important that we have this record, a really great audit record to have for use for migrating to multiple databases.



<br><br>