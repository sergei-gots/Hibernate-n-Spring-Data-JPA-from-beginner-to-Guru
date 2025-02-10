#  Part VI. <span style="color: blue;">Liquibase</span>
   ________________________________________
## Lesson 38 
#  Database Migration Tools. Introduction

So it would kind of be ground
as far as working with hibernate and databases.
Hibernate itself does nice job of being able to automatically manage schemas and things like that.
The problem is, it's kind of very rudimentary.
And it's functionality,
very basic functionality, as far as managing databases.
<br>
There are two very popular tools for basically
what's called <b>schema management</b>.
As far as automating database deployments,
<span style="color: blue;">Liquibase</span> and also <span style="color: red;">Flyway</span>,
we're going to look at both of those in this section.
Specifically, we're going to be talking about <span style="color: blue;">Liquibase</span> and how
it manages schema.  We'll talk about the importance of schema migrations coming up in this course.
<br>
In this section of the course, we'll be looking at not only schema migration tools, 
but we are going to take a deep dive into the liquibase about how we can utilize that 
to manage our schema and a permanent database and how we can use it for a migration tool 
as we go through different environments.
<br>
And then the following section, of course, we're going to be talking about utilizing Flyway: 
same concepts, different tool.
Each tool has their advantages and disadvantages, and we'll cover those. 