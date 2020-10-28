# Email Counter
Rest API for counting the number of unique emails in an input list

## Building the Jar file

#### Prerequisites 
(Commands provided assume that you are running Ubuntu, but links are provided for Windows installs)
-   This Project Requires [Java]: 
```shell script
sudo apt install openjdk-11-jdk
```
-   This Project Requires [Maven]:
```shell script
sudo apt install maven
```
#### Building 
-   From the repository's home directory (directory with the pom.xml file), run the following shell 
command (will also work in the windows command prompt):
```shell script
mvn clean package
```

## Running the Jar file
-   After downloading the Jar file located in the Repo's home directory or running the build steps, 
run the following run command on a terminal (or command prompt) in the directory with the jar file:
```shell script
java -jar email-counter-0.0.1-SNAPSHOT.jar
```

-   Access the Swagger Api Documentation page at this URL in your [browser]:
```
http://localhost:8080/swagger-ui.html
```

-   Navigate in the Swagger Api Doc page to "email-counter-controller" section to find the "/countUniqueEmails" endpoint
-   In the Parameters section input the following list into the "emailList" Value section:
```json
[
"dfastje.work@gmail.com",
"dfastje@gmail.com"
]
```

## Other Notes
Please see service method docs 


[Java]: https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA
[Maven]: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
[browser]:http://localhost:8080/swagger-ui.html