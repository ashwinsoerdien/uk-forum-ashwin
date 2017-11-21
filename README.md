# Ashwin's UK Forum
A forum web app for posting articles and comments.

Features:
- Log in with a pre-defined username and password (writer / writer123)
- Go to *All Articles* from any page to see all posted articles by all users
- Go to *My Articles* from any page to see all posted articles by the current logged in user
- For each Article, click *See comments for this article* to see its associated comments
- In each Article, when logged in, click *Add your comment* to comment on the current article
- If the current logged in user is the writer of the article, then they can delete the article

# Project Structure
The User, Article, and Comment objects are defined in the project's *com.ashwin.ukforum.model* package
The Data Access logic for the User, Article, and Comment objects are defined in the project's *com.ashwin.ukforum.dao* package
The Data Interaction Logic for User, Article, and Comment objects are defined in the project's *com.ashwin.ukforum.service* package
The Request and Response handlers for the User, Article, and Comment objects are defined in the project's *com.ashwin.ukforum.controller* package. This package addionally includes a `LoginController` to handle request for Logging in and out.

#Installation and Configuration

Requirements:
- Java EE IDE such as Eclipse
- JDK 8
- Maven project configuration tool. This can be stand alone or run through Eclipse
- MySQL database. This can be stand alone or through a dynamic server environment such as WAMP or MAMP.
- Apache Tomcat 7.x web server
- Web server, such as Apache Tomcat 8.0 (tested only on Tomcat, probably works on other web servers too, maybe requires minor modifications).

1. Obtain the project source files (`git clone` or download and extract zip archive).
2. Modify the configuration as needed:
- Database Properties: 

Find these in: `src/main/resources/application.properties`
```
database.driver=com.mysql.jdbc.Driver
database.url=jdbc:mysql://localhost:8889/ashwinukforum
database.user=root
database.password=root
```

3. Run Maven `verify` goal. This will download all dependencies, and build the WAR file. Check Maven output to see if all tests and build are completed successfully.
4. Deploy the WAR file to Apache Tomcat
6. Go to `http://your-server-address/` (if deployed with default Tomcat settings) to see if it is working.
