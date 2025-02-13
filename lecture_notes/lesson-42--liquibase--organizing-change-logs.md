## Lesson 42 
#  Organizing Change Logs


The <span style="color:violet">Liquibase</span> documentations about changeLog best practices:

https://docs.liquibase.com/concepts/bestpractices.html

The <span style="color:violet">Liquibase</span> best practices as organizing ChangeLog.
So what we want to point out here
that they are recommending a <b>directory structure</b>
and then we have a <b>changeLog master</b> that references it.  
<br>here we can see that we have a <b>directory structure and inside
changeLog files. There are N+1 files: one master changeLog and
N of different changeSets.
<br>
So we have database changeLog master,
we cn see that this one master file references the other files
containing actually changeSets. So as we accumulate changes,
every change that we add to the database would be a new file and get added
to the master file.

What we will do is create a directory in our resource directory:

[changelog](../src/main/resources/db/changelog)

    /resources ➝
        /db ➝
            /changelog

So now we can add to our changelog has already been created
with <code>mvn liquibase:generateChangeLog</code> plugin.
We just grab it to <code>/resource/db/changelog</code> and paste to be renamed to:

[baseline-changelog.xml](../src/main/resources/db/changelog/changelog-baseline.xml)

as describing the current known, or baseline, state
of the database.
<br>So now we paste the additional baseline changeLog copy just to have the necessary
<code><?xml/></code> and <code><databaseChangeLog/></code> tags filled with the necessary attributes brought up.
The name this copy as

[changelog-master.xml](../src/main/resources/db/changelog/changelog-master.xml)

remove the content of <databaseChangeLog> tag
and include the reference to that to <code>changelog-master.xml</code>:

	<include file=".db/changelog/baseline-changelog.xml"/>

<br>
Now, we added the <span style="color:violet">Liquibase</span> change log section to our project structure,
But if we start running Spring Boot, it's going to ignore these files
right now because we do have a few more steps to configure utilizing <span style="color:violet">Liquibase</span>.
	