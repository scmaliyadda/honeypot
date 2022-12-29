**HoneypotWeb**

This is a honeypot webservice that accepts all GET requests and replies very slowly (every 5 seconds) with an infinite stream of text.

This application built using spring webflux, java8 and maven. Tested in a macbook environment locally.

Prerequisite: java8, maven and docker installed environment

**How to build and run**
1. Go to the project root folder using a terminal
2. execute maven build command : "mvn clean package"
3. build docker image command: "docker build -t honeypotimage:1 ."
4. run container: "docker run -d --name honeypotimage -p 8080:8080 honeypotimage:1"
5. verify the whater the container built successfully: "docker ps -a | grep honeypotimage"
6. verify the honeypot webservice using curl command. : "curl 'http://localhost:8080/dfd'"


* If you do not have docker installed:
Follow above step #1 and #2 and run the following command
"java -jar target/honeypot-0.0.1-SNAPSHOT.jar"

**How it works**

This is a reactive and fully non-blocking service built on http later because of spring webflux usage.
Used server sent events (SSE) text stream response for all get APis. 
SSE used for unidirectional communication between client and server 
and websockets haven't used here because bidirectional communication do not needed in the honeypot.

Controller of this webservice accept any get request and forward the request to service layer.
Service build the SSE response and send to controller to respond to client.

**Limitations and Improvements can be done**

1. This webservice accepts millions of concurrent requests as per the spring webfulx support.

2. A rate limitter should be added in-front of this application to avoid DDoS attacks or avoid performance issues when access too many bots.

3. This can be improved adding more functions to service layer such as logging requests info and identify hackers and block for future attack preventions.