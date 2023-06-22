# instagramclone

1. **Download and Install MySQL Server and Workbench**: The first step involves downloading the MySQL server and Workbench on your machine. You can download these tools from the MySQL website. Once you've downloaded the installer, follow the on-screen instructions to install both MySQL Server and MySQL Workbench.

2. **Set Up Password and Login**: Once you've installed MySQL Server, you need to set up your password during the installation process. The default password is often 'password', but you should change this to something more secure.

3. **Login to the MySQL Server**: After setting up the password, open the terminal and log in to the MySQL server using the following command:

   ```
   mysql -u root -p
   ```

   This will prompt you for your password. Enter the password you set up during the installation.

4. **Create a Database**: Once you're in the MySQL server, you can create a new database for your application. Let's call this 'instagramclonedb'. You can create the database using the following command:

   ```
   create database instagramclonedb;
   ```

5. **Verify the Database Creation**: To check if your database was created successfully, run the following command:

   ```
   show databases;
   ```

   You should see 'instagramclonedb' in the list of databases.

6. **Setup the Connection to the MySQL Database in your Java Application**: Now, you need to set up the connection to your 'instagramclonedb' database from your Java application. Open the 'application.properties' file in your Java project and add the following lines:

   ```
   spring.jpa.hibernate.ddl-auto=update
   spring.datasource.url=jdbc:mysql://localhost:3306/instagramclonedb?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false
   spring.datasource.username=root
   spring.datasource.password=YourPassword
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   ```

   Replace 'YourPassword' with the password you set up for MySQL server.

And that's it! You have now successfully set up a MySQL database and connected it to your Java application. Remember to keep your MySQL Server password secure and don't share it with anyone.
