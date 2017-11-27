# Ashwin's UK Forum
A forum web application for posting articles and comments.

# Features
- Log in with a pre-defined username and password (writer / writer123). This username is also and **Administrator**
- Additional users, who have no administrative rights, are ashwin/ashwin, and phoebe/phoebe.
- Go to *All Articles* from any page to see all posted articles by all users
- Go to *My Articles* from any page to see all posted articles by the current logged in user
- For each Article, click *See comments for this article* to see its associated comments
- In each Article, when logged in, click *Add your comment* to comment on the current article
- If the current logged in user is the writer of the article, then they can delete the article
- If the current logged in user is an Administrator, they will see a button to **Manage Articles**

# Project Structure
1. The User, Article, and Comment objects are defined in the project's **com.ashwin.ukforum.model** package
2. The Data Access logic for the User, Article, and Comment objects are defined in the project's **com.ashwin.ukforum.dao** package
3. The Data Interaction Logic for User, Article, and Comment objects are defined in the project's **com.ashwin.ukforum.service** package
4. The Request and Response handlers for the User, Article, and Comment objects are defined in the project's **com.ashwin.ukforum.controller** package. This package addionally includes a `LoginController` to handle request for Logging in and out.
5. For utilization of the built-in authentication mechanisms of the Java Spring library, the Spring Security dependency was used which faciliates the logging in and out of user as well as the restriction of visitors and users from certain pages.
-- Spring Security was used to restrict non-authenticated users from creating and Article and posting a Comment. They are only able to do so once they have logged in. It was also used to define User roles such as *Administrator*.

# Installation and Configuration

## Requirements:
- Java EE IDE such as Eclipse for running the project
- JDK 8
- Maven for project configuration and dependency management. Maven commands can be run from a Command Line Interface or through Eclipse.
- MySQL database. This can be stand alone or through a bundled package, such as WAMP for Windows or MAMP on macOS.
- Apache Tomcat 7.x web server
- Web server, such as Apache Tomcat 8.0 (tested only on Tomcat, probably works on other web servers too, maybe requires minor modifications).

1. Obtain the project source files through Git (`git clone git@github.com:ashwinsoerdien/ashwin-uk-forum.git`) or download and extract the zip archive).
2. Modify the configuration as needed for your MySQL database
- Database Properties: Find these in: `src/main/resources/application.properties`. Modify the database URL and port accordingly to your environment.
- Run the `db_init.sql` file inside any MySQL editor to initialize the database with some initial users and articles.

3. Run the Maven `verify` goal, either in the IDE or through the command line, `$ mvn verify` from the project's directory. This will download all dependencies, and build the WAR file. Check Maven output to see if all tests and build are completed successfully.
4. Running the project:
- Using and IDE: Run the project by selecting Build Maven...>
- Deploy the compiled WAR file, found in `src/main/java/` in the Apache Tomcat server
6. Go to `http://your-server-address:8080/` (if deployed with default Tomcat settings) to check and ensure the forum web app is working.
