## Lesson 44 
#  making Hibernate happy::) Initializing Data with Spring

What are we going to do to complete building our database's initial state,
is to add to the <code>book_seq</code> the initial value in order to make
hibernate happy.

### Liquibase documentation how to make INSERT

https://docs.liquibase.com/change-types/insert.html#sql_example

So, all what we want to do is to add a new changeSet to our changeLog.
Let's call this new changeLog file 

[init-hibernate.xml](/src/main/resources/db/changelog/init-hibernate.xml)

containing the next changeSet:

      <changeSet author="SG" id="3">
         <sql>INSERT INTO book_seq VALUES(0)</sql>
      </changeSet>

The <code>id="3"</code> we take because there were only two changeSets before
initializing our database

The last step we want to do is to add this new changeLog file to the changelog-master.xml

[init-hibernate.xml](/src/main/resources/db/changelog/changelog-master.xml)

And we will add a new <code>include</code> descriptor in there:

      <include file="db/changelog/init-hibernate.xml"/>

So, now we can start our Spring Boot Application running. 
And we'll see that the table <code>book_seq</code> was initialized,
and we have our books being added. And also we can see that
the table <code>DATABASECHANGELOG</code> was modified and there is a new
record describing our just created and now executed changeSet under the ID=3.

<br><br>