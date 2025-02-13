## Lesson 40 
#  <span style="color:violet">Liquibase</span> <span style="color:cyan">Maven</span> plugin

### The <span style="color:violet">Liquibase</span> maven integration documentation home:

https://docs.liquibase.com/tools-integrations/maven/home.html

### Using <span style="color:violet">Liquibase</span> and your <span style="color:cyan">maven</span> POM File:

https://docs.liquibase.com/tools-integrations/maven/maven-pom-file.html

### <span style="color:violet">Liquibase</span> <span style="color:cyan">maven</span> plugin section in POM-file example:

    <plugin>
        <groupId>org.liquibase</groupId>
		    <artifactId>liquibase-maven-plugin</artifactId>
				<configuration>
					<propertyFileWillOverride>false</propertyFileWillOverride>
					<url>jdbc:mysql://127.0.0.1:3306/bookdb?useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=UTC</url>
					<username>bookadmin</username>
					<password>password</password>
				</configuration>
				<dependencies>
					<dependency>
						<groupId>com.mysql</groupId>
						<artifactId>mysql-connector-j</artifactId>
					</dependency>
				</dependencies>
			</plugin>

Note we have the password being set up here as plain text. Obviously we would
do want to configure the password in a much more secure way.
But now it is quite good to define the password directly in pom.xml as
we've been using it as a part of our learning process.

So this is what allows <span style="color:violet">Liquibase</span>, or <span style="color:violet">Liquibase</span> plugin 
to connect to the database using MySQL JDBC driver.

Though it is recommended to use the most recent version of the <span style="color:violet">Liquibase</span> plugin,
and we can check it out on the <span style="color:cyan">maven</span> repository site:

https://mvnrepository.com/artifact/org.liquibase/liquibase-maven-plugin

Still the best practise is to inherit version from spring boot parent dependencies.
We can view the effective pom using right-mouse-click -> show effective pom 
while in the pom.xml.
And the Spring team has already prepared the list of versions for dependencies out there.
And what we would have to do just to specify the necessary dependency version as

    <version>${<groupId>}</version>

for the dependency in our plugin section.

And here I will get stuck into the problem describing the mysql version
as ${mysql.version} because it is defined as 9.1.0.
But:
<br>
MySQL's complexity 😄 In MySQL Connector/J 9, 
they removed com.mysql.cj.jdbc.Driver because 
they switched to a new API based on Service Provider Interface (SPI). 
Now, the driver is supposed to be automatically detected 
via META-INF/services/, but Spring Boot and Liquibase don’t expect this change.
<br>
In short:
<li>Spring Boot 2.x / 3.x and Liquibase expect com.mysql.cj.jdbc.Driver.
<li>MySQL Connector/J 9.x removed it.
<li>The best option is to stick with 8.x (e.g., 8.4.0).
<li>Upgrading to 9.x right now only causes headaches without any benefits.

### Defining own <span style="color:cyan">Maven</span> property

We can define our own <span style="color:cyan">Maven</span> property 
in the <properties> section of the pom.xml.

    <properties>
        <mysql-connector.version>8.4.0</mysql-connector.version>
    </properties>

and then we can apply this property to out dependency:

    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>${mysql-connector.version}</version>
    </dependency>









