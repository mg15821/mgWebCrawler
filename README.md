# mgWebCrawler

Overview:
This is deep web crawler which is exposed as REST Service and have basic HTTP authentication.

Implementation:
 This is JAVA project implemented as Spring Boot, Maven, JSOUP and Swagger2

Building the program
The following is required inorder to build and run this mgWebCrawler program
 . Java 11 JDK
 . Jsoup 1.13.x
 . latest Maven
    Note:  Actual version may vary depending upon your current version
    
Build this project to you  machine then Run 
 . mvn clean install
 . mvn run
 
Running Program in Local:

This service is available at :  
   http://localhost:8800/

Swagger End Point:
     http://localhost:8800/mg-crawler/swagger-ui.html.

Service End point :
    http://localhost:8800/mg-crawler-service/swagger-ui.html.

Additional Note:
    Maximum allowed depth for the service is used to prevent accidental high depth queries
