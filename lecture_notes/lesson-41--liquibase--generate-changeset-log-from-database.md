## Lesson 41 
#  Generate Changeset Log from Database

We'll set up a <span style="color:violet">Liquibase</span> to go ahead
and generate a changelog file from the database.
We'll use the <span style="color:violet">Liquibase</span> plugin
and specifically the goal <b>liquibase:generateChangeLog</b> out there.

### <span style="color:violet">Liquibase</span> <span style="color:cyan">Maven</span> goals list:

https://docs.liquibase.com/tools-integrations/maven/commands/home.html

### <span style="color:violet">Liquibase</span>:generateChangeLog Goal Documentation:

https://docs.liquibase.com/tools-integrations/maven/commands/maven-generatechangelog.html

<b>generateChangeLog<b> creates a changelog file that has a sequence of changesets 
which describe how to re-create the current state of the database.

### Plugin Configuration Attributes 

We'll add the following attributes to specify <b>generateChangeLog</b> settings in our
<plugin> section:

<li>outputChangeLogFile
<li>changeSetAuthor
<li>changeLogSchemaName

    <plugin>
        ...
        <artifactId>liquibase-maven-plugin</artefactId>
        ...
        <configuration>
            ...
            <outputChangeLogFile>lecture_notes/output_files/lesson-41--changelog.xml</outputChangeLogFile>
			<changeSetAuthor>SG</changeSetAuthor>
			<changeLogSchemaName>bookdb</changeLogSchemaName>
        </configuration>
        ...
    </plugin>

So now we are able to run the goal either from the <span style="color:cyan">maven</span> tool window 
of IntelliJ or from terminal with CLI: 

    mvn liquibase:generateChangeLog

to generate our change log file.