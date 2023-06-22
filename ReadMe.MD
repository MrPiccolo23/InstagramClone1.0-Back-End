# instagramclone

1. **Download and Install Eclipse IDE**: Eclipse is a widely-used IDE for Java development. To start, you'll need to download and install it on your machine. Visit the Eclipse website, download the installer, and follow the prompts to install it.

2. **Import the Maven Project**: Once Eclipse is installed, open it and follow these steps to import your project:

   a. Click on 'File' in the menu bar, and then select 'Import'.

   b. In the import window, type 'Maven' in the search box.

   c. Select 'Existing Maven Projects' from the options that appear, then click 'Next'.

   d. In the 'Root Directory' field, click 'Browse' and navigate to the location of your project on your machine (`C:\Users\Smith\Downloads\instagramclone`), then click 'Open'.

   e. Once the project is listed in the 'Projects' box, click 'Finish'.

   After these steps, Eclipse will download the Maven dependencies for your project.

3. **Open Project Explorer**: To view your project's files, go to 'Window' on the menu bar, then 'Show View', and finally select 'Project Explorer'.

4. **Run the Application**: In the 'Project Explorer' pane, expand the 'instagramclone' project, then navigate to `src/main/java > com.technicalinterview.instagramclone > InstagramcloneApplication.java`.

a. Right-click on 'InstagramcloneApplication.java', hover over 'Run As', and click 'Java Application'.

The application should now start, and you will see log output in the 'Console' pane in Eclipse. If everything is set up correctly, you should see a message indicating that Tomcat started on port 8080, and that your application has started running. The log will look something like this:

```
2023-06-22T10:35:25.674+01:00  INFO 9868 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-06-22T10:35:25.685+01:00  INFO 9868 --- [           main] c.t.i.InstagramcloneApplication          : Started InstagramcloneApplication in 8.544 seconds (process running for 9.421)
```

Remember, you can view your application by navigating to `localhost:8080` in your web browser, assuming the application has started without any issues.

5. **Download and Install MySQL Server and Workbench**: The first step involves downloading the MySQL server and Workbench on your machine. You can download these tools from the MySQL website. Once you've downloaded the installer, follow the on-screen instructions to install both MySQL Server and MySQL Workbench.

6. **Set Up Password and Login**: Once you've installed MySQL Server, you need to set up your password during the installation process. The default password is often 'password', but you should change this to something more secure.

7. **Login to the MySQL Server**: After setting up the password, open the terminal and log in to the MySQL server using the following command:

   ```
   mysql -u root -p
   ```

   This will prompt you for your password. Enter the password you set up during the installation.

8. **Create a Database**: Once you're in the MySQL server, you can create a new database for your application. Let's call this 'instagramclonedb'. You can create the database using the following command:

   ```
   create database instagramclonedb;
   ```

9. **Verify the Database Creation**: To check if your database was created successfully, run the following command:

   ```
   show databases;
   ```

   You should see 'instagramclonedb' in the list of databases.

10. **Setup the Connection to the MySQL Database in your Java Application**: Now, you need to set up the connection to your 'instagramclonedb' database from your Java application. Open the 'application.properties' file in your Java project and add the following lines:

```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/instagramclonedb?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false
spring.datasource.username=root
spring.datasource.password=YourPassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Replace 'YourPassword' with the password you set up for MySQL server.

And that's it! You have now successfully set up a MySQL database and connected it to your Java application. Remember to keep your MySQL Server password secure and don't share it with anyone.
