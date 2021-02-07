# mgWebCrawler

 # verview:

This is deep web crawler which is exposed as REST Service and have basic HTTP authentication.This service will access the URL provided in YAML file and perform deep crawling. All the configuration environment variables are excessed through application.yaml file. Maximum allowed depth for the service is passed through YAML file like other variables and that is used to prevent accidental high depth queries. This crawler will provide the following response fields Url, Valid  - Boolean, tite, lists of child modes, and maximum allowed depth
		

## Implementation:

 This is JAVA project implemented as Spring Boot, Maven, JSOUP and Swagger2

## Building the program

The following is required inorder to build and run this mgWebCrawler program
 . Java 11 JDK
 . Jsoup 1.13.x
 . Maven 3.2+
    Note:  Actual version may vary depending upon your current version
		
## Steps to run

    . Build this project in your loacal machine then Run 
	  . Build the project using mvn clean install
	  . Run using mvn run
		. The web application is accessible via localhost:8800

## Swagger End Point:

     http://localhost:8800/mg-crawler/swagger-ui.html.

## Service End point :

    http://localhost:8800/mg-crawler-service/swagger-ui.html.

  ## TODO
	 - Add more Unit Test coverage 
	 - Code Refactor
